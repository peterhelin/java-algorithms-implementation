package os.Experiment1_SingleProcessorScheduling;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Author: helin <1006604973@qq.com>.
 * Date: 18/11/2016 14:18
 */


public class ProcessScheduling {
    private static int cpuExcCurProStaTime;//cpu 开始执行当前进程的时间
    private static int cpuExcCurProEndTime;//cpu 结束执行当前进程的时间
    private static int curExcPId;//cpu 正在执行的进程的编号
    private static int curExcPexcTime = 0;//cpu 正在执行的进程的执行时间
    public static int algorithm;
    static Comparator<PCB> proRunTimeComparator = (p1, p2) -> {
        if (p1.getRunTime() != p2.getRunTime()) {//按作业时间长短排序, 进程运行时间相同时，按照先来先服务原则进行处理。
            return p1.getRunTime() - p2.getRunTime();
        } else if (p1.getArrTime() != p2.getArrTime()) {
            return p1.getArrTime() - p2.getArrTime();
        } else return p1.getPid() - p2.getPid();
    };

    static private Queue<PCB> waitingPcbs = new LinkedList<>(); //待调度队列
    static private Queue<PCB> executedPcbs = new LinkedList<>(); //已执行队列



    /**
     * 辅助方法2：获取t时刻到达的所有进程
     * 辅助对象：static private void cpuExc(PCB pcb, List<PCB> pcbList)
     *
     * @param t
     * @param pcbList
     * @return
     */
    private static List<PCB> proArr(int t, List<PCB> pcbList) {
        return pcbList.stream().filter(p -> p.getArrTime() == t).collect(Collectors.toList());
    }

    /**
     * cpu执行抢占式调度算法
     *
     * @param pcb
     * @param pcbList
     * @throws CloneNotSupportedException
     */
    static private void cpuExc(PCB pcb, List<PCB> pcbList) throws CloneNotSupportedException {
        pcb.setStaTime(cpuExcCurProStaTime); //设置进程开始执行时间

        for (; ; ) {
            curExcPexcTime++;
            pcb.setRunTime(pcb.getRunTime() - 1);
            //在cpuExcCurProStaTime+curExcPexcTime时刻，检测是否新的进程到来
            //如果有新进程到来，则在当前进程与到来进程之间选择剩余时间最少的进程执行
            List<PCB> arrPros = proArr(cpuExcCurProStaTime + curExcPexcTime, pcbList);
            if (arrPros.size() != 0) { //表示此时刻有进程到达
                arrPros.add(pcb);
                arrPros.stream().min((p1, p2) -> proRunTimeComparator.compare(p1, p2));
            } else { //表示没有进程到达

            }

            if (curExcPexcTime > pcb.getRunTime())
                break;
        }

    }

    /**
     * cpu执行非抢占式调度算法
     *
     * @param pcb
     * @throws CloneNotSupportedException
     */
    static private void cpuExc(PCB pcb) throws CloneNotSupportedException {
        pcb.setStaTime(cpuExcCurProStaTime); //设置进程开始执行时间
        //计算当前进程的执行时间
        //非抢占式，执行时间为进程执行完所需时间
        curExcPexcTime = pcb.getRunTime();
        pcb.setRunTime(pcb.getRunTime() - curExcPexcTime);
        //进程执行完，设置进程状态为PCB.State.END
        pcb.setState(PCB.State.END);
        addToExecutedPcbs(pcb);
    }

    /**
     * 辅助方法1：更新executedPcbs、cpuExcCurProEndTime、cpuExcCurProStaTime
     * 辅助对象： 1. static private void cpuExc(PCB pcb) throws CloneNotSupportedException
     *          2. static private void cpuExc(PCB pcb, List<PCB> pcbList) throws CloneNotSupportedException
     *
     * @param pcb
     * @throws CloneNotSupportedException
     */
    private static void addToExecutedPcbs(PCB pcb) throws CloneNotSupportedException {
        cpuExcCurProEndTime = cpuExcCurProStaTime + curExcPexcTime;
        executedPcbs.add(pcb.clone(cpuExcCurProStaTime, cpuExcCurProEndTime));
        cpuExcCurProStaTime = cpuExcCurProEndTime;
    }

