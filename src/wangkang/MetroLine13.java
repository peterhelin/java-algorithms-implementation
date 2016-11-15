package wangkang;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: helin <1006604973@qq.com>.
 * Date: 13/11/2016 13:55
 */
public class MetroLine13 extends MetroLine {

    final private Integer lineNum = 13;
    static List<Station> stationList = new ArrayList<>();
    static List<Integer> distanceList = new ArrayList<>();
    static MetroLine13 instance;

    private MetroLine13() {
    }

    static public MetroLine13 getInstance() {
        if (instance == null)
            return new MetroLine13();
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
        西直门(Station.Type.NORMAL, "大钟寺", 2839),
        大钟寺(Station.Type.NORMAL, "知春路", 1206),
        知春路(Station.Type.NORMAL, "五道口", 1829),
        五道口(Station.Type.NORMAL, "上地", 4866),
        上地(Station.Type.NORMAL, "西二旗", 2538),
        西二旗(Station.Type.NORMAL, "龙泽", 3623),
        龙泽(Station.Type.NORMAL, "回龙观", 1423),
        回龙观(Station.Type.NORMAL, "霍营", 2110),
        霍营(Station.Type.NORMAL, "立水桥", 4785),
        立水桥(Station.Type.NORMAL, "北苑", 2272),
        北苑(Station.Type.NORMAL, "望京西", 6720),
        望京西(Station.Type.NORMAL, "芍药居", 2152),
        芍药居(Station.Type.NORMAL, "光熙门", 1110),
        光熙门(Station.Type.NORMAL, "柳芳", 1135),
        柳芳(Station.Type.NORMAL, "", 0);

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