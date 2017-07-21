package com.kaishengit.util;

import java.io.UnsupportedEncodingException;

/**
 * Created by linfeiya on 2017/7/20 0020.
 */
public class StringUtil{

    public static String isoUtf8(String str){
        if(str == null || "".equals(str.trim())){
            return null;
        }
        try {
            return new String(str.getBytes("ISO-8859-1"),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("转码错误",e);
        }
    }
}
