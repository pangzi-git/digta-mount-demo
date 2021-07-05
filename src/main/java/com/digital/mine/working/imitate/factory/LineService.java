package com.digital.mine.working.imitate.factory;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class LineService {
    private String LineName;

    MiningSiteService miningSiteService;

    UnLoadSiteService unLoadSiteService;

    SiteToSiteService siteToSiteService;

    List<CarService> carServices;

    public LineService(String lineName, MiningSiteService miningSiteService, UnLoadSiteService unLoadSiteService, SiteToSiteService siteToSiteService,List<CarService> carServices) {
        LineName = lineName;
        this.miningSiteService = miningSiteService;
        this.unLoadSiteService = unLoadSiteService;
        this.siteToSiteService = siteToSiteService;
        this.carServices=carServices;
    }


    public Boolean addCar(CarService car){
        this.carServices.add(car);
        return true;
    }


    public void runs( ) {

        for (CarService car : carServices) {
            run(car);
        }

        if (unLoadSiteService.getUnLoadTotalAmount() > unLoadSiteService.getUnLoadTotalAmountMax()) {
            List<CarService> carServicesNew=new ArrayList<>();
            for (CarService car : carServices) {
                if (!car.getStatus().equals(0)) {
                    carServicesNew.add(car);
                }else {
                    System.out.println("Car :" + car.getCarName() + "  休息");
                }
            }
            carServices=carServicesNew;
        }

    }

    public void run(CarService carService) {
        Integer carStatus = carService.getStatus();

        if (carStatus.equals(0) || carStatus.equals(1) || carStatus.equals(4) || carStatus.equals(5)) {
            siteToSiteService.run(carService);
        } else if (carStatus.equals(2) || carStatus.equals(3)) {
            miningSiteService.mine(carService);
        } else if (carStatus.equals(6) || carStatus.equals(7)) {
            unLoadSiteService.unloadCar(carService);
        }
    }


}
