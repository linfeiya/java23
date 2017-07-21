package com.kaishengit.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;

/**
 * Created by linfeiya on 2017/7/14 0014.
 */
public class StringUtil{

    private static Logger logger = LoggerFactory.getLogger(StringUtils.class);

    public static String isoToUtf8(String str){
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new String(str.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e){
            logger.error("{}中文乱码了",str);
            throw new RuntimeException("中文转码异常",e);
        }
    }


}


