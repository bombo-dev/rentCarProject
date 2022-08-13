package com.bomtech.rentalcarproject.controller;

import com.bomtech.rentalcarproject.dto.UserInfoDTO;
import com.bomtech.rentalcarproject.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginPageController {

    private final UserInfoMapper userInfoMapper;

    @Autowired
    public LoginPageController(UserInfoMapper userInfoMapper){
        this.userInfoMapper = userInfoMapper;
    }

    @RequestMapping("/login.do")
    public String loginIndex(){
        return "login/login";
    }

    @RequestMapping("/signup.do")
    public String signUpIndex() {
        return "signup/index";
    }

    @RequestMapping("/signupOk.do")
    public String signUpOk(Model model, @ModelAttribute UserInfoDTO dto, BindingResult result) {
        if(result.hasErrors()){
            System.out.println(dto.getSignup_date());
            return "redirect:signup.do";
        }
        int res = userInfoMapper.insertUser(dto);

        if (res>0) {
            model.addAttribute("msg", "회원 가입에 성공하였습니다. 로그인 페이지로 이동합니다.");
            model.addAttribute("url", "login.do");
        }else {
            model.addAttribute("msg", "회원 가입에 실패하였습니다. 다시 회원가입을 해주세요.");
            model.addAttribute("url", "signup.do");
        }

        return "/message";


    }

}
