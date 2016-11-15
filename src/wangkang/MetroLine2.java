package wangkang;


import java.util.ArrayList;
import java.util.List;

/**
 * Author: helin <1006604973@qq.com>.
 * Date: 13/11/2016 11:14
 */

public class MetroLine2 extends MetroLine {

    final private Integer lineNum = 2;
    static List<Station> stationList = new ArrayList<>();
    static List<Integer> distanceList = new ArrayList<>();
    static MetroLine2 instance;

    private MetroLine2() {
    }

    static public MetroLine2 getInstance() {
        if (instance == null)
            return new MetroLine2();
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

        西直门(Station.Type.NORMAL, "车公庄", 909),
        车公庄(Station.Type.NORMAL, "阜成门", 960),
        阜成门(Station.Type.NORMAL, "复兴门", 1832),
        复兴门(Station.Type.NORMAL, "长椿街", 1234),
        长椿街(Station.Type.NORMAL, "宣武门", 929),
        宣武门(Station.Type.NORMAL, "和平门", 851),
        和平门(Station.Type.NORMAL, "前门", 1171),
        前门(Station.Type.NORMAL, "崇文门", 1634),
        崇文门(Station.Type.NORMAL, "北京站", 1023),
        北京站(Station.Type.NORMAL, "建国门", 945),
        建国门(Station.Type.NORMAL, "朝阳门", 1763),
        朝阳门(Station.Type.NORMAL, "东四十条", 1027),
        东四十条(Station.Type.NORMAL, "东直门", 824),
        东直门(Station.Type.NORMAL, "雍和宫", 2228),
        雍和宫(Station.Type.NORMAL, "安定门", 794),
        安定门(Station.Type.NORMAL, "鼓楼大街", 1237),
        鼓楼大街(Station.Type.NORMAL, "积水潭", 1766),
        积水潭(Station.Type.NORMAL, "西直门", 1899);

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