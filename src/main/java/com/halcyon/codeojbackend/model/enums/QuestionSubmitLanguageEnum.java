package com.halcyon.codeojbackend.model.enums;

import cn.hutool.core.util.ObjUtil;
import lombok.Getter;

/**
 * 题目提交编程语言枚举
 */
@Getter
public enum QuestionSubmitLanguageEnum {
    JAVA("java","java"),
    CPLUSPLUS("cpp","cpp"),
    GOLANG("golang","golang");

    private final String value;
    private final String text;

    QuestionSubmitLanguageEnum(String value, String text) {
        this.value = value;
        this.text = text;
    }

    /**
     * 根据value获取枚举
     */
    public static QuestionSubmitLanguageEnum getEnumByValue(String value){
        if(ObjUtil.isEmpty(value)){
            return null;
        }
        for(QuestionSubmitLanguageEnum anEnum : QuestionSubmitLanguageEnum.values()){
            if(anEnum.value.equals(value)){
                return anEnum;
            }
        }
        return null;
    }
}
