package wangkang;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: helin <1006604973@qq.com>.
 * Date: 14/11/2016 12:19
 */
public abstract class MetroLine {

    public abstract Station.Type getStaType(String staName);

    public abstract Integer getDisToNextStaInDO(String staName);

    public abstract void build();

    public abstract List<Station> getStationList();

    public abstract List<Integer> getDistanceList();

    public abstract String getNextStaName(String name);
}
