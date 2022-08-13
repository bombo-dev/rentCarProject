package com.bomtech.rentalcarproject.controller;

import com.bomtech.rentalcarproject.dto.CarProductDTO;
import com.bomtech.rentalcarproject.mapper.CarProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.annotation.Resource;
import java.io.File;

@Controller
public class ProductPageController {

    private final CarProductMapper carProductMapper;

    @Resource(name="uploadPath")
    private String uploadPath;

    @Autowired
    public ProductPageController(CarProductMapper carProductMapper){
        this.carProductMapper = carProductMapper;
    }

    @RequestMapping("/product_index.do")
    public String productIndex(){
        
        return "/product/index";
    }

    @GetMapping("/product_registration.do")
    public String productRegistration() {

        return "/product/product_registration";
    }

    @PostMapping("/product_registration.do")
    public String productRegistrationOk(HttpServletRequest req, @ModelAttribute CarProductDTO dto, BindingResult result) {

        /*
        if(result.hasErrors()){
            System.out.println("dto 상태" + dto);
            System.out.println(dto.getCar_image());
            System.out.println(result.getAllErrors().toString());

            return "redirect:product_registration.do";
        }
        */

        MultipartHttpServletRequest mr = (MultipartHttpServletRequest)req;
        MultipartFile file = mr.getFile("car_image");
        String filename = file.getOriginalFilename();

        File target = new File(uploadPath, filename);

        if (file.getSize() > 0) {
            try {
                file.transferTo(target);
            } catch (Exception e){}
        }
        dto.setCar_image(filename);
        int res = carProductMapper.insertProduct(dto);

        if (res>0) {
            req.setAttribute("msg", "차량 상품 등록에 성공하였습니다. 차종 목록 페이지로 이동합니다.");
            req.setAttribute("url", "product_index.do");
        }else {
            req.setAttribute("msg", "차종 등록에 실패하였습니다. 관리자 인덱스 페이지로 이동합니다.");
            req.setAttribute("url", "product_index.do");
        }

        return "/message";
    }

}
