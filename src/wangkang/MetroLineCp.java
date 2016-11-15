package wangkang;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: helin <1006604973@qq.com>.
 * Date: 13/11/2016 13:55
 */
public class MetroLineCp extends MetroLine {

    final private String name = "昌平线";
    static List<Station> stationList = new ArrayList<>();
    static List<Integer> distanceList = new ArrayList<>();
    static MetroLineCp instance;

    private MetroLineCp() {
    }

    static public MetroLineCp getInstance() {
        if (instance == null)
            return new MetroLineCp();
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

        昌平西山口(Station.Type.NORMAL, "十三陵景区", 1213),
        十三陵景区(Station.Type.NORMAL, "昌平", 3508),
        昌平(Station.Type.NORMAL, "昌平东关", 2433),
        昌平东关(Station.Type.NORMAL, "北邵洼", 1683),
        北邵洼(Station.Type.NORMAL, "南邵", 1958),
        南邵(Station.Type.NORMAL, "沙河高教园", 5357),
        沙河高教园(Station.Type.NORMAL, "沙河", 1964),
        沙河(Station.Type.NORMAL, "巩华城", 2025),
        巩华城(Station.Type.NORMAL, "朱辛庄", 3799),
        朱辛庄(Station.Type.NORMAL, "生命科学园", 2367),
        生命科学园(Station.Type.NORMAL, "生命科学园", 5440),
        西二旗(Station.Type.NORMAL, "", 0);

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