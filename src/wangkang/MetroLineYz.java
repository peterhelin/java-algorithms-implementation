package wangkang;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: helin <1006604973@qq.com>.
 * Date: 13/11/2016 13:55
 */
public class MetroLineYz extends MetroLine {

    final private String name = "亦庄线";
    static List<Station> stationList = new ArrayList<>();
    static List<Integer> distanceList = new ArrayList<>();
    static MetroLineYz instance;

    private MetroLineYz() {
    }

    static public MetroLineYz getInstance() {
        if (instance == null)
            return new MetroLineYz();
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
        宋家庄(Station.Type.NORMAL,"肖村",2631),
        肖村(Station.Type.NORMAL,"小红门",1275),
        小红门(Station.Type.NORMAL,"旧宫",2366),
        旧宫(Station.Type.NORMAL,"亦庄桥",1982),
        亦庄桥(Station.Type.NORMAL,"亦庄文化园",993),
        亦庄文化园(Station.Type.NORMAL,"万源街",1728),
        万源街(Station.Type.NORMAL,"荣京东街",1090),
        荣京东街(Station.Type.NORMAL,"荣昌东街",1355),
        荣昌东街(Station.Type.NORMAL,"同济南路",2337),
        同济南路(Station.Type.NORMAL,"经海路",2301),
        经海路(Station.Type.NORMAL,"次渠南",2055),
        次渠南(Station.Type.NORMAL,"次渠",1281),
        次渠(Station.Type.NORMAL,"",0 );

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