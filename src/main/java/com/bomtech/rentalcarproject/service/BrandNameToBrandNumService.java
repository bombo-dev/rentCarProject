package com.bomtech.rentalcarproject.service;

import com.bomtech.rentalcarproject.dto.CarBrandDTO;
import com.bomtech.rentalcarproject.mapper.CarBrandMapper;
import com.bomtech.rentalcarproject.mapper.CarBrandMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrandNameToBrandNumService {
    private final CarBrandMapper carBrandMapper;

    @Autowired
    public BrandNameToBrandNumService(CarBrandMapper carBrandMapper){
        this.carBrandMapper = carBrandMapper;
    }

    public static List<CarBrandDTO> BrandList = new ArrayList<>();

    public void setBrandList(){
        List<CarBrandDTO> list = carBrandMapper.listBrand();

        for(CarBrandDTO value : list){
            if(value.getBrand_num().startsWith("0")){
                BrandList.add(value);
            }
        }
    }




}
