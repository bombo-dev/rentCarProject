package com.bomtech.rentalcarproject.controller;

import com.bomtech.rentalcarproject.dto.CarBrandDTO;
import com.bomtech.rentalcarproject.dto.CarCategoryDTO;
import com.bomtech.rentalcarproject.mapper.CarBrandMapper;
import com.bomtech.rentalcarproject.mapper.CarBrandMapperImpl;
import com.bomtech.rentalcarproject.mapper.CarCategoryMapper;
import com.bomtech.rentalcarproject.mapper.CarCategoryMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AdminPageController {

    private CarCategoryMapper carCategoryMapper;

    @Autowired
    public AdminPageController(CarCategoryMapper carCategoryMapper) {
        this.carCategoryMapper = carCategoryMapper;
    }

    @RequestMapping("/")
    public String index() {
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
}
