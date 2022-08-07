package com.bomtech.rentalcarproject.service;

import com.bomtech.rentalcarproject.dto.CarRawDTO;
import com.bomtech.rentalcarproject.mapper.CarRawMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RawNameToRawNumService {

    private CarRawMapper carRawMapper;

    public static List<CarRawDTO> carRawList = new ArrayList<>();

    @Autowired
    public RawNameToRawNumService(CarRawMapper carRawMapper){
        this.carRawMapper = carRawMapper;
    }

    public void setRawList(){
        List<CarRawDTO> list = carRawMapper.listRaw();

        for(CarRawDTO dto : list){
            carRawList.add(dto);
        }
    }
}
