package com.bomtech.rentalcarproject.controller;

import com.bomtech.rentalcarproject.dto.CarBrandDTO;
import com.bomtech.rentalcarproject.mapper.CarBrandMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class BrandPageController {


    private CarBrandMapper carBrandMapper;

    @Autowired
    public BrandPageController(CarBrandMapper carBrandMapper){
        this.carBrandMapper = carBrandMapper;
    }

    @RequestMapping("/brand_index.do")
    public String brandIndex(HttpServletRequest req){

        List<CarBrandDTO> list = carBrandMapper.listBrand();
        System.out.println("list : " + list);
        req.setAttribute("brandList", list);

        return "/brand/index";
    }
}
