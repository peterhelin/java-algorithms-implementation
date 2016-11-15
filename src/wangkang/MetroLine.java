package wangkang;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: helin <1006604973@qq.com>.
 * Date: 14/11/2016 12:19
 */
public class MetroLine {
    private Integer lineNum;
    List<Station> stationList = new ArrayList<>();
    List<Integer> distanceList = new ArrayList<>();

    public MetroLine(int lineNum) {
        this.lineNum = lineNum;
    }

    public Integer getLineNum() {
        return lineNum;
    }

    public void setLineNum(Integer lineNum) {
        this.lineNum = lineNum;
    }

    public List<Station> getStationList() {
        return stationList;
    }

    public void setStationList(List<Station> stationList) {
        this.stationList = stationList;
    }

    public void addStation(Station station) {
        stationList.add(station);
    }
}
