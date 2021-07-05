package com.digital.mine.working.imitate.factory;


import lombok.Data;


@Data
public class UnLoadSiteService {
    private String unLoadSiteName;

    private Integer unLoadSpeed;

    private CarService carService;

    private Integer unLoadTotalAmount;

    private Integer unLoadTotalAmountMax ;

    /**
     * true 空闲
     * false 工作
     */
    private Boolean status;

    public UnLoadSiteService(String unLoadSiteName, Integer unLoadSpeed, Boolean status,Integer unLoadTotalAmountMax) {
        this.unLoadTotalAmount = 0;
        this.unLoadSiteName = unLoadSiteName;
        this.unLoadSpeed = unLoadSpeed;
        this.status = status;
        this.unLoadTotalAmountMax=unLoadTotalAmountMax;
    }

    public Boolean unloadCar(CarService carService) {
        if (status) {
            this.carService = carService;
            if (unLoadSpeed >=carService.getLoadAmount()) {
                unLoadTotalAmount = unLoadTotalAmount + carService.getLoadAmount();
                carService.setLoadAmount(0);
                carService.setStatus(0);
                System.out.println("车 " + carService.getCarName() + "开始卸载&卸载完成");
                System.out.println("卸载平台 :" + unLoadSiteName + "   unLoadAmount" + unLoadTotalAmount);
                this.status = true;
            }else {
                Integer unLoadAmount = unLoadSpeed > carService.getLoadAmount() ? carService.getLoadAmount() : unLoadSpeed;
                unLoadTotalAmount = unLoadTotalAmount + unLoadAmount;

                carService.setLoadAmount(carService.getLoadAmount() - unLoadAmount);
                carService.setStatus(7);
                System.out.println("车 " + carService.getCarName() + "开始卸载");
                System.out.println("卸载平台 :" + unLoadSiteName + "   unLoadAmount" + unLoadTotalAmount);
                this.status = false;
            }


        } else {
            if (carService.getCarName().equals(this.getCarService().getCarName())) {
                Integer unLoadAmount = unLoadSpeed > carService.getLoadAmount() ? carService.getLoadAmount() : unLoadSpeed;

                carService.setLoadAmount(carService.getLoadAmount() - unLoadAmount);
                if (carService.getLoadAmount() <= 0) {
                    this.status = true;
                    this.carService = null;
                    carService.setLoadAmount(0);
                    carService.setStatus(0);

                    unLoadTotalAmount = unLoadTotalAmount + unLoadAmount;
                    System.out.println("车 " + carService.getCarName() + "卸载完成");

                } else {
                    unLoadTotalAmount = unLoadTotalAmount + unLoadAmount;
                    System.out.println("车 " + carService.getCarName() + "正在卸载" + carService.toString());
                }
                System.out.println("卸载平台 :" + unLoadSiteName + "   unLoadAmount :" + unLoadTotalAmount);
            } else {
                this.carService.setStatus(6);
                System.out.println("车 " + carService.getCarName() + "等待卸载");
            }

        }
        return true;
    }


}
