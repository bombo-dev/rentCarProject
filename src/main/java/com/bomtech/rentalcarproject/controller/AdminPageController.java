package com.bomtech.rentalcarproject.controller;

import com.bomtech.rentalcarproject.dto.CarBrandDTO;
import com.bomtech.rentalcarproject.dto.CarCategoryDTO;
import com.bomtech.rentalcarproject.mapper.*;
import com.bomtech.rentalcarproject.service.AppearanceNameToAppearanceNumService;
import com.bomtech.rentalcarproject.service.BrandNameToBrandNumService;
import com.bomtech.rentalcarproject.service.FuelNameToFuelNumService;
import com.bomtech.rentalcarproject.service.RawNameToRawNumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AdminPageController {

    private final CarCategoryMapper carCategoryMapper;
    private final AppearanceNameToAppearanceNumService appearanceNameToAppearanceNumService;
    private final BrandNameToBrandNumService brandNameToBrandNumService;
    private final RawNameToRawNumService rawNameToRawNumService;
    private final FuelNameToFuelNumService fuelNameToFuelNumService;


    @Autowired
    public AdminPageController(CarCategoryMapper carCategoryMapper,
                               AppearanceNameToAppearanceNumService appearanceNameToAppearanceNumService,
                               BrandNameToBrandNumService brandNameToBrandNumService,
                               RawNameToRawNumService rawNameToRawNumService,
                               FuelNameToFuelNumService fuelNameToFuelNumService) {
        this.carCategoryMapper = carCategoryMapper;
        this.appearanceNameToAppearanceNumService = appearanceNameToAppearanceNumService;
        this.brandNameToBrandNumService = brandNameToBrandNumService;
        this.rawNameToRawNumService = rawNameToRawNumService;
        this.fuelNameToFuelNumService = fuelNameToFuelNumService;
    }

    @RequestMapping("/")
    public String index() {

        if(BrandNameToBrandNumService.BrandList.size() == 0){
            brandNameToBrandNumService.setBrandList();
        }

        if(AppearanceNameToAppearanceNumService.carAppearanceList.size() == 0){
            appearanceNameToAppearanceNumService.setAppearanceList();
        }

        if(RawNameToRawNumService.carRawList.size() == 0){
            rawNameToRawNumService.setRawList();
        }

        if(FuelNameToFuelNumService.carFuelList.size() == 0){
            fuelNameToFuelNumService.setFuelList();
        }


        return "/index";
    }

    @RequestMapping("/admin_index.do")
    public String adminIndex() {
        return "/admin/index";
    }

    @RequestMapping("/category_insert.do")
    public String categoryInsert(HttpServletRequest req, CarCategoryDTO dto){
        int res = carCategoryMapper.insertCategory(dto);

        if (res>0) {
            req.setAttribute("msg", "차종 등록에 성공하였습니다. 차종 목록 페이지로 이동합니다.");
            req.setAttribute("url", "category_list.do");
        }else {
            req.setAttribute("msg", "차종 등록에 실패하였습니다. 관리자 인덱스 페이지로 이동합니다.");
            req.setAttribute("url", "admin_index.do");
        }
        return "/message";
    }

    @RequestMapping("/category_list.do")
    public String categoryList(HttpServletRequest req){
        List<CarCategoryDTO> list = carCategoryMapper.listCategory();

        req.setAttribute("listCategory", list);

        return "/admin/list";
    }

    @RequestMapping("/category_find.do")
    public String categoryFind(HttpServletRequest req){
        String search = req.getParameter("column");
        String searchString = req.getParameter("find_text");

        List<CarCategoryDTO> list = carCategoryMapper.findCategory(search, searchString);
        req.setAttribute("listCategory", list);
        return "/admin/list";
    }
}
