package com.digital.mine.working.imitate.factory;

import lombok.Data;

@Data
public class ExcavatorService {

    private String excavatorName;

    private Integer diggerSpeed;

    private CarService carService;

    /**
     * true 空闲
     * false 工作
     */
    private Boolean status;

    public ExcavatorService(String excavatorName, Integer diggerSpeed, Boolean status) {
        this.excavatorName = excavatorName;
        this.diggerSpeed = diggerSpeed;
        this.status = status;
    }

    public Boolean loadCar(CarService carService){
        if(status){
            this.carService=carService;
            carService.setLoadAmount(carService.getLoadAmount()+diggerSpeed);
            carService.setStatus(3);
            System.out.println("车 "+carService.getCarName()+"开始装载");
            this.status=false;

            return true;
        }else {
            if(carService.getCarName().equals(this.getCarService().getCarName())){

                carService.setLoadAmount(carService.getLoadAmount()+diggerSpeed);

                if(carService.getLoadAmount()>=carService.getLoadAmountMax()){
                    this.status=true;
                    this.carService=null;
                    carService.setLoadAmount(carService.getLoadAmountMax());
                    System.out.println("车 "+carService.getCarName()+"装载完成");
                    carService.setStatus(4);
                    return true;
                }
                System.out.println("车 "+carService.getCarName()+"正在装载"+carService.toString());
                return true;
            }else {
                this.carService.setStatus(2);
                System.out.println("车 "+carService.getCarName()+"等待装载");
                return false;
            }

        }
    }
}
