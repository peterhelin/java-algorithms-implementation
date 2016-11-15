package wangkang;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: helin <1006604973@qq.com>.
 * Date: 13/11/2016 13:55
 */
public class MetroLineFs extends MetroLine {

    final private String name = "房山线";
    static List<Station> stationList = new ArrayList<>();
    static List<Integer> distanceList = new ArrayList<>();
    static MetroLineFs instance;

    private MetroLineFs() {
    }

    static public MetroLineFs getInstance() {
        if (instance == null)
            return new MetroLineFs();
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

        郭公庄(Station.Type.NORMAL, "大葆台", 1405),
        大葆台(Station.Type.NORMAL, "稻田", 6466),
        稻田(Station.Type.NORMAL, "长阳", 4041),
        长阳(Station.Type.NORMAL, "篱笆房", 2150),
        篱笆房(Station.Type.NORMAL, "广阳城", 1474),
        广阳城(Station.Type.NORMAL, "良乡大学城北", 2003),
        良乡大学城北(Station.Type.NORMAL, "良乡大学城", 1188),
        良乡大学城(Station.Type.NORMAL, "良乡大学城西", 1738),
        良乡大学城西(Station.Type.NORMAL, "良乡南关", 1332),
        良乡南关(Station.Type.NORMAL, "苏庄", 1330),
        苏庄(Station.Type.NORMAL, "", 0);

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