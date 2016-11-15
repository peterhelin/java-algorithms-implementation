package wangkang;

import com.jwetherell.algorithms.numbers.Integers;

import java.util.*;

/**
 * Author: helin <1006604973@qq.com>.
 * Date: 14/11/2016 12:23
 */

public class MetroLine4 {
    static Integer n = 1;
    static List<Station> stations = new ArrayList<>();
    static public List<String> staNameList = new ArrayList<>();
    static Map<Integer, String> mapOfStaNumInAllAndItsNam = new HashMap<>();
    static Map<String, Integer> mapOfStaNamAndItsNumInAll = new HashMap<>();
    static List<Integer> initList = new ArrayList<>();


    enum Line4 {
        安河桥北(Station.Type.ENDPOINT, "北宫门", 1, 2, 1363),
        北宫门(Station.Type.NORMAL, "西苑", 2, 3, 1251),
        西苑(Station.Type.NORMAL, "圆明园", 3, 4, 1672),
        圆明园(Station.Type.NORMAL, "北京大学东门", 4, 5, 1295),
        北京大学东门(Station.Type.NORMAL, "中关村", 5, 6, 887),
        中关村(Station.Type.NORMAL, "海淀黄庄", 6, 7, 900),
        海淀黄庄(Station.Type.TRANSFER, "人民大学", 7, 8, 1063),
        人民大学(Station.Type.NORMAL, "魏公村", 8, 9, 1051),
        魏公村(Station.Type.NORMAL, "国家图书馆", 9, 10, 1658),
        国家图书馆(Station.Type.TRANSFER, "动物园", 10, 11, 1517),
        动物园(Station.Type.NORMAL, "西直门", 11, 12, 1441),
        西直门(Station.Type.TRANSFER, "新街口", 12, 13, 1025),
        新街口(Station.Type.NORMAL, "平安里", 13, 14, 1100),
        平安里(Station.Type.TRANSFER, "西四", 14, 15, 1100),
        西四(Station.Type.NORMAL, "灵境胡同", 15, 16, 869),
        灵境胡同(Station.Type.NORMAL, "西单", 16, 17, 1011),
        西单(Station.Type.TRANSFER, "宣武门", 17, 18, 815),
        宣武门(Station.Type.TRANSFER, "菜市口", 18, 19, 1152),
        菜市口(Station.Type.TRANSFER, "陶然亭", 19, 20, 1200),
        陶然亭(Station.Type.NORMAL, "北京南站", 20, 21, 1643),
        北京南站(Station.Type.TRANSFER, "马家堡", 21, 22, 1480),
        马家堡(Station.Type.NORMAL, "角门西", 22, 23, 827),
        角门西(Station.Type.TRANSFER, "公益西桥", 23, 24, 989),
        公益西桥(Station.Type.ENDPOINT, "", 24, 0, 0);

        private Station.Type type;
        private String nameOfNextSta;//name of next station
        private Integer staNumInLine4; //station number in line 4
        private Integer staNumOfNextStaInDown;//station number of next station in downstream, 0 if it is the last station
        private int disToNextStaInDown;//distance to next station in downstream


        Line4(Station.Type type, String nameOfNextSta, Integer staNumInLine4, Integer staNumOfNextStaInDown, int disToNextStaInDown) {
            this.type = type;
            this.nameOfNextSta = nameOfNextSta;
            this.staNumInLine4 = staNumInLine4;
            this.staNumOfNextStaInDown = staNumOfNextStaInDown;
            this.disToNextStaInDown = disToNextStaInDown;
        }

        public Station.Type getType() {
            return type;
        }

        public String getNameOfNextSta() {
            return nameOfNextSta;
        }

        public Integer getStaNumInLine4() {
            return staNumInLine4;
        }

        public Integer getStaNumOfNextStaInDown() {
            return staNumOfNextStaInDown;
        }

        public int getDisToNextStaInDown() {
            return disToNextStaInDown;
        }

