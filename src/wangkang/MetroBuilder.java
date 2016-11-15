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

    private static void buildLine(MetroLine4.Line4[] line4) {
        MetroLine line = new MetroLine(4);
        BjSubway.metroLines.add(line);

        for (int i = 0; i < line4.length; i++) {
            Station station = (buildStation(line4[i].getType(), line4[i].name(), line4[i].getDisToNextStaInDown(), line));
//            if (i > 0) {
//                line.stationList.get(i - 1).addNext(station, line4[i - 1].getDisToNextStaInDown());
//            }
        }
    }

    private static void buildLine(MetroLine4.Line10[] line10) {
        MetroLine line = new MetroLine(10);
        BjSubway.metroLines.add(line);

        for (int i = 0; i < line10.length; i++) {
            Station station = (buildStation(line10[i].getType(), line10[i].name(), line10[i].getDisToNextStaInDown(), line));
        }
    }


    private static Station buildStation(Station.Type type, String staName, Integer disToDownSta, MetroLine line) {
        if (!mapOfStaNameAndSta.containsKey(staName)) {
            BjSubway.staNameMapToStaNumInAll.put(staName, n);
            BjSubway.staNumInAllMapToStaName.put(n, staName);
            Station station = new Station(type, staName, n++);
            mapOfStaNameAndSta.put(staName, station);


            line.stationList.add(station);
            line.distanceList.add(disToDownSta);
            BjSubway.stations.add(station);
            return station;
        } else {
            Station station = mapOfStaNameAndSta.get(staName);
            line.stationList.add(station);
            line.distanceList.add(disToDownSta);
            return station;
        }
    }

    public static void bulid() {
        MetroBuilder.buildLine(MetroLine4.Line4.values());
        MetroBuilder.buildLine(MetroLine4.Line10.values());
    }

    public static void main(String... args) {
        MetroBuilder.bulid();
        BjSubway.metroLines.forEach(
                line -> {

                });
        BjSubway.stations.forEach(
                station -> {
                    System.out.print(station.getName() + station.getStaNumInAll() + "     ");
                    station.getNext().entrySet().forEach(entry -> System.out.print(entry.getKey().getName() + " " + entry.getValue() + "   "));
                    System.out.println();
                });
    }
}
