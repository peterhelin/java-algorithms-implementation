package wangkang;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: helin <1006604973@qq.com>.
 * Date: 13/11/2016 13:55
 */
public class MetroLineBt extends MetroLine {

    final private String name = "八通线";
    static List<Station> stationList = new ArrayList<>();
    static List<Integer> distanceList = new ArrayList<>();
    static MetroLineBt instance;

    private MetroLineBt() {
    }

    static public MetroLineBt getInstance() {
        if (instance == null)
            return new MetroLineBt();
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

        四惠(Station.Type.NORMAL,"四惠东",1715),
        四惠东(Station.Type.NORMAL,"高碑店",1375),
        高碑店(Station.Type.NORMAL,"传媒大学",2002),
        传媒大学(Station.Type.NORMAL,"双桥",1894),
        双桥(Station.Type.NORMAL,"管庄",1912),
        管庄(Station.Type.NORMAL,"八里桥",1763),
        八里桥(Station.Type.NORMAL,"通州北苑",1700),
        通州北苑(Station.Type.NORMAL,"果园",1465),
        果园(Station.Type.NORMAL,"九棵树",990),
        九棵树(Station.Type.NORMAL,"梨园",1225),
        梨园(Station.Type.NORMAL,"临河里",1257),
        临河里(Station.Type.NORMAL,"土桥",776),
        土桥(Station.Type.NORMAL,"",0 );

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