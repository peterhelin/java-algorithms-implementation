package wangkang;


import java.util.ArrayList;
import java.util.List;

/**
 * Author: helin <1006604973@qq.com>.
 * Date: 13/11/2016 11:14
 */

public class MetroLine8 extends MetroLine {

    final private Integer lineNum = 8;
    static List<Station> stationList = new ArrayList<>();
    static List<Integer> distanceList = new ArrayList<>();
    static MetroLine8 instance;

    private MetroLine8() {
    }

    static public MetroLine8 getInstance() {
        if (instance == null)
            return new MetroLine8();
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
        朱辛庄(Station.Type.NORMAL, "育知路", 2318),
        育知路(Station.Type.NORMAL, "平西府", 1985),
        平西府(Station.Type.NORMAL, "回龙观东大街", 2056),
        回龙观东大街(Station.Type.NORMAL, "霍营", 1114),
        霍营(Station.Type.NORMAL, "育新", 1894),
        育新(Station.Type.NORMAL, "西小口", 1543),
        西小口(Station.Type.NORMAL, "永泰庄", 1041),
        永泰庄(Station.Type.NORMAL, "林萃桥", 2553),
        林萃桥(Station.Type.NORMAL, "森林公园南门", 2555),
        森林公园南门(Station.Type.NORMAL, "奥林匹克公园", 1016),
        奥林匹克公园(Station.Type.NORMAL, "奥体中心", 1667),
        奥体中心(Station.Type.NORMAL, "北土城", 900),
        北土城(Station.Type.NORMAL, "安华桥", 1018),
        安华桥(Station.Type.NORMAL, "安德里北街", 1274),
        安德里北街(Station.Type.NORMAL, "鼓楼大街", 1083),
        鼓楼大街(Station.Type.NORMAL, "什刹海", 1188),
        什刹海(Station.Type.NORMAL, "南锣鼓巷", 902),
        南锣鼓巷(Station.Type.NORMAL, "", 0);

        private Station.Type type;
        private String nameOfNextSta;//name of next station
        private int disToNextStaInDown;//distance to next station in downstream

        StationEnum(Station.Type type, String nameOfNextSta, int disToNextStaInDown) {
            this.type = type;
            this.nameOfNextSta = nameOfNextSta;
            this.disToNextStaInDown = disToNextStaInDown;
        }
    }
}