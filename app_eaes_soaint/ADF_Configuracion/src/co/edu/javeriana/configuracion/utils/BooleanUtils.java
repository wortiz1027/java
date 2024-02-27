package co.edu.javeriana.configuracion.utils;

import java.math.BigDecimal;

import java.util.List;

public class BooleanUtils {
    public BooleanUtils() {
        super();
    }
    public static Boolean existe(final String valor) {
        return (valor != null && !valor.equals("")) ? Boolean.TRUE : Boolean.FALSE;
    }
    public static Boolean existe(final Object valor) {
        return (valor != null && !valor.equals("")) ? Boolean.TRUE : Boolean.FALSE;
    }
    public static Boolean existe(final Integer valor) {
        return (valor != null && !valor.toString().equals("")) ? Boolean.TRUE : Boolean.FALSE;
    }
    public static Boolean existe(final Float valor) {
        return (valor != null && !valor.toString().equals("")) ? Boolean.TRUE : Boolean.FALSE;
    }
    public static Boolean existe(final Double valor) {
        return (valor != null && !valor.toString().equals("")) ? Boolean.TRUE : Boolean.FALSE;
    }
    public static Boolean existe(final BigDecimal valor) {
        return (valor != null && !valor.equals("")) ? Boolean.TRUE : Boolean.FALSE;
    }
    public static Boolean existe(final List valor) {
        return (valor != null && !valor.isEmpty()) ? Boolean.TRUE : Boolean.FALSE;
    }
    public static Boolean existeBoolean(final Object valor) {
        return (valor != null && valor.toString().equalsIgnoreCase("true")) ? Boolean.TRUE : Boolean.FALSE;
    }
    public static Boolean existeServicio(final String valor) {
        return (valor != null && (valor.equals("S") || valor.equals("SI"))) ? Boolean.TRUE : Boolean.FALSE;
    }
    public static Boolean existeBinarioServicio(final String valor) {
        return (valor != null && valor.equals("1")) ? Boolean.TRUE : Boolean.FALSE;
    }
    public static String setBooleanServicio(final Boolean valor) {
        return (valor != null && valor) ? "S" :"N";
    }
}
