package com.starriver.blog;

/**
 * @Name: CommonUtils
 * @Description: CommonUtils
 * @Author: chen
 * @Date: 2020-12-27
 * @Version:v1.0
 */
public class CommonUtils {
    public static long objectCovertLong(Object value){
        if(value == null){
            return  0;
        }
        try{
            return Long.valueOf(value.toString());
        }catch (NumberFormatException e){
            return  0;
        }
    }

    public static long stringCovertLong(String value){
        if(value == null){
            return  0;
        }
        try{
            return Long.valueOf(value);
        }catch (NumberFormatException e){
            return  0;
        }
    }

    public static long[] stringArrayCovertLong(String[] values){
        long[] results = new long[values.length];
        for(int i = 0; i< values.length; i ++){
            results[i] = stringCovertLong(values[i]);
        }
        return  results;
    }
}
