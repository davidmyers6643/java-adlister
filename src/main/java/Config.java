//public class Config {
//
//    private static String user = "root";
//    private static String password = "codeup";
//    private static String url ="jdbc:mysql://localhost/adlister_db?serverTimezone=UTC&useSSL=false";
//
//
//    public static String getUser() {
//        return user;
//    }
//
//    public static void setUser(String user) {
//        Config.user = user;
//    }
//
//    public static String getPassword() {
//        return password;
//    }
//
//    public static void setPassword(String password) {
//        Config.password = password;
//    }
//
//    public static String getUrl() {
//        return url;
//    }
//
//    public static void setUrl(String url) {
//        Config.url = url;
//    }
//}


public class Config {
    public String getUrl() {
        return "jdbc:mysql://localhost/codeup_test_db?serverTimezone=UTC&useSSL=false";
    }

    public String getUsername() {
        return "root";
    }

    public String getPassword() {
        return "codeup";
    }
}
