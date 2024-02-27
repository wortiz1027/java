package co.xml;

import co.edu.javeriana.configuracion.load.Loader;

import java.util.Iterator;
import java.util.Map;
import java.util.logging.Logger;

public class Prueba {
    public static final Logger LOGGER = Logger.getLogger(Prueba.class.getName());
    public Prueba() {
        super();
    }

    public static void main(String[] args) {
        Loader load= Loader.getInstance();
        LOGGER.info(load.getWCCUrl());
       
    }
}
