package com.bomtech.rentalcarproject.service;

import com.bomtech.rentalcarproject.dto.CarFuelDTO;
import com.bomtech.rentalcarproject.mapper.CarFuelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FuelNameToFuelNumService {

    private CarFuelMapper carFuelMapper;

    public static List<CarFuelDTO> carFuelList = new ArrayList<>();

    @Autowired
    public FuelNameToFuelNumService(CarFuelMapper carFuelMapper){
        this.carFuelMapper = carFuelMapper;
    }

    public void setFuelList(){
        List<CarFuelDTO> list = carFuelMapper.listFuel();

        for(CarFuelDTO dto : list){
            carFuelList.add(dto);
        }
    }
}
