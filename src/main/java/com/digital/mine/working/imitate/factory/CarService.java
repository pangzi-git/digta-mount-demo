package com.digital.mine.working.imitate.factory;

import lombok.Data;


@Data
public class CarService {

    private String carName;

    /**
     * 货车货物量
     */
    private Integer loadAmount=0;

    /**
     * 剩余货车路程
     */
    private Integer roadAmount=0;

    private Integer loadAmountMax=30;
    /**
     * 0.待命/卸载完成
     * 1。前往装载点
     * 2.等待装载
     * 3.装载中
     * 4.装载完成
     * 5.前往卸载点
     * 6.等待卸载
     * 7.卸载中
     *
     */
    private Integer status;

    public CarService(String carName,  Integer loadAmountMax) {
        this.carName = carName;
        this.loadAmountMax = loadAmountMax;
        this.status = 0;
    }

    @Override
    public String toString() {
        return "CarService{" +
                "carName='" + carName + '\'' +
                ",货车货物量 loadAmount=" + loadAmount +
                ", 剩余路程 roadAmount=" + roadAmount +
                ",货车最大货物量 loadAmountMax=" + loadAmountMax +
                ", status=" + status +
                '}';
    }
}
