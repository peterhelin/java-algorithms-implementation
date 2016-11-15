package wangkang;


import java.util.ArrayList;
import java.util.List;

/**
 * Author: helin <1006604973@qq.com>.
 * Date: 13/11/2016 11:14
 */

public class MetroLine1 extends MetroLine {

    final private Integer lineNum = 1;
    static List<Station> stationList = new ArrayList<>();
    static List<Integer> distanceList = new ArrayList<>();
    static MetroLine1 instance;

    private MetroLine1() {
    }

    static public MetroLine1 getInstance() {
        if (instance == null)
            return new MetroLine1();
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
        苹果园(Station.Type.NORMAL, "古城", 2606),
        古城(Station.Type.NORMAL, "八角游乐园", 1921),
        八角游乐园(Station.Type.NORMAL, "八宝山", 1953),
        八宝山(Station.Type.NORMAL, "玉泉路", 1479),
        玉泉路(Station.Type.NORMAL, "五棵松", 1810),
        五棵松(Station.Type.NORMAL, "万寿路", 1778),
        万寿路(Station.Type.NORMAL, "公主坟", 1313),
        公主坟(Station.Type.NORMAL, "军事博物馆", 1172),
        军事博物馆(Station.Type.NORMAL, "木樨地", 1166),
        木樨地(Station.Type.NORMAL, "南礼士路", 1291),
        南礼士路(Station.Type.NORMAL, "复兴门", 424),
        复兴门(Station.Type.NORMAL, "西单", 1590),
        西单(Station.Type.NORMAL, "天安门西", 1217),
        天安门西(Station.Type.NORMAL, "天安门东", 925),
        天安门东(Station.Type.NORMAL, "王府井", 852),
        王府井(Station.Type.NORMAL, "东单", 774),
        东单(Station.Type.NORMAL, "建国门", 1230),
        建国门(Station.Type.NORMAL, "永安里", 1377),
        永安里(Station.Type.NORMAL, "国贸", 790),
        国贸(Station.Type.NORMAL, "大望路", 1385),
        大望路(Station.Type.NORMAL, "四惠", 1673),
        四惠(Station.Type.NORMAL, "四惠东", 1714),
        四惠东(Station.Type.NORMAL, "", 0);

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