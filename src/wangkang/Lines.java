//package wangkang;
//
//
//import com.jwetherell.algorithms.data_structures.Graph;
//
//import java.util.*;
//
///**
// * Author: helin <1006604973@qq.com>.
// * Date: 13/11/2016 11:28
// */
//public class Lines {
//
//
//    private static Map<Integer, EnumSet> integerEnumSetMap;
//
//    static void initLines() {
//        integerEnumSetMap = new HashMap<>();
//        integerEnumSetMap.put(4, EnumSet.range(Line4.getStartEdgeFromStation(), Line4.getEndEdgeFromStation()));
//        integerEnumSetMap.put(7, EnumSet.range(Line7.getStartEdgeFromStation(), Line7.getEndEdgeFromStation()));
//    }
//
//    public static void addStationsToStationList(List<Graph.Vertex<Integer>> vertices, List<Graph.Edge<Integer>> edges, int i) {
//        if (integerEnumSetMap == null) {
//            initLines();
//        }
//
//        Iterator iterator = integerEnumSetMap.get(i).iterator();
//        Graph.Vertex tmp;
//
//        Graph.Edge edge;
//        while (iterator.hasNext()) {
//            switch (i) {
//                case 4:
//                    Line4 v = (Line4) iterator.next();
//                    edge = new Graph.Edge(v.getDisatce(), new Graph.Vertex(v.getFrom()), new Graph.Vertex(v.getTo()));
//
//                    break;
//                case 7:
//                    v = ((Line7) iterator.next());
//                    break;
//                default:
//                    throw new IllegalArgumentException("Illegal line number");
//            }
//
//
//
//            tmp.addEdge(new Graph.Edge(v.getDisatce(), new Graph.Vertex(v.getFrom()), new Graph.Vertex(v.getTo())));
//            if (!vertices.contains(tmp))
//                vertices.add(tmp);
//        }
////        switch (i) {
////            case 4:
////                tmp = new Graph.Vertex(Line4.getEndStationName());
////                break;
////            case 7:
////                tmp = new Graph.Vertex(Line7.getEndStationName());
////                break;
////            default:
////                throw new IllegalArgumentException("Illegal line number");
////        }
////        if (!stationList.contains(tmp)) {
////            stationList.add(tmp);
////        }
//
//    }
//
//    public static void addEdgesToEdgeList(List<Graph.Edge<Integer>> edgeList, int i) {
//        if (integerEnumSetMap == null) {
//            initLines();
//        }
//        integerEnumSetMap.get(i).forEach(
//                s -> {
//                    Graph.Edge tmp;
//                    switch (i) {
//                        case 4:
//                            Line4 line4 = ((Line4) s);
//                            tmp = new Graph.Edge<Integer>(
//                                    line4.getDisatce(),
//                                    new Graph.Vertex(line4.getFrom()),
//                                    new Graph.Vertex(line4.getTo()));
//                            break;
//                        case 7:
//                            Line7 line7 = ((Line7) s);
//                            tmp = new Graph.Edge(
//                                    line7.getDisatce(),
//                                    new Graph.Vertex(line7.getFrom()),
//                                    new Graph.Vertex(line7.getTo()));
//                            break;
//                        default:
//                            throw new IllegalArgumentException("Illegal line number");
//                    }
//
//                    if (!edgeList.contains(tmp))
//                        edgeList.add(tmp);
//                }
//        );
//
//    }
//}
