package wangkang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: helin <1006604973@qq.com>.
 * Date: 14/11/2016 12:06
 */
public class Station {

    private String name;
    private Integer staNumInAll;//station number in all stations
    private Type type;
    private Map<Station, Integer> next = new HashMap<>();

    enum Type {
        NORMAL,
        TRANSFER,
        ENDPOINT,
        ENDPOINTANDTRANSFER
    }

    public void addNext(Station station, Integer distance) {
        next.put(station, distance);
    }

    public Map<Station, Integer> getNext() {
        return next;
    }

    Station(String name) {
        this(Type.NORMAL, name, 0);
    }

    Station(Type type, String name) {
        this(type, name, 0);
    }

    Station(String name, Integer staNumInAll) {
        this(Type.NORMAL, name, staNumInAll);
    }

    Station(Type type, String name, Integer staNumInAll) {
        this.type = type;
        this.name = name;
        this.staNumInAll = staNumInAll;
    }

    public Type getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStaNumInAll() {
        return staNumInAll;
    }

    public void setStaNumInAll(Integer staNum) {
        this.staNumInAll = staNumInAll;
    }
}
