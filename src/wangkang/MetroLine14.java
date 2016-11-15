package wangkang;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: helin <1006604973@qq.com>.
 * Date: 13/11/2016 13:55
 */
public class MetroLine14 extends MetroLine {

    final private Integer lineNum = 14;
    static List<Station> stationList = new ArrayList<>();
    static List<Integer> distanceList = new ArrayList<>();
    static MetroLine14 instance;

    private MetroLine14() {
    }

    static public MetroLine14 getInstance() {
        if (instance == null)
            return new MetroLine14();
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

        张郭庄(Station.Type.NORMAL, "园博园", 1345),
        园博园(Station.Type.NORMAL, "大瓦窑", 4073),
        大瓦窑(Station.Type.NORMAL, "郭庄子", 1236),
        郭庄子(Station.Type.NORMAL, "大井", 2044),
        大井(Station.Type.NORMAL, "七里庄", 1579),
        七里庄(Station.Type.NORMAL, "西局", 845),
        西局(Station.Type.NORMAL, " ", 0),
        北京南站(Station.Type.NORMAL, "陶然桥", 887),
        陶然桥(Station.Type.NORMAL, "永定门外", 1063),
        永定门外(Station.Type.NORMAL, "景泰", 1119),
        景泰(Station.Type.NORMAL, "蒲黄榆", 1025),
        蒲黄榆(Station.Type.NORMAL, "方庄", 1486),
        方庄(Station.Type.NORMAL, "十里河", 1618),
        十里河(Station.Type.NORMAL, "南八里庄", 1147),
        南八里庄(Station.Type.NORMAL, "北工大西门", 1276),
        北工大西门(Station.Type.NORMAL, "平乐园", 1128),
        平乐园(Station.Type.NORMAL, "九龙山", 897),
        九龙山(Station.Type.NORMAL, "大望路", 1780),
        大望路(Station.Type.NORMAL, "红庙", 708),
        红庙(Station.Type.NORMAL, "金台路", 894),
        金台路(Station.Type.NORMAL, "朝阳公园", 1085),
        朝阳公园(Station.Type.NORMAL, "枣营", 1221),
        枣营(Station.Type.NORMAL, "东风北桥", 2173),
        东风北桥(Station.Type.NORMAL, "将台", 1600),
        将台(Station.Type.NORMAL, "高家园", 1171),
        高家园(Station.Type.NORMAL, "望京南", 676),
        望京南(Station.Type.NORMAL, "阜通", 1168),
        阜通(Station.Type.NORMAL, "望京", 903),
        望京(Station.Type.NORMAL, "东湖渠", 1283),
        东湖渠(Station.Type.NORMAL, "来广营", 1100),
        来广营(Station.Type.NORMAL, "善各庄", 1364),
        善各庄(Station.Type.NORMAL, "", 0);

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