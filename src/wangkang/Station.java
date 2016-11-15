package wangkang;

/**
 * Author: helin <1006604973@qq.com>.
 * Date: 14/11/2016 12:06
 */
public class Station {

    private String name;
    private Integer staNumInAll;//station number in all stations
    private Type type;

    enum Type {
        NORMAL,
        TRANSFER,
        ENDPOINT,
        ENDPOINTANDTRANSFER
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
}
