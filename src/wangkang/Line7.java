//package wangkang;
//
//import com.jwetherell.algorithms.data_structures.Graph;
//
//import java.util.List;
//
///**
// * Author: helin <1006604973@qq.com>.
// * Date: 13/11/2016 13:55
// */
//public enum Line7 {
//    巴沟(1, 2, 1110),
//    苏州街(2, 3, 950),
//    海淀黄庄(3, 4, 975),
//    知春里(4, 5, 1058),
//    知春路(5, 6, 1101),
//    西土城(6, 7, 1330),
//    牡丹园(7, 8, 973),
//    健德门(8, 9, 1100),
//    北土城(9, 10, 1020),
//    安贞门(10, 11, 982),
//    惠新西街南口(11, 12, 1712),
//    芍药居(12, 13, 1003),
//    太阳宫(13, 14, 1759),
//    三元桥(14, 15, 1506),
//    亮马桥(15, 16, 914),
//    农业展览馆(16, 17, 853),
//    团结湖(17, 18, 1149),
//    呼家楼(18, 19, 734),
//    金台夕照(19, 20, 835),
//    国贸(20, 21, 1759),
//    双井(21, 22, 1006),
//    劲松(22, 23, 1021),
//    潘家园(23, 24, 1097),
//    十里河(24, 25, 1804),
//    分钟寺(25, 26, 1058),
//    成寿寺(26, 27, 1677),
//    宋家庄(27, 28, 1269),
//    石榴庄(28, 29, 1244),
//    大红门(29, 30, 1130),
//    角门东(30, 31, 1254),
//    角门西(31, 32, 1688),
//    草桥(32, 33, 1547),
//    纪家庙(33, 34, 1143),
//    首经贸(34, 35, 1717),
//    丰台站(35, 36, 954),
//    泥洼(36, 37, 749),
//    西局(37, 38, 1584),
//    六里桥(38, 39, 2392),
//    莲花桥(39, 40, 1016),
//    公主坟(40, 41, 2386),
//    西钓鱼台(41, 42, 1214),
//    慈寿寺(42, 43, 1590),
//    车道沟(43, 44, 1205),
//    长春桥(44, 45, 961),
//    火器营(45, 46, 1495);
//
//    private Integer getStaIndex;
//    private Integer to;
//    private Integer disatce;
//    private static final int staCouOfLine7 = 45;
//
//    public static int getStaCouOfLine7() {
//        return staCouOfLine7;
//    }
//
//    Line7(Integer getStaIndex, Integer to, int distance) {
//        this.getStaIndex = getStaIndex;
//        this.to = to;
//        this.disatce = distance;
//    }
//
//    static public Line7 getStartEdgeFromStation() {
//        return 巴沟;
//    }
//
//    static public Line7 getEndEdgeFromStation() {
//        return 火器营;
//    }
//
//    public Integer getStaIndex() {
//        return getStaIndex;
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
//        return getStartEdgeFromStation().getStaIndex;
//    }
//
//    public static Integer getEndStationName() {
//        return getEndEdgeFromStation().to;
//    }
//}
