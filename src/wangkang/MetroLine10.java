//package wangkang;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
///**
// * Author: helin <1006604973@qq.com>.
// * Date: 14/11/2016 13:26
// */
//public class MetroLine10 extends MetroLine {
//
//
//
//    @Override
//    void init() {
////        Line10[] line10 = Line10.values();
////        Arrays.stream(line10).forEach(
////                sta -> {
////                    Station station = new Station(sta.getStaName());
////                    if (sta.type == Station.Type.TRANSFER || sta.type == Station.Type.ENDPOINTANDTRANSFER) {
////                        if (!stations.contains(station))
////                            stations.add(station);
////                    } else stations.add(station);
////                }
////        );
//    }
//
//    @Override
//    List<Station> getStations() {
//        return stations;
//    }
//
//    @Override
//    Line10 getStationByEnName(String enName) {
//        return null;
//    }
//
//    @Override
//    Line10 getStationByChName(String chName) {
//        return Line10.valueOf(chName);
//    }
//}
