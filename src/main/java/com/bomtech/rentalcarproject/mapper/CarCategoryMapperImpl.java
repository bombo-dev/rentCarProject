package com.bomtech.rentalcarproject.mapper;

import com.bomtech.rentalcarproject.dto.*;
import com.bomtech.rentalcarproject.service.AppearanceNameToAppearanceNumService;
import com.bomtech.rentalcarproject.service.BrandNameToBrandNumService;
import com.bomtech.rentalcarproject.service.FuelNameToFuelNumService;
import com.bomtech.rentalcarproject.service.RawNameToRawNumService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

@Service
public class CarCategoryMapperImpl implements CarCategoryMapper{

    @Autowired
    private SqlSession sqlSession;

    public int insertCategory(CarCategoryDTO dto) {

        String brand_code = "";
        String appearance_code = "";
        String raw_code = "";
        String fuel_code = "";
        String lastCarCode;

        for(CarBrandDTO brand : BrandNameToBrandNumService.BrandList){
            if(brand.getBrand_name().equals(dto.getBrand())){
                brand_code = brand.getBrand_num();
            }
        }

        for(CarAppearanceDTO appearance : AppearanceNameToAppearanceNumService.carAppearanceList){
            if(appearance.getAppearance_name().equals(dto.getAppearance())){
                appearance_code = appearance.getAppearance_num();
            }
        }

        for(CarRawDTO raw : RawNameToRawNumService.carRawList){
            if(raw.getRaw_name().equals(dto.getUse())){
                raw_code = raw.getRaw_num();
            }
        }

        for(CarFuelDTO fuel : FuelNameToFuelNumService.carFuelList){
            if(fuel.getFuel_name().equals(dto.getFuel())){
                fuel_code = fuel.getFuel_num();
            }
        }

        String checkCode = brand_code + appearance_code + raw_code + fuel_code;

        List<String> sameCarList = sqlSession.selectList("checkCarCode", checkCode);
        System.out.println(sameCarList);
        if(sameCarList.size()==0){
            lastCarCode = checkCode + "00";
        } else{
            String value = sameCarList.get(sameCarList.size() - 1);
            value = value.substring(value.length()-2, value.length());
            int toValue = Integer.parseInt(value) + 1;
            String lastValue = String.format("%02d", toValue);
            lastCarCode = checkCode + lastValue;
        }

        dto.setCar_code(lastCarCode);

        return sqlSession.insert("insertCategory", dto);
    }

    public List<CarCategoryDTO> listCategory(){
        return sqlSession.selectList("listCategory");
    }

    public List<CarCategoryDTO> findCategory(String search, String searchString){
        Map<String, String> map = new Hashtable<>();

        map.put("search", search);
        map.put("searchString", searchString);

        return sqlSession.selectList("findCategory", map);
    }

    public int deleteCategory(int cate_code){
        return sqlSession.delete("deleteCategory", cate_code);
    }
}
