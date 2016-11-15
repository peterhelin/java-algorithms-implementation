package wangkang;


import java.util.ArrayList;
import java.util.List;

/**
 * Author: helin <1006604973@qq.com>.
 * Date: 13/11/2016 11:14
 */

public class MetroLine6 extends MetroLine {

    final private Integer lineNum = 6;
    static List<Station> stationList = new ArrayList<>();
    static List<Integer> distanceList = new ArrayList<>();
    static MetroLine6 instance;

    private MetroLine6() {
    }

    static public MetroLine6 getInstance() {
        if (instance == null)
            return new MetroLine6();
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

        海淀五路居(Station.Type.NORMAL, "慈寿寺", 1508),
        慈寿寺(Station.Type.NORMAL, "花园桥", 1431),
        花园桥(Station.Type.NORMAL, "白石桥南", 1166),
        白石桥南(Station.Type.NORMAL, "车公庄西", 1664),
        车公庄西(Station.Type.NORMAL, "车公庄", 887),
        车公庄(Station.Type.NORMAL, "平安里", 1443),
        平安里(Station.Type.NORMAL, "北海北", 1321),
        北海北(Station.Type.NORMAL, "南锣鼓巷", 1349),
        南锣鼓巷(Station.Type.NORMAL, "东四", 1937),
        东四(Station.Type.NORMAL, "朝阳门", 1399),
        朝阳门(Station.Type.NORMAL, "东大桥", 1668),
        东大桥(Station.Type.NORMAL, "呼家楼", 845),
        呼家楼(Station.Type.NORMAL, "金台路", 1450),
        金台路(Station.Type.NORMAL, "十里堡", 2036),
        十里堡(Station.Type.NORMAL, "青年路", 1282),
        青年路(Station.Type.NORMAL, "褡裢坡", 3999),
        褡裢坡(Station.Type.NORMAL, "黄渠", 1238),
        黄渠(Station.Type.NORMAL, "常营", 1854),
        常营(Station.Type.NORMAL, "草房", 1405),
        草房(Station.Type.NORMAL, "物资学院路", 2115),
        物资学院路(Station.Type.NORMAL, "通州北关", 2557),
        通州北关(Station.Type.NORMAL, "通运门", 1468),
        通运门(Station.Type.NORMAL, "北运河西", 1543),
        北运河西(Station.Type.NORMAL, "北运河东", 1599),
        北运河东(Station.Type.NORMAL, "郝家府", 929),
        郝家府(Station.Type.NORMAL, "东夏园", 1346),
        东夏园(Station.Type.NORMAL, "潞城", 1194),
        潞城(Station.Type.NORMAL, "", 0);

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

