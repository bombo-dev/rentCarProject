package com.bomtech.rentalcarproject.service;

import com.bomtech.rentalcarproject.dto.CarBrandDTO;
import com.bomtech.rentalcarproject.mapper.CarBrandMapper;
import com.bomtech.rentalcarproject.mapper.CarBrandMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandNameToBrandNumService {
    private CarBrandMapper carBrandMapper;

//    @Autowired
    public BrandNameToBrandNumService(CarBrandMapperImpl carBrandMapper){
        this.carBrandMapper = carBrandMapper;
    }

    public static List<CarBrandDTO> koreaBrandList;
    public static List<CarBrandDTO> germanyBrandList;
    public static List<CarBrandDTO> japenBrandList;
    public static List<CarBrandDTO> americaBrandList;
    public static List<CarBrandDTO> italyBrandList;

    public void setList(){
        List<CarBrandDTO> list = carBrandMapper.listBrand();
        System.out.println("list : " + list.get(0));
        for(CarBrandDTO value : list){
            if(value.getBrand_num().toString().startsWith("0")){
                koreaBrandList.add(value);
            }
            else if(value.getBrand_num().toString().startsWith("1")){
                germanyBrandList.add(value);
            }
            else if(value.getBrand_num().toString().startsWith("2")){
                japenBrandList.add(value);
            }
            else if(value.getBrand_num().toString().startsWith("3")){
                americaBrandList.add(value);
            }
            else if(value.getBrand_num().toString().startsWith("4")){
                italyBrandList.add(value);
            }
        }
    }




}
