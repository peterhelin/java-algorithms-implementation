//package wangkang;
//
//
///**
// * Author: helin <1006604973@qq.com>.
// * Date: 13/11/2016 11:14
// */
//
//public enum Line4 {
//    安河桥北(1, 2, 1363),
//    北宫门(2, 3, 1251),
//    西苑(3, 4, 1672),
//    圆明园(4, 5, 1295),
//    北京大学东门(5, 6, 887),
//    中关村(6, 7, 900),
//    海淀黄庄(7, 8, 1063),
//    人民大学(8, 9, 1051),
//    魏公村(9, 10, 1658),
//    国家图书馆(10, 11, 1517),
//    动物园(11, 12, 1441),
//    西直门(12, 13, 1025),
//    新街口(13, 14, 1100),
//    平安里(14, 15, 1100),
//    西四(15, 16, 869),
//    灵境胡同(16, 17, 1011),
//    西单(17, 18, 815),
//    宣武门(18, 19, 1152),
//    菜市口(19, 20, 1200),
//    陶然亭(20, 21, 1643),
//    北京南站(21, 22, 1480),
//    马家堡(22, 23, 827),
//    角门西(23, 24, 989),
//    公益西桥(24, 0, 0);
//
//    private Integer staIndex;
//    private Integer to;
//    private int disatce;
//
//    private final static int staCouOfLine4 = 24;
//
//    public static int getStaCouOfLine4() {
//        return staCouOfLine4;
//    }
//
//    Line4(Integer staIndex, Integer to, int distance) {
//        this.staIndex = staIndex;
//        this.to = to;
//        this.disatce = distance;
//
//    }
//
//    public Integer getStaIndex() {
//        return staIndex;
//    }
//
//    public Integer getTo() {
//        return to;
//    }
//
//    public int getDisatce() {
//        return disatce;
//    }
//
//    public static Integer getStartStationName() {
//        return 安河桥北.staIndex;
//    }
//
//    public static Integer getEndStationName() {
//        return 角门西.staIndex;
//    }
//
//    static public Line4 getStartEdgeFromStation() {
//        return 安河桥北;
//    }
//
//    static public Line4 getEndEdgeFromStation() {
//        return 角门西;
//    }
//}
//
//
//
