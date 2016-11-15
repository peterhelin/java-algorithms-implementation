package wangkang;


import java.util.ArrayList;
import java.util.List;

/**
 * Author: helin <1006604973@qq.com>.
 * Date: 13/11/2016 11:14
 */

public class MetroLine9 extends MetroLine {

    final private Integer lineNum = 9;
    static List<Station> stationList = new ArrayList<>();
    static List<Integer> distanceList = new ArrayList<>();
    static MetroLine9 instance;

    private MetroLine9() {
    }

    static public MetroLine9 getInstance() {
        if (instance == null)
            return new MetroLine9();
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
        国家图书馆(Station.Type.NORMAL, "白石桥南", 1096),
        白石桥南(Station.Type.NORMAL, "白堆子", 943),
        白堆子(Station.Type.NORMAL, "军事博物馆", 1912),
        军事博物馆(Station.Type.NORMAL, "北京西站", 1398),
        北京西站(Station.Type.NORMAL, "六里桥东", 1170),
        六里桥东(Station.Type.NORMAL, "六里桥", 1309),
        六里桥(Station.Type.NORMAL, "七里庄", 1778),
        七里庄(Station.Type.NORMAL, "丰台东大街", 1325),
        丰台东大街(Station.Type.NORMAL, "丰台南路", 1585),
        丰台南路(Station.Type.NORMAL, "科怡路", 980),
        科怡路(Station.Type.NORMAL, "丰台科技园", 788),
        丰台科技园(Station.Type.NORMAL, "郭公庄", 1347),
        郭公庄(Station.Type.NORMAL, "", 0);

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