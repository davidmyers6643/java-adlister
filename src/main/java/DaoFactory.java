//public class DaoFactory {
//    private static Ads adsDao;
//
//    public static Ads getAdsDao() {
//        if (adsDao == null) {
//            adsDao = new ListAdsDao();
//        }
//        return adsDao;
//    }
//}


//public class DaoFactory {
//
//    private static Ads adsDao;
//
//    public static Ads getAdsDao() {
//        if (adsDao == null) {
//            adsDao = new MySQLAdsDao();
//        }
//        return adsDao;
//    }
//}




//public class DaoFactory {
//    private static Ads adsDao;
//    private static Config config = new Config();
//
//    public static Ads getAdsDao() {
//        if (adsDao == null) {
//            adsDao = new MySQLAdsDao(config);
//        }
//        return adsDao;
//    }
//}

public class DaoFactory {
    private static Ads adsDao;
    private static Albums albumsDao;
    private static Config albumsConfig = new Config();

    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new ListAdsDao();
        }
        return adsDao;
    }

    public static Albums getAlbumsDao() {
        if (albumsDao == null) {
            albumsDao = new MySQLAlbumsDao(albumsConfig);
        }
        return albumsDao;
    }
}