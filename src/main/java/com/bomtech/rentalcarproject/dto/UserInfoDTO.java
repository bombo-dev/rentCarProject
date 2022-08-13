package com.bomtech.rentalcarproject.dto;

import java.util.Date;

public class UserInfoDTO {
    private int num;
    private String name;
    private String email;
    private String passwd;
    private String phone;
    private int point;
    private String signup_date;
    private String birth;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getSignup_date() {
        return signup_date;
    }

    public void setSignup_date(String signup_date) {
        this.signup_date = signup_date;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }
}