    /**
     * First come first service
     *
     * @param pcbList
     * @throws CloneNotSupportedException
     */
    static void fcfs(List<PCB> pcbList) throws CloneNotSupportedException {
        //进程到达时间可由进程创建时间表示。进程到达时间相同时，优先处理进程号小的进程。
        Collections.sort(
                pcbList,
                (p1, p2) -> {
                    if (p1.getArrTime() != p2.getArrTime())
                        return p1.getArrTime() - p2.getArrTime();
                    else return p1.getPid() - p2.getPid();
                });

        pcbList.forEach(e -> waitingPcbs.add(e));
        //初始化cpu开始执行时间
        cpuExcCurProStaTime = waitingPcbs.peek().getStaTime();
        while (!waitingPcbs.isEmpty()) {
            PCB curExcPro = waitingPcbs.poll();

            cpuExc(curExcPro);
            //如果cpu执行完当前进程，没有进程到达，则需要重新初始化cpu开始执行时间
            if (cpuExcCurProEndTime < curExcPro.getArrTime())
                cpuExcCurProEndTime = curExcPro.getArrTime();

            if (curExcPro.getState() == PCB.State.NOTEND)
                waitingPcbs.add(curExcPro);
        }
    }

    /**
     * Shortest job first
     *
     * @param pcbList
     * @throws CloneNotSupportedException
     */
    static void sjf(List<PCB> pcbList) throws CloneNotSupportedException {

        //筛选出初始进程：最先到达，作业时间最短，进程编号最小的进程
        PCB initP = pcbList.stream().min((p1, p2) -> {
            if (p1.getArrTime() != p2.getArrTime())//先按进程到达时间
                return p1.getArrTime() - p2.getArrTime();
            else if (p1.getRunTime() != p2.getRunTime()) {//到达时间相同，再按作业时间长短排序
                return p1.getRunTime() - p2.getRunTime();
            } else // 到达时间和作业时间长短都相同，按照进程编号大小排序
                return p1.getPid() - p2.getPid();
        }).get();

        //初始化cpu开始执行时间
        cpuExcCurProEndTime = initP.getArrTime();
        waitingPcbs.add(initP);
        pcbList.remove(initP);

        while (!waitingPcbs.isEmpty()) {
            PCB curExcPro = waitingPcbs.poll();
            cpuExc(curExcPro);

            if (!pcbList.isEmpty()) {
                //筛选出cpu执行完当前进程所在时刻，已经到达，作业时间最短的作业。作业运行时间相同时，再按先来先服务原则处理。
                PCB pcb = pcbList.stream()
                        .filter(e -> e.getArrTime() <= cpuExcCurProEndTime)
                        .min((p1, p2) -> proRunTimeComparator.compare(p1, p2)).get();
                waitingPcbs.add(pcb);
                //如果cpu执行完当前进程，没有进程到达，则需要重新初始化cpu开始执行时间
                if (cpuExcCurProEndTime < pcb.getArrTime())
                    cpuExcCurProEndTime = pcb.getArrTime();
                //从进程队列中删除已经调度的进程
                pcbList.remove(pcb);
            }
        }
    }


    public static void main(String... args) throws CloneNotSupportedException {
        List<PCB> pcbList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        algorithm = Integer.parseInt(scanner.nextLine());

        while (true) {
            String l = scanner.nextLine();
            if ("".equals(l))
                break;
            List<Integer> info
                    = Arrays
                    .stream(l.split("/"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            PCB pcb = new PCB(info.get(0), info.get(1), info.get(2), info.get(3), info.get(4));
            pcbList.add(pcb);
        }
        switch (algorithm) {
            case 1:
                ProcessScheduling.fcfs(pcbList);
                break;
            case 2:
                ProcessScheduling.sjf(pcbList);
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            default:
                break;
        }


        int i = 1;
        while (!executedPcbs.isEmpty())
            System.out.println((i++) + "/" + executedPcbs.poll());
    }


}