        public static void addToStationList() {
            Line4[] line4 = Line4.values();
            Arrays.stream(line4).forEach(
                    sta -> {
                        String staName = sta.name();
                        if (!staNameList.contains(staName)) {
                            mapOfStaNumInAllAndItsNam.put(n, staName);
                            mapOfStaNamAndItsNumInAll.put(staName, n);

                            staNameList.add(staName);
                            stations.add(new Station(sta.type, sta.name(), n++));
                        }
                    }
            );
        }


        private static String getDownStaNamByOrdinal(Integer ordinal) {
            return Line4.values()[ordinal].name();
        }

        public static int getDownStaNumInAllByStaNumInAll(Integer numInAll) {
//            String name = mapOfStaNumInAllAndItsNam.get(numInAll);
//            Line4 line4 = Line4.valueOf(name);
//            Integer i = line4.ordinal();
//            String downStaNam = getDownStaNamByOrdinal(i + 1);
//            System.out.println(downStaNam);
            return mapOfStaNamAndItsNumInAll
                    .get(getDownStaNamByOrdinal(Line4.valueOf(mapOfStaNumInAllAndItsNam.get(numInAll)).ordinal() + 1));
        }

    }


    enum Line10 {
        巴沟(Station.Type.ENDPOINT, "苏州街", 1, 2, 1110),
        苏州街(Station.Type.NORMAL, "海淀黄庄", 2, 3, 950),
        海淀黄庄(Station.Type.TRANSFER, "知春里", 3, 4, 975),
        知春里(Station.Type.NORMAL, "知春路", 4, 5, 1058),
        知春路(Station.Type.NORMAL, "西土城", 5, 6, 1101),
        西土城(Station.Type.NORMAL, "牡丹园", 6, 7, 1330),
        牡丹园(Station.Type.NORMAL, "健德门", 7, 8, 973),
        健德门(Station.Type.NORMAL, "北土城", 8, 9, 1100),
        北土城(Station.Type.NORMAL, "安贞门", 9, 10, 1020),
        安贞门(Station.Type.NORMAL, "惠新西街南口", 10, 11, 982),
        惠新西街南口(Station.Type.NORMAL, "芍药居", 11, 12, 1712),
        芍药居(Station.Type.NORMAL, "太阳宫", 12, 13, 1003),
        太阳宫(Station.Type.NORMAL, "三元桥", 13, 14, 1759),
        三元桥(Station.Type.NORMAL, "亮马桥", 14, 15, 1506),
        亮马桥(Station.Type.NORMAL, "农业展览馆", 15, 16, 914),
        农业展览馆(Station.Type.NORMAL, "团结湖", 16, 17, 853),
        团结湖(Station.Type.NORMAL, "呼家楼", 17, 18, 1149),
        呼家楼(Station.Type.NORMAL, "金台夕照", 18, 19, 734),
        金台夕照(Station.Type.NORMAL, "国贸", 19, 20, 835),
        国贸(Station.Type.NORMAL, "双井", 20, 21, 1759),
        双井(Station.Type.NORMAL, "劲松", 21, 22, 1006),
        劲松(Station.Type.NORMAL, "潘家园", 22, 23, 1021),
        潘家园(Station.Type.NORMAL, "十里河", 23, 24, 1097),
        十里河(Station.Type.NORMAL, "分钟寺", 24, 25, 1804),
        分钟寺(Station.Type.NORMAL, "成寿寺", 25, 26, 1058),
        成寿寺(Station.Type.NORMAL, "宋家庄", 26, 27, 1677),
        宋家庄(Station.Type.NORMAL, "石榴庄", 27, 28, 1269),
        石榴庄(Station.Type.NORMAL, "大红门", 28, 29, 1244),
        大红门(Station.Type.NORMAL, "角门东", 29, 30, 1130),
        角门东(Station.Type.NORMAL, "角门西", 30, 31, 1254),
        角门西(Station.Type.NORMAL, "草桥", 31, 32, 1688),
        草桥(Station.Type.NORMAL, "纪家庙", 32, 33, 1547),
        纪家庙(Station.Type.NORMAL, "首经贸", 33, 34, 1143),
        首经贸(Station.Type.NORMAL, "丰台站", 34, 35, 1717),
        丰台站(Station.Type.NORMAL, "泥洼", 35, 36, 954),
        泥洼(Station.Type.NORMAL, "西局", 36, 37, 749),
        西局(Station.Type.NORMAL, "六里桥", 37, 38, 1584),
        六里桥(Station.Type.NORMAL, "莲花桥", 38, 39, 2392),
        莲花桥(Station.Type.NORMAL, "公主坟", 39, 40, 1016),
        公主坟(Station.Type.NORMAL, "西钓鱼台", 40, 41, 2386),
        西钓鱼台(Station.Type.NORMAL, "慈寿寺", 41, 42, 1214),
        慈寿寺(Station.Type.NORMAL, "车道沟", 42, 43, 1590),
        车道沟(Station.Type.NORMAL, "长春桥", 43, 44, 1205),
        长春桥(Station.Type.NORMAL, "火器营", 44, 45, 961),
        火器营(Station.Type.ENDPOINT, "巴沟", 45, 46, 1495);

