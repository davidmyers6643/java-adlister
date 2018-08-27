//import java.util.*;
//import java.sql.*;
//import com.mysql.cj.jdbc.Driver;
//
//public class MySQLAdsDao implements Ads {
//
//    private Connection connection = null;
//
//    public MySQLAdsDao() {
//        try {
//            DriverManager.registerDriver(new Driver());
//            connection = DriverManager.getConnection(
//                    Config.getUrl(),
//                    Config.getUser(),
//                    Config.getPassword()
//            );
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public List<MySQLAdsDao> all() {
//        return null;
//    }
//
//    @Override
//    public Long insert(Ad mySQLAdsDao) {
//        return null;
//    }
//}




//    INSERT INTO ads (id, , )
//    VALUES (0001, 'mgr', 'overall');



import com.mysql.cj.jdbc.Driver;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {

    private Connection conn;

    public MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            this.conn = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Ad> all() {
        try {
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM ads";
            ResultSet rs = stmt.executeQuery(query);
            return createAdList(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Problem in all method of MySQLAdsDao!");
        }

    }

    @Override
    public Long insert(Ad ad) {
        try {
            Statement stmt = conn.createStatement();
            String query = String.format("INSERT INTO ads (user_id, title, description) VALUES(%d, '%s', '%s')",
                    ad.getUserId(),
                    ad.getTitle(),
                    ad.getDescription()
            );
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            generatedKeys.next();
            return generatedKeys.getLong(1);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Something went wrong in insert method of MySQLAdsDao");
        }
    }

    private List<Ad> createAdList(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(new Ad(
                    rs.getLong("id"),
                    rs.getLong("user_id"),
                    rs.getString("title"),
                    rs.getString("description"))
            );
        }
        return ads;
    }

}