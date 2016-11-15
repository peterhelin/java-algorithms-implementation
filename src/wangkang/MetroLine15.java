package wangkang;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: helin <1006604973@qq.com>.
 * Date: 13/11/2016 13:55
 */
public class MetroLine15 extends MetroLine {

    final private Integer lineNum = 15;
    static List<Station> stationList = new ArrayList<>();
    static List<Integer> distanceList = new ArrayList<>();
    static MetroLine15 instance;

    private MetroLine15() {
    }

    static public MetroLine15 getInstance() {
        if (instance == null)
            return new MetroLine15();
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

        清华东路西口(Station.Type.NORMAL, "六道口", 1144),
        六道口(Station.Type.NORMAL, "北沙滩", 1337),
        北沙滩(Station.Type.NORMAL, "奥林匹克公园", 1999),
        奥林匹克公园(Station.Type.NORMAL, "安立路", 1368),
        安立路(Station.Type.NORMAL, "大屯路东", 938),
        大屯路东(Station.Type.NORMAL, "关庄", 1087),
        关庄(Station.Type.NORMAL, "望京西", 2071),
        望京西(Station.Type.NORMAL, "望京", 1758),
        望京(Station.Type.NORMAL, "望京东", 1652),
        望京东(Station.Type.NORMAL, "崔各庄", 2295),
        崔各庄(Station.Type.NORMAL, "马泉营", 2008),
        马泉营(Station.Type.NORMAL, "孙河", 3309),
        孙河(Station.Type.NORMAL, "国展", 3386),
        国展(Station.Type.NORMAL, "花梨坎", 1615),
        花梨坎(Station.Type.NORMAL, "后沙峪", 3354),
        后沙峪(Station.Type.NORMAL, "南法信", 4576),
        南法信(Station.Type.NORMAL, "石门", 2712),
        石门(Station.Type.NORMAL, "顺义", 1331),
        顺义(Station.Type.NORMAL, "俸伯", 2441),
        俸伯(Station.Type.NORMAL, "", 0);
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