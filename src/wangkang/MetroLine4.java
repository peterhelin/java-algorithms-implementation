package wangkang;


import java.util.ArrayList;
import java.util.List;

/**
 * Author: helin <1006604973@qq.com>.
 * Date: 13/11/2016 11:14
 */

public class MetroLine4 extends MetroLine {

    final private Integer lineNum = 4;
    static List<Station> stationList = new ArrayList<>();
    static List<Integer> distanceList = new ArrayList<>();
    static MetroLine4 instance;

    private MetroLine4() {
    }

    static public MetroLine4 getInstance() {
        if (instance == null)
            return new MetroLine4();
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
        安河桥北(Station.Type.ENDPOINT, "北宫门", 1363),
        北宫门(Station.Type.NORMAL, "西苑", 1251),
        西苑(Station.Type.NORMAL, "圆明园", 1672),
        圆明园(Station.Type.NORMAL, "北京大学东门", 1295),
        北京大学东门(Station.Type.NORMAL, "中关村", 887),
        中关村(Station.Type.NORMAL, "海淀黄庄", 900),
        海淀黄庄(Station.Type.TRANSFER, "人民大学", 1063),
        人民大学(Station.Type.NORMAL, "魏公村", 1051),
        魏公村(Station.Type.NORMAL, "国家图书馆", 1658),
        国家图书馆(Station.Type.TRANSFER, "动物园", 1517),
        动物园(Station.Type.NORMAL, "西直门", 1441),
        西直门(Station.Type.TRANSFER, "新街口", 1025),
        新街口(Station.Type.NORMAL, "平安里", 1100),
        平安里(Station.Type.TRANSFER, "西四", 1100),
        西四(Station.Type.NORMAL, "灵境胡同", 869),
        灵境胡同(Station.Type.NORMAL, "西单", 1011),
        西单(Station.Type.TRANSFER, "宣武门", 815),
        宣武门(Station.Type.TRANSFER, "菜市口", 1152),
        菜市口(Station.Type.TRANSFER, "陶然亭", 1200),
        陶然亭(Station.Type.NORMAL, "北京南站", 1643),
        北京南站(Station.Type.TRANSFER, "马家堡", 1480),
        马家堡(Station.Type.NORMAL, "角门西", 827),
        角门西(Station.Type.TRANSFER, "公益西桥", 989),
        公益西桥(Station.Type.ENDPOINT, "新宫", 0),
        新宫(Station.Type.NORMAL, "西红门	", 1000),
        西红门(Station.Type.NORMAL, "高米店北	", 1000),
        高米店北(Station.Type.NORMAL, "高米店南	", 1000),
        高米店南(Station.Type.NORMAL, "枣园	", 1000),
        枣园(Station.Type.NORMAL, "清源路	", 1000),
        清源路(Station.Type.NORMAL, "黄村西大街	", 1000),
        黄村西大街(Station.Type.NORMAL, "黄村火车站	", 1000),
        黄村火车站(Station.Type.NORMAL, "义和庄	", 1000),
        义和庄(Station.Type.NORMAL, "生物医药基地	", 1000),
        生物医药基地(Station.Type.NORMAL, "天宫院	", 1000),
        天宫院(Station.Type.NORMAL, "", 1000);

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