        private Station.Type type;
        private String staName;//station name
        private Integer staNumInLine7; //station number in line 4
        private Integer staNumOfNextStaInDown;//station number of next station in downstream, 0 if it is the last station
        private int disToNextStaInDown;//distance to next station in downstream

        Line10(Station.Type type, String staName, Integer staNumInLine7, Integer staNumOfNextStaInDown, int disToNextStaInDown) {
            this.type = type;
            this.staName = staName;
            this.staNumInLine7 = staNumInLine7;
            this.staNumOfNextStaInDown = staNumOfNextStaInDown;
            this.disToNextStaInDown = disToNextStaInDown;
        }

        public Station.Type getType() {
            return type;
        }

        public String getStaName() {
            return staName;
        }

        public Integer getStaNumInLine7() {
            return staNumInLine7;
        }

        public Integer getStaNumOfNextStaInDown() {
            return staNumOfNextStaInDown;
        }

        public int getDisToNextStaInDown() {
            return disToNextStaInDown;
        }

        static public void addToStationList() {
            Line10[] line10 = Line10.values();
            Arrays.stream(line10).forEach(
                    sta -> {
                        String staName = sta.name();
                        if (!staNameList.contains(staName)) {
                            staNameList.add(staName);
                            mapOfStaNumInAllAndItsNam.put(n, staName);
                            mapOfStaNamAndItsNumInAll.put(staName, n);
                            stations.add(new Station(sta.type, sta.name(), n++));
                        }
                    }
            );
        }

        private static String getDownStaNamByOrdinal(Integer ordinal) {
            return Line10.values()[ordinal].name();
        }

        public static int getDownStaNumInAllByStaNumInAll(Integer numInAll) {
            String name = mapOfStaNumInAllAndItsNam.get(numInAll);
            Line4 line4 = Line4.valueOf(name);
            Integer i = line4.ordinal();
            String downStaNam = getDownStaNamByOrdinal(i + 1);
            System.out.println(downStaNam);
            return mapOfStaNamAndItsNumInAll
                    .get(getDownStaNamByOrdinal(Line10.valueOf(mapOfStaNumInAllAndItsNam.get(numInAll)).ordinal() + 1));
        }
    }

    void init(int... ints) {
        Arrays.stream(ints).forEach(
                i -> {
                    initList.add(i);
                    System.out.println("init line: " + i);
                    if (i == 4)
                        Line4.addToStationList();
                    if (i == 10)
                        Line10.addToStationList();
                }
        );
    }

    public List<Station> getStationList() {
        return stations;
    }

    public List<Integer> getDownStas(Integer value) {
        List<Integer> list = new ArrayList<>();
        String name = mapOfStaNumInAllAndItsNam.get(value);//获取车站名称

        initList.stream().forEach(
                i -> {
                    switch (i) {
                        case 4:
                            if (Line4.valueOf(name) == null)
                                return;
                            list.add(Line4.getDownStaNumInAllByStaNumInAll(value));
                            break;
                        case 10:
                            list.add(Line10.getDownStaNumInAllByStaNumInAll(value));
                            break;
                        default:
                            break;
                    }
                }
        );

        return list;
    }
}
