package com.kefu.util;

import com.kefu.enums.ResultEnum;
import org.springframework.util.ObjectUtils;


public class CheckUtil {
    public <T>ResultEnum checkParam(T target){
        if(ObjectUtils.isEmpty(target)){
            return ResultEnum.EMPTY;
        }
    return ResultEnum.PARAMS_CHECK_SUCCESS;
    }
}
