package com.bomtech.rentalcarproject.service;

import com.bomtech.rentalcarproject.dto.CarAppearanceDTO;
import com.bomtech.rentalcarproject.mapper.CarAppearanceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppearanceNameToAppearanceNumService {

    private CarAppearanceMapper carAppearanceMapper;

    public static List<CarAppearanceDTO> carAppearanceList = new ArrayList<>();

    @Autowired
    public AppearanceNameToAppearanceNumService(CarAppearanceMapper carAppearanceMapper){
        this.carAppearanceMapper = carAppearanceMapper;
    }

    public void setAppearanceList(){
        List<CarAppearanceDTO> list = carAppearanceMapper.carAppearanceList();

        for(CarAppearanceDTO dto : list){
            carAppearanceList.add(dto);
        }
    }


}
