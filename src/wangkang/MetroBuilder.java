package wangkang;

import java.util.*;

/**
 * Author: helin <1006604973@qq.com>.
 * Date: 14/11/2016 17:42
 */
public class MetroBuilder {

    static Integer n = 0;
    static Map<String, Station> mapOfStaNameAndSta = new HashMap<>();

    private MetroBuilder() {
    }

    public static void buildLine(Enum[] ena, MetroLine line) {
        BjSubway.metroLines.add(line);
        int i;
        for (i = 0; i < ena.length; i++) {
            String name = ena[i].name();
            buildStation(line.getStaType(name), name, line.getDisToNextStaInDO(name), line);
        }
        System.out.println(i);

        if (i == ena.length) {

            String name = ena[i - 1].name();
            String nextStaName = line.getNextStaName(name);
            if (nextStaName != "") {//终点换乘站
                Station station = mapOfStaNameAndSta.get(nextStaName);
                line.getStationList().add(station);
                line.getDistanceList().add(line.getDisToNextStaInDO(name));
            }
        }

    }

    public static Station buildStation(Station.Type type, String staName, Integer disToDownSta, MetroLine line) {
        if (!mapOfStaNameAndSta.containsKey(staName)) {
            BjSubway.staNameMapToStaNumInAll.put(staName, n);
            BjSubway.staNumInAllMapToStaName.put(n, staName);
            Station station = new Station(type, staName, n++);
            mapOfStaNameAndSta.put(staName, station);

            line.getStationList().add(station);
            line.getDistanceList().add(disToDownSta);
            BjSubway.stations.add(station);
            return station;
        } else {
            Station station = mapOfStaNameAndSta.get(staName);
            line.getStationList().add(station);
            line.getDistanceList().add(disToDownSta);
            return station;
        }
    }

    public static void bulid() {
        MetroLine1.getInstance().build();
        MetroLine2.getInstance().build();
        MetroLine4.getInstance().build();
        MetroLine5.getInstance().build();
        MetroLine6.getInstance().build();
        MetroLine7.getInstance().build();
        MetroLine8.getInstance().build();
        MetroLine9.getInstance().build();
        MetroLine10.getInstance().build();
        MetroLine13.getInstance().build();
        MetroLine14.getInstance().build();
        MetroLine15.getInstance().build();
        MetroLineFs.getInstance().build();
        MetroLineBt.getInstance().build();
        MetroLineCp.getInstance().build();
        MetroLineDx.getInstance().build();
        MetroLineJc.getInstance().build();
        MetroLineYz.getInstance().build();
    }

    public static void main(String... args) {
        MetroBuilder.bulid();
    }
}
