package wangkang;

import com.jwetherell.algorithms.data_structures.Graph;
import com.jwetherell.algorithms.graph.Dijkstra;

import java.util.*;

/**
 * Author: helin <1006604973@qq.com>.
 * Date: 13/11/2016 10:09
 */
public class BjSubway<T> {
    static List<Station> stations = new ArrayList<>();
    static List<MetroLine> metroLines = new ArrayList<>();
    static Map<String, Integer> staNameMapToStaNumInAll = new HashMap<>();
    static Map<Integer, String> staNumInAllMapToStaName = new HashMap<>();
    static Map<Integer, Graph.Vertex> staNumInAllMapToVertex = new HashMap<>();


    final List<Graph.Vertex<Integer>> verticies = new ArrayList<Graph.Vertex<Integer>>();
    final List<Graph.Edge<Integer>> edges = new ArrayList<>();
    Graph graph;

    public Graph.Vertex getVertex(Integer staNumInAll) {
        if (staNumInAllMapToVertex.containsKey(staNumInAll))
            return staNumInAllMapToVertex.get(staNumInAll);
        else {
            Graph.Vertex vertex = new Graph.Vertex(staNumInAll);
            staNumInAllMapToVertex.put(staNumInAll, vertex);
            verticies.add(vertex);
            return vertex;
        }
    }

    public void graphInit() {
        MetroBuilder.bulid();
        metroLines.stream().forEach(
                line -> {
                    for (int i = 0; i < line.stationList.size() - 1; i++) {
                        Integer staNumInAllOfFrom = line.stationList.get(i).getStaNumInAll();
                        Graph.Vertex from = getVertex(staNumInAllOfFrom);

                        Integer staNumInAllOfTo = line.stationList.get(i + 1).getStaNumInAll();
                        Graph.Vertex to = getVertex(staNumInAllOfTo);

                        Graph.Edge<Integer> edge = new Graph.Edge<>(
                                line.distanceList.get(i),
                                from,
                                to);
                        edges.add(edge);
                    }
                });

//        verticies.stream().forEach(
//                o1 -> {
//                    System.out.println(((Graph.Vertex) o1).getValue());
//                });
        graph = new Graph(verticies, edges);

//        graph.getVertices().stream().forEach(
//                o1 -> {
//                    System.out.println(((Graph.Vertex) o1).getValue());
//                });


//        graph.getEdges().stream().forEach(
//                o -> {
//                    System.out.println(
//                            stations.get((Integer) ((Graph.Edge) o).getFromVertex().getValue()).getName() + " " +
//                                    stations.get((Integer) ((Graph.Edge) o).getToVertex().getValue()).getName() + " " +
//                                    ((Graph.Edge) o).getCost());
//                });
    }


    public void bjSubway(String from, String to) {
//        verticies.get(0).getEdges().forEach(
//                o -> {
//                    System.out.println(
//                            (stations.get((Integer) ((Graph.Edge) o).getFromVertex().getValue())).getName() + " " +
//                                    (stations.get((Integer) ((Graph.Edge) o).getToVertex().getValue())).getName() + " " +
//                                    ((Graph.Edge) o).getCost());
//                });
//
//        verticies.get(5).getEdges().forEach(
//                o -> {
//                    System.out.println(
//                            (stations.get((Integer) ((Graph.Edge) o).getFromVertex().getValue())).getName() + " " +
//                                    (stations.get((Integer) ((Graph.Edge) o).getToVertex().getValue())).getName() + " " +
//                                    ((Graph.Edge) o).getCost());
//                });

        Graph.Vertex vf = staNumInAllMapToVertex.get(staNameMapToStaNumInAll.get(from));
        Graph.Vertex ve = staNumInAllMapToVertex.get(staNameMapToStaNumInAll.get(to));
        Dijkstra.getShortestPath(graph, vf, ve).
                getPath().
                forEach(
                        o -> {
//                            System.out.println(o);
                            System.out.println(
                                    staNumInAllMapToStaName.get(((Graph.Edge) o).getFromVertex().getValue()) + " " +
                                            staNumInAllMapToStaName.get(((Graph.Edge) o).getToVertex().getValue()) + " " +
                                            ((Graph.Edge) o).getCost());
                        });
    }


    public static void main(String... args) {
        BjSubway bjSubway = new BjSubway();
        bjSubway.graphInit();
        bjSubway.bjSubway("安河桥北", "火器营");
    }
}
