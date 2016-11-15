package wangkang;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: helin <1006604973@qq.com>.
 * Date: 13/11/2016 13:55
 */
public class MetroLine10 extends MetroLine {

    final private Integer lineNum = 4;
    static List<Station> stationList = new ArrayList<>();
    static List<Integer> distanceList = new ArrayList<>();
    static MetroLine10 instance;

    private MetroLine10() {
    }

    static public MetroLine10 getInstance() {
        if (instance == null)
            return new MetroLine10();
        else return instance;
    }


    @Override
    public List<Station> getStationList() {
        return stationList;
    }

    @Override
    public List<Integer> getDistanceList() {
        return distanceList;
    }

    @Override
    public String getNextStaName(String staName) {
        return StationEnum.valueOf(staName).nameOfNextSta;
    }

    @Override
    public Station.Type getStaType(String staName) {
        return StationEnum.valueOf(staName).type;
    }

    @Override
    public Integer getDisToNextStaInDO(String staName) {
        return StationEnum.valueOf(staName).disToNextStaInDown;
    }

    @Override
    public void build() {
        MetroBuilder.buildLine(StationEnum.values(), getInstance());
    }


    private enum StationEnum {
        巴沟(Station.Type.ENDPOINT, "苏州街", 1110),
        苏州街(Station.Type.NORMAL, "海淀黄庄", 950),
        海淀黄庄(Station.Type.TRANSFER, "知春里", 975),
        知春里(Station.Type.NORMAL, "知春路", 1058),
        知春路(Station.Type.NORMAL, "西土城", 1101),
        西土城(Station.Type.NORMAL, "牡丹园", 1330),
        牡丹园(Station.Type.NORMAL, "健德门", 973),
        健德门(Station.Type.NORMAL, "北土城", 1100),
        北土城(Station.Type.NORMAL, "安贞门", 1020),
        安贞门(Station.Type.NORMAL, "惠新西街南口", 982),
        惠新西街南口(Station.Type.NORMAL, "芍药居", 1712),
        芍药居(Station.Type.NORMAL, "太阳宫", 1003),
        太阳宫(Station.Type.NORMAL, "三元桥", 1759),
        三元桥(Station.Type.NORMAL, "亮马桥", 1506),
        亮马桥(Station.Type.NORMAL, "农业展览馆", 914),
        农业展览馆(Station.Type.NORMAL, "团结湖", 853),
        团结湖(Station.Type.NORMAL, "呼家楼", 1149),
        呼家楼(Station.Type.NORMAL, "金台夕照", 734),
        金台夕照(Station.Type.NORMAL, "国贸", 835),
        国贸(Station.Type.NORMAL, "双井", 1759),
        双井(Station.Type.NORMAL, "劲松", 1006),
        劲松(Station.Type.NORMAL, "潘家园", 1021),
        潘家园(Station.Type.NORMAL, "十里河", 1097),
        十里河(Station.Type.NORMAL, "分钟寺", 1804),
        分钟寺(Station.Type.NORMAL, "成寿寺", 1058),
        成寿寺(Station.Type.NORMAL, "宋家庄", 1677),
        宋家庄(Station.Type.NORMAL, "石榴庄", 1269),
        石榴庄(Station.Type.NORMAL, "大红门", 1244),
        大红门(Station.Type.NORMAL, "角门东", 1130),
        角门东(Station.Type.NORMAL, "角门西", 1254),
        角门西(Station.Type.NORMAL, "草桥", 1688),
        草桥(Station.Type.NORMAL, "纪家庙", 1547),
        纪家庙(Station.Type.NORMAL, "首经贸", 1143),
        首经贸(Station.Type.NORMAL, "丰台站", 1717),
        丰台站(Station.Type.NORMAL, "泥洼", 954),
        泥洼(Station.Type.NORMAL, "西局", 749),
        西局(Station.Type.NORMAL, "六里桥", 1584),
        六里桥(Station.Type.NORMAL, "莲花桥", 2392),
        莲花桥(Station.Type.NORMAL, "公主坟", 1016),
        公主坟(Station.Type.NORMAL, "西钓鱼台", 2386),
        西钓鱼台(Station.Type.NORMAL, "慈寿寺", 1214),
        慈寿寺(Station.Type.NORMAL, "车道沟", 1590),
        车道沟(Station.Type.NORMAL, "长春桥", 1205),
        长春桥(Station.Type.NORMAL, "火器营", 961),
        火器营(Station.Type.ENDPOINT, "巴沟", 1495);

        private Station.Type type;
        private String nameOfNextSta;//station name
        private int disToNextStaInDown;//distance to next station in downstream

        StationEnum(Station.Type type, String nameOfNextSta, int disToNextStaInDown) {
            this.type = type;
            this.nameOfNextSta = nameOfNextSta;
            this.disToNextStaInDown = disToNextStaInDown;
        }
    }
}