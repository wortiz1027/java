package co.edu.javeriana.configuracion.utils;

import java.math.BigDecimal;

import java.util.Date;

public class ValueUtils {
    public ValueUtils() {
        super();
    }
    public static String validValue(final String val){
        try{
            return BooleanUtils.existe(val)?val:"";
        }catch(NullPointerException e){
            return "";
        }
    }
    public static Date validValue(final Date val){
        try{
            return BooleanUtils.existe(val)?val:null;
        }catch(NullPointerException e){
            return null;
        }
    }
    public static Long validValue(final Long val){
        try{
         return BooleanUtils.existe(val)?val:0L;
        }catch(NullPointerException e){
            return 0L;
        }
    }
    public static Integer validValue(final Integer val){
        try{
         return BooleanUtils.existe(val)?val:0;
        }catch(NullPointerException e){
            return 0;
        }
    }
    public static Double validValue(final Double val){
        try{
            return BooleanUtils.existe(val)?val:0d;
        }catch(NullPointerException e){
            return 0d;
        }
    }
    public static Float validValue(final Float val){
        try{
            return BooleanUtils.existe(val)?val:0f;
        }catch(NullPointerException e){
            return 0f;
        }
    }
    public static Boolean validValue(final Boolean val){
        try{
            return BooleanUtils.existe(val)?val:Boolean.FALSE;
        }catch(NullPointerException e){
            return Boolean.FALSE;
        }
    }
    public static BigDecimal validValue(final BigDecimal val){
        try{
         return BooleanUtils.existe(val) ? val : new BigDecimal(0);
        }catch(NullPointerException e){
            return new BigDecimal(0);
        }
    }
}
