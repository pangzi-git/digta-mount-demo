package com.digital.mine.working.imitate.factory;


import lombok.Data;

@Data
public class MiningSiteService {

    private String miningSiteName;

    private ExcavatorService excavatorService;

    public MiningSiteService(String miningSiteName, ExcavatorService excavatorService) {
        this.miningSiteName = miningSiteName;
        this.excavatorService = excavatorService;
    }

    public Boolean mine(CarService carService){

        return excavatorService.loadCar(carService);
    }


}
