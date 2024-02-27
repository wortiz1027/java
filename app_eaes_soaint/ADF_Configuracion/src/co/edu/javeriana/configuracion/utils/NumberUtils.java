package co.edu.javeriana.configuracion.utils;

import java.math.BigDecimal;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import java.util.Locale;
import java.util.Random;

public class NumberUtils {
    public NumberUtils() {
        super();
    }
    public static Integer randomNumber(final Integer max){
        final Random rnd = new Random();
        return rnd.nextInt(max);
    }
    
    public static Float stringToFloat(String valor){
        valor=valor.replaceAll(",", ".");
        if(valor.indexOf(".")==-1){
            valor+=".0";
        }
        return Float.parseFloat(valor);
    }
    
    public static Double calcularPorcentaje(final Double total,final Double cantidad){
        final Double temp=(cantidad*100)/total;
        final BigDecimal res = NumberUtils.round(temp,null);
        return res.doubleValue();
    }
    public static BigDecimal round(final Double val,Integer decimal){
        if(decimal==null){
            decimal=2;
        }
        BigDecimal bd= new BigDecimal(val.toString());
        bd=bd.setScale(decimal, BigDecimal.ROUND_HALF_UP);
        return bd;
    }

    public static String decimalFormatbs(Object number) {
        if (number != null && !number.toString().trim().equals("")) {
            try {
                final Double num = Double.parseDouble(number.toString());
                final DecimalFormatSymbols formatSymbols = new DecimalFormatSymbols();
                formatSymbols.setGroupingSeparator(',');
                formatSymbols.setDecimalSeparator('.');
                final DecimalFormat df = new DecimalFormat("###,##0.00", formatSymbols);
                number = df.format(num);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return number.toString();
    }
    public static String decimalFormatMontos(Object number){
        if (number != null && !number.toString().trim().equals("")) {
            try {
                final Double num = Double.parseDouble(number.toString());
                final DecimalFormatSymbols formatSymbols = new DecimalFormatSymbols();
                formatSymbols.setGroupingSeparator(',');
                formatSymbols.setDecimalSeparator('.');
                final DecimalFormat df = new DecimalFormat("###,##0.00", formatSymbols);
                number = df.format(num);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return number.toString();
    }
    
    public static String decimalFormat(final Object number){
        if(number!=null && !number.toString().trim().equals("")){
            try{
                Double num=Double.parseDouble(number.toString());
                DecimalFormatSymbols formatSymbols = new DecimalFormatSymbols();
                formatSymbols.setDecimalSeparator(',');
                //formatSymbols.setGroupingSeparator('.');
                formatSymbols.setCurrencySymbol(".");
                DecimalFormat df = new DecimalFormat("###.##0,00", formatSymbols);
               // DecimalFormat df = new DecimalFormat("###.###,##",formatSymbols);    
                            
                
                return df.format(num);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return number.toString();
    }
    public static String intFormat(Object number){
        if(number!=null && !number.toString().trim().equals("")){
            try{
                Double num=Double.parseDouble(number.toString());
                DecimalFormatSymbols formatSymbols = new DecimalFormatSymbols();
                //formatSymbols.setDecimalSeparator(',');
                formatSymbols.setCurrencySymbol(".");
                DecimalFormat df = new DecimalFormat("###.##0,##", formatSymbols);
                return df.format(num);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return number.toString();
    }
    
    /*función para validar que una cadena de carácter es númerica */
   /* public static boolean isNumeric(String cadena){
            try {
                    Integer.parseInt(cadena);
                    return true;
            } catch (NumberFormatException nfe){
                    return false;
            }
    }*/
    
   public static String formatNumber(final Object moneyInCents) {
       Double num =Double.parseDouble(moneyInCents.toString());
       String format;
       Number value;
       if (num % 100 == 0) {
           format = "%d";
           value = num / 100;
       } else {
           format = "%.2f";
           value = num / 100.0;
       }
       return String.format(Locale.US, format, value);
   }    
    
    public static boolean isNumeric(final String str) {
          return str.matches("[+-]?\\d*(\\.\\d+)?") && str.equals("")==false;
      }
}
