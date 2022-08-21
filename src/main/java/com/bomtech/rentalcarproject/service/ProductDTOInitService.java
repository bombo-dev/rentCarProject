package com.bomtech.rentalcarproject.service;

import com.bomtech.rentalcarproject.dto.CarProductDTO;
import com.bomtech.rentalcarproject.mapper.CarProductMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.annotation.HttpConstraint;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Aspect
@Component
public class ProductDTOInitService {

    private final CarProductMapper carProductMapper;
    private final AppearanceNameToAppearanceNumService appearanceNameToAppearanceNumService;
    private final BrandNameToBrandNumService brandNameToBrandNumService;
    private final RawNameToRawNumService rawNameToRawNumService;
    private final FuelNameToFuelNumService fuelNameToFuelNumService;

    @Autowired
    public ProductDTOInitService(CarProductMapper carProductMapper, AppearanceNameToAppearanceNumService appearanceNameToAppearanceNumService,
                                 BrandNameToBrandNumService brandNameToBrandNumService,
                                 RawNameToRawNumService rawNameToRawNumService,
                                 FuelNameToFuelNumService fuelNameToFuelNumService) {

        this.carProductMapper = carProductMapper;
        this.appearanceNameToAppearanceNumService = appearanceNameToAppearanceNumService;
        this.brandNameToBrandNumService = brandNameToBrandNumService;
        this.rawNameToRawNumService = rawNameToRawNumService;
        this.fuelNameToFuelNumService = fuelNameToFuelNumService;
    }


    @Before("execution(* com.bomtech.rentalcarproject.controller.*.*(..))")
    public void beforeStarting(JoinPoint jp) throws Throwable {

        HttpSession session = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest().getSession();
        if (session.getAttribute("car_product") == null) {

            if (BrandNameToBrandNumService.BrandList.size() == 0) {
                brandNameToBrandNumService.setBrandList();
            }

            if (AppearanceNameToAppearanceNumService.carAppearanceList.size() == 0) {
                appearanceNameToAppearanceNumService.setAppearanceList();
            }

            if (RawNameToRawNumService.carRawList.size() == 0) {
                rawNameToRawNumService.setRawList();
            }

            if (FuelNameToFuelNumService.carFuelList.size() == 0) {
                fuelNameToFuelNumService.setFuelList();
            }


            List<CarProductDTO> productDTO = carProductMapper.listProduct();
            session.setAttribute("car_product", productDTO);
        }

    }
}
