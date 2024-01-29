package com.kefu.util;

import com.kefu.enums.ResultEnum;
import org.springframework.util.ObjectUtils;

/**
 * @Description 检验对象是否为空
 * @Author 路文斌
 * @Date 2024/1/15 11:09
 */
public class CheckUtil {
    public <T>ResultEnum checkParam(T target){
        if(ObjectUtils.isEmpty(target)){
            return ResultEnum.EMPTY;
        }
    return ResultEnum.PARAMS_CHECK_SUCCESS;
    }
}
