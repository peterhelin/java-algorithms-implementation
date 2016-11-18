package os.Experiment1_SingleProcessorScheduling;

import java.net.PortUnreachableException;

/**
 * Author: helin <1006604973@qq.com>.
 * Date: 18/11/2016 14:08
 */
public class PCB
        implements Comparable, Cloneable {

    enum State {
        END,
        NOTEND;
    }

    private int pid;

    private int arrTime;
    private int runTime;
    private int staTime;
    private int endTime;
    private int priority;
    public static int timeSlice;

    private State state;

    public State getState() {
        return state;
    }

    public void setRunTime(int runTime) {
        this.runTime = runTime;
    }


    public void setState(State state) {
        this.state = state;
    }

    public int getPid() {
        return pid;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public void setStaTime(int staTime) {
        this.staTime = staTime;
    }

    public int getArrTime() {
        return arrTime;

    }

    public int getRunTime() {
        return runTime;
    }

    public int getStaTime() {
        return staTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public int getPriority() {
        return priority;
    }

    public int getTimeSlice() {
        return timeSlice;
    }

    public PCB(int pid, int arrTime, int runTime, int priority, int timeSlice) {
        this.pid = pid;
        this.arrTime = arrTime;
        this.runTime = runTime;
        this.priority = priority;
        this.timeSlice = timeSlice;
        this.state = State.NOTEND;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public PCB clone() throws CloneNotSupportedException {
        return (PCB) super.clone();
    }

    public PCB clone(Integer staTime, Integer endTime) throws CloneNotSupportedException {
        PCB newPcb = this.clone();
        newPcb.setStaTime(staTime);
        newPcb.setEndTime(endTime);
        return newPcb;
    }

    @Override
    public String toString() {
//        return "pid: " + pid + ", arrTime: " + arrTime + ", runTime: "+runTime + ", staTime: " + staTime +   ", endTime: " + endTime + ", priority" + priority;

        return "" + pid + "/" + staTime + "/" + endTime + "/" + priority;
    }
}
