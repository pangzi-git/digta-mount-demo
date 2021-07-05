package com.digital.mine.working.imitate.factory;


import lombok.Data;


@Data
public class SiteToSiteService {

    private String roadName;

    private Integer roadLength;

    private Integer runSpeedLoad;

    private Integer runSpeedUnLoad;

    public SiteToSiteService(String roadName, Integer roadLength, Integer runSpeedLoad, Integer runSpeedUnLoad) {
        this.roadName = roadName;
        this.roadLength = roadLength;
        this.runSpeedLoad = runSpeedLoad;
        this.runSpeedUnLoad = runSpeedUnLoad;
    }


    public Boolean run(CarService carService) {
        if (carService.getStatus().equals(0)) {
            carService.setStatus(1);
            carService.setRoadAmount(roadLength - runSpeedUnLoad);
            System.out.println("车 " + carService.getCarName() + "开始前往装载点"+"  剩余路程："+carService.getRoadAmount());
        } else if (carService.getStatus().equals(4)) {
            carService.setStatus(5);
            carService.setRoadAmount(roadLength - runSpeedLoad);
            System.out.println("车 " + carService.getCarName() + "开始前往卸载点"+"  剩余路程："+carService.getRoadAmount());
        } else if (carService.getStatus().equals(1)) {
            carService.setRoadAmount(carService.getRoadAmount() - runSpeedUnLoad);

            if (carService.getRoadAmount() <= 0) {
                carService.setStatus(2);
                System.out.println("车 " + carService.getCarName() + "到达装载点");
                return false;
            }

            System.out.println("车 " + carService.getCarName() + "正在前往装载点"+"  剩余路程："+carService.getRoadAmount());
        } else if (carService.getStatus().equals(5)) {
            carService.setRoadAmount(carService.getRoadAmount() - runSpeedLoad);

            if (carService.getRoadAmount() <= 0) {
                carService.setStatus(6);
                System.out.println("车 " + carService.getCarName() + "到达卸载点");
                return false;
            }
            System.out.println("车 " + carService.getCarName() + "正在前往卸载点"+"  剩余路程："+carService.getRoadAmount());
        }

        return false;

    }


}
