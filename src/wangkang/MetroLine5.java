package wangkang;


import java.util.ArrayList;
import java.util.List;

/**
 * Author: helin <1006604973@qq.com>.
 * Date: 13/11/2016 11:14
 */

public class MetroLine5 extends MetroLine {

    final private Integer lineNum = 5;
    static List<Station> stationList = new ArrayList<>();
    static List<Integer> distanceList = new ArrayList<>();
    static MetroLine5 instance;

    private MetroLine5() {
    }

    static public MetroLine5 getInstance() {
        if (instance == null)
            return new MetroLine5();
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

        天通苑北(Station.Type.NORMAL, "天通苑", 939),
        天通苑(Station.Type.NORMAL, "天通苑南", 965),
        天通苑南(Station.Type.NORMAL, "立水桥", 1544),
        立水桥(Station.Type.NORMAL, "立水桥南", 1305),
        立水桥南(Station.Type.NORMAL, "北苑路北", 1286),
        北苑路北(Station.Type.NORMAL, "大屯路东", 3000),
        大屯路东(Station.Type.NORMAL, "惠新西街北口", 1838),
        惠新西街北口(Station.Type.NORMAL, "惠新西街南口", 1122),
        惠新西街南口(Station.Type.NORMAL, "和平西桥", 1025),
        和平西桥(Station.Type.NORMAL, "和平里北街", 1059),
        和平里北街(Station.Type.NORMAL, "雍和宫", 1151),
        雍和宫(Station.Type.NORMAL, "北新桥", 866),
        北新桥(Station.Type.NORMAL, "张自忠路", 791),
        张自忠路(Station.Type.NORMAL, "东四", 1016),
        东四(Station.Type.NORMAL, "灯市口", 848),
        灯市口(Station.Type.NORMAL, "东单", 945),
        东单(Station.Type.NORMAL, "崇文门", 821),
        崇文门(Station.Type.NORMAL, "磁器口", 876),
        磁器口(Station.Type.NORMAL, "天坛东门", 1183),
        天坛东门(Station.Type.NORMAL, "蒲黄榆", 1900),
        蒲黄榆(Station.Type.NORMAL, "刘家窑", 905),
        刘家窑(Station.Type.NORMAL, "宋家庄", 1670),
        宋家庄(Station.Type.NORMAL, "", 0);

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

