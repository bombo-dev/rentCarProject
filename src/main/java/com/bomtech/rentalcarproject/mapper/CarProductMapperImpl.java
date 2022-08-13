package com.bomtech.rentalcarproject.mapper;

import com.bomtech.rentalcarproject.dto.CarCategoryDTO;
import com.bomtech.rentalcarproject.dto.CarProductDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

@Service
public class CarProductMapperImpl implements CarProductMapper {

    @Autowired
    private SqlSession sqlSession;

    @Override
    public List<CarProductDTO> listProduct() {
        return sqlSession.selectList("listProduct");
    }

    @Override
    public int insertProduct(CarProductDTO dto) {
        String checkCode;
        String lastCarCode;

        Map<String, String> map = new Hashtable<>();
        map.put("search", "car_name");
        map.put("searchString", dto.getCar_name());
        List<CarCategoryDTO> categoryDTO = sqlSession.selectList("findCategory", map);


        if (categoryDTO.size() == 0){
            // ProductController에 -1 들어왔을 때 다시 메세지 전달
            return -1;
        }
        else {
            checkCode = sqlSession.selectOne("getCarCode", categoryDTO.get(0).getNum());
            List<String> sameCarCategoryList = sqlSession.selectList("productCheckCarCode", checkCode);
            if(sameCarCategoryList.size() == 0){
                lastCarCode = checkCode + "00";
            } else {
                String value = sameCarCategoryList.get(sameCarCategoryList.size() - 1);
                value = value.substring(value.length() - 2, value.length());
                int toValue = Integer.parseInt(value) + 1;
                String lastValue = String.format("%02d", toValue);
                lastCarCode = checkCode + lastValue;
            }
        }
        dto.setCar_num(categoryDTO.get(0).getNum());
        dto.setCar_code(lastCarCode);

        return sqlSession.insert("insertProduct", dto);
    }

    @Override
    public int updateReservation(CarProductDTO dto) {
        return 0;
    }
}

