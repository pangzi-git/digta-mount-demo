package com.digital.mine.working.imitate;

import com.digital.mine.working.imitate.factory.*;

import java.util.ArrayList;
import java.util.List;

public class RunDemo {

    public static void main(String[] args) {

        ExcavatorService excavatorService = new ExcavatorService("E-1", 6, true);
        MiningSiteService miningSiteService = new MiningSiteService("M-1", excavatorService);
        UnLoadSiteService unLoadSiteService = new UnLoadSiteService("U-1", 300, true,10000);
        SiteToSiteService siteToSiteService = new SiteToSiteService("R-1", 120, 3, 60);


        List<CarService> carServices = new ArrayList<>();
        carServices.add(new CarService("C-1", 30));
        carServices.add(new CarService("C-2", 30));
        carServices.add(new CarService("C-3", 30));
        carServices.add(new CarService("C-4", 30));
        carServices.add(new CarService("C-5", 30));
        carServices.add(new CarService("C-6", 30));
        carServices.add(new CarService("C-7", 30));
        carServices.add(new CarService("C-8", 30));
        LineService lineService = new LineService("L-1", miningSiteService, unLoadSiteService, siteToSiteService, carServices);
        int i = 0;
        while (i < 100000) {
            System.out.println("时间：" + i);
            if (lineService.getCarServices().size() > 0) {
                lineService.runs();
                System.out.println("\n");
            } else {
                break;
            }

            if(i==50){
                lineService.addCar(new CarService("C-10", 300
                )) ;
            }
            i++;
        }


    }
}
