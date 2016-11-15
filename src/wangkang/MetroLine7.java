package wangkang;


import java.util.ArrayList;
import java.util.List;

/**
 * Author: helin <1006604973@qq.com>.
 * Date: 13/11/2016 11:14
 */

public class MetroLine7 extends MetroLine {

    final private Integer lineNum = 7;
    static List<Station> stationList = new ArrayList<>();
    static List<Integer> distanceList = new ArrayList<>();
    static MetroLine7 instance;

    private MetroLine7() {
    }

    static public MetroLine7 getInstance() {
        if (instance == null)
            return new MetroLine7();
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
        北京西站(Station.Type.NORMAL, "湾子", 935),
        湾子(Station.Type.NORMAL, "达官营", 734),
        达官营(Station.Type.NORMAL, "广安门内", 1874),
        广安门内(Station.Type.NORMAL, "菜市口", 1374),
        菜市口(Station.Type.NORMAL, "虎坊桥", 885),
        虎坊桥(Station.Type.NORMAL, "珠市口", 1205),
        珠市口(Station.Type.NORMAL, "桥湾", 869),
        桥湾(Station.Type.NORMAL, "磁器口", 1016),
        磁器口(Station.Type.NORMAL, "广渠门内", 1138),
        广渠门内(Station.Type.NORMAL, "广渠门外", 1332),
        广渠门外(Station.Type.NORMAL, "双井", 1241),
        双井(Station.Type.NORMAL, "九龙山", 1311),
        九龙山(Station.Type.NORMAL, "大郊亭", 781),
        大郊亭(Station.Type.NORMAL, "百子湾", 865),
        百子湾(Station.Type.NORMAL, "化工", 903),
        化工(Station.Type.NORMAL, "南楼梓庄", 1464),
        南楼梓庄(Station.Type.NORMAL, "欢乐谷景区", 906),
        欢乐谷景区(Station.Type.NORMAL, "垡头", 1679),
        垡头(Station.Type.NORMAL, "双合", 1304),
        双合(Station.Type.NORMAL, "焦化厂", 1021),
        焦化厂(Station.Type.NORMAL, "", 0);

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