package com.halcyon.codeojbackend.model.enums;

import cn.hutool.core.util.ObjUtil;
import lombok.Getter;

@Getter
public enum UserRoleEnum {
    USER("user", "普通用户"),
    ADMIN("admin", "管理员");

    private final String value;
    private final String text;

    UserRoleEnum(String value, String text) {
        this.value = value;
        this.text = text;
    }

    public static UserRoleEnum getEnumByValue(String value) {
        if(ObjUtil.isEmpty(value)){
            return null;
        }
        for(UserRoleEnum roleEnum : UserRoleEnum.values()){
            if(roleEnum.value.equals(value)){
                return roleEnum;
            }
        }
        return null;
    }
}
