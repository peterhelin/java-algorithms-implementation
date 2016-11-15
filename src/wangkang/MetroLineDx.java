package wangkang;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: helin <1006604973@qq.com>.
 * Date: 13/11/2016 13:55
 */
public class MetroLineDx extends MetroLine {

    final private String name = "大兴线";
    static List<Station> stationList = new ArrayList<>();
    static List<Integer> distanceList = new ArrayList<>();
    static MetroLineDx instance;

    private MetroLineDx() {
    }

    static public MetroLineDx getInstance() {
        if (instance == null)
            return new MetroLineDx();
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

        公益西桥(Station.Type.NORMAL, "新宫", 2798),
        新宫(Station.Type.NORMAL, "西红门", 5102),
        西红门(Station.Type.NORMAL, "高米店北", 1810),
        高米店北(Station.Type.NORMAL, "高米店南", 1128),
        高米店南(Station.Type.NORMAL, "枣园", 1096),
        枣园(Station.Type.NORMAL, "清源路", 1200),
        清源路(Station.Type.NORMAL, "黄村西大街", 1214),
        黄村西大街(Station.Type.NORMAL, "黄村火车站", 987),
        黄村火车站(Station.Type.NORMAL, "义和庄", 2035),
        义和庄(Station.Type.NORMAL, "生物医药基地", 2918),
        生物医药基地(Station.Type.NORMAL, "天宫院", 1811),
        天宫院(Station.Type.NORMAL, "", 0);

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