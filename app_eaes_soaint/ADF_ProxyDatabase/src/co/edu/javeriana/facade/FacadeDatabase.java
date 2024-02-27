package co.edu.javeriana.facade;

import co.edu.javeriana.proxies.consultardocumento.proxy.BpelConsultardocumento;
import co.edu.javeriana.proxies.consultardocumento.proxy.BpelConsultardocumentoClientEp;
import co.edu.javeriana.proxies.consultardocumento.types.OutputType;
import co.edu.javeriana.proxies.consultarprototipo.proxy.BpelConsultarprototipo;
import co.edu.javeriana.proxies.consultarprototipo.proxy.BpelConsultarprototipoClientEp;
import co.edu.javeriana.proxies.consultarprototipo.types.PrototipoType;
import co.edu.javeriana.proxies.insertarcolaborador.proxy.BpelInscolaborador;
import co.edu.javeriana.proxies.insertarcolaborador.proxy.BpelInscolaboradorClientEp;
import co.edu.javeriana.proxies.insertarcolaborador.types.InsertarColaboradorType;
import co.edu.javeriana.proxies.insertarprototipo.proxy.BpelInsertarprototipo;
import co.edu.javeriana.proxies.insertarprototipo.proxy.BpelInsertarprototipoClientEp;

import co.edu.javeriana.negocio.Prototipo;
import co.edu.javeriana.negocio.Colaborador;
import co.edu.javeriana.negocio.Recomendacion;

import co.edu.javeriana.configuracion.utils.DateUtils;

import co.edu.javeriana.proxies.insertarprototipo.types.InsertarPrototipoType;

import co.edu.javeriana.proxies.insertarprototipo.types.RecomendacionesType;

import java.math.BigDecimal;

import javax.xml.ws.BindingProvider;

import oracle.adf.share.logging.ADFLogger;

public class FacadeDatabase {
    public static final ADFLogger LOGGER = ADFLogger.createADFLogger(FacadeDatabase.class);
    
    private static final String WSDL_INSERTAR_PROTOTIPO   = "http://bpm-dv1:7003/soa-infra/services/default/SOA_Database/bpel_insertarprototipo_client_ep?WSDL";
    private static final String WSDL_INSERTAR_COLABORADOR = "http://bpm-dv1:7003/soa-infra/services/default/SOA_Database/bpel_inscolaborador_client_ep?WSDL";
    private static final String WSDL_CONSULTAR_PROTOTIPO  = "http://bpm-dv1:7003/soa-infra/services/default/SOA_Database/bpel_consultarprototipo_client_ep?WSDL";
    private static final String WSDL_CONSULTAR_DOCUMENTO  = "http://bpm-dv1:7003/soa-infra/services/default/SOA_Database/bpel_consultardocumento_client_ep?WSDL";
    
    private static BpelInsertarprototipoClientEp service1;
    private static BpelInsertarprototipo port1;
        
    private static BpelInscolaboradorClientEp service2;
    private static BpelInscolaborador port2;
        
    private static BpelConsultarprototipoClientEp service3;
    private static BpelConsultarprototipo port3;
        
    private static BpelConsultardocumentoClientEp service4;
    private static BpelConsultardocumento port4;
        
    public FacadeDatabase() {
    }
    
    private static BpelInsertarprototipoClientEp getServiceInsertarPrototipo() {
        if (service1 == null) {
            service1 = new BpelInsertarprototipoClientEp();
        }
        
        return service1;
    }
    
    private static BpelInsertarprototipo getPortInsertarPrototipo() {
        try {
            if (port1 == null) {
                port1 = getServiceInsertarPrototipo().getBpelInsertarprototipoPt();
                ((BindingProvider) port1).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, WSDL_INSERTAR_PROTOTIPO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return port1;
    }
    
    private static BpelInscolaboradorClientEp getServiceInsertarColaborador() {
        if (service2 == null) {
            service2 = new BpelInscolaboradorClientEp();
        }
        
        return service2;
    }
    
    private static BpelInscolaborador getPortInsertarColaborador() {
        try {
            if (port2 == null) {
                port2 = getServiceInsertarColaborador().getBpelInscolaboradorPt();
                ((BindingProvider) port2).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, WSDL_INSERTAR_COLABORADOR);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return port2;
    }
    
    public static BpelConsultarprototipoClientEp getServiceConsultarPrototipo() {
        if (service3 == null) {
            service3 = new BpelConsultarprototipoClientEp();
        }
        
        return service3;
    }
    
    private static BpelConsultarprototipo getPortConsultarPrototipo() {
        try {
            if (port3 == null) {
                port3 = getServiceConsultarPrototipo().getBpelConsultarprototipoPt();
                ((BindingProvider) port3).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, WSDL_CONSULTAR_PROTOTIPO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return port3;
    }
    
    private static BpelConsultardocumentoClientEp getServiceConsultarDocumento() {
        if (service4 == null) {
            service4 = new BpelConsultardocumentoClientEp();
        }
        
        return service4;
    }
    
    private static BpelConsultardocumento getPortConsultarDocumento() {
        try {
            if (port4 == null) {
                port4 = getServiceConsultarDocumento().getBpelConsultardocumentoPt();
                ((BindingProvider) port4).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, WSDL_CONSULTAR_DOCUMENTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return port4;
    }
    
    public static void insertarProtipo(Prototipo prototipo, String response) {
        //1. contruir el request
        InsertarPrototipoType rq = new InsertarPrototipoType(); 
        rq.setConocimientos(prototipo.getConocimiento());
        rq.setDetalle(prototipo.getDetalle());
        rq.setEstado(prototipo.getEstado());
        rq.setFechaFin(DateUtils.dateToXMLGregorianCalendar(prototipo.getFechaFin()));
        rq.setFechaInicio(DateUtils.dateToXMLGregorianCalendar(prototipo.getFechaInicio()));
        rq.setPresupuesto(prototipo.getPresupuesto());
        
        for(Recomendacion recomendacion : prototipo.getRecomendaciones()){
            RecomendacionesType item = new RecomendacionesType();
            
            item.setCodigoPrototipo(recomendacion.getCodigoPrototipo());
            item.setObservacion(recomendacion.getObservacion() != null ? recomendacion.getObservacion() : "");
            rq.getRecomendaciones().getListaRecomendaciones().add(item);
        }
        
        rq.setTipo(prototipo.getTipo().getLlave());
        rq.setTitulo(prototipo.getTitulo());
        
        //2. llamar a la operación
        co.edu.javeriana.proxies.insertarprototipo.types.ResponseType rs = getPortInsertarPrototipo().process(rq);
        
        //3. construir la salida
        response = rs.getEjecucion();
    }
    
    public static void insertarColaborador(Colaborador colaborador, String response) {
        //1. contruir el request
        InsertarColaboradorType rq = new InsertarColaboradorType();
        
        //rq.setCodigoRol(colaborador.getCodigoRol());
        rq.setCorreoElectronica(colaborador.getEmail());
        rq.setDisponible(colaborador.getDisponible());
        rq.setPrimerApellido(colaborador.getPrimeroApellido());
        rq.setPrimerNombre(colaborador.getPrimerNombre());
        rq.setSegundoApellido(colaborador.getSegundoApellido());
        rq.setSegundoNombre(colaborador.getSegundoNombre());
        rq.setTelefono(colaborador.getTelefono());
        
        //2. llamar a la operación
        co.edu.javeriana.proxies.insertarcolaborador.types.ResponseType rs = getPortInsertarColaborador().process(rq);
        
        //3. construir la salida
        response = rs.getEjecucion();
    }
    
    public static void consultarPrototipo(BigDecimal codigoPrototipo, Prototipo prototipo) {
        //1. contruir el request
        co.edu.javeriana.proxies.consultarprototipo.types.InputType rq = new co.edu.javeriana.proxies.consultarprototipo.types.InputType(); 
        rq.setCodigoPrototipo(codigoPrototipo);
        
        //2. llamar a la operación
        PrototipoType rs = getPortConsultarPrototipo().process(rq);
        
        //3. construir la salida   
        prototipo.setCodigo(rs.getCodigoPrototipo());
        prototipo.setConocimiento(rs.getConocimientos());
        prototipo.setDetalle(rs.getDetalle());
        prototipo.setEstado(rs.getEstado());
        prototipo.setFechaFin(DateUtils.xmlGregorianCalendarToDate(rs.getFechaCierre()));
        prototipo.setFechaInicio(DateUtils.xmlGregorianCalendarToDate(rs.getFechaInicio()));
        prototipo.setPresupuesto(rs.getPresupuesto());
        prototipo.getTipo().setLlave(rs.getTipo());
        prototipo.getTipo().setValor(rs.getTipo());
        prototipo.setTitulo(rs.getTitulo());
        
    }
    
    public static void consultarDocumento(BigDecimal codigoCandidato, String documento) {
        //1. contruir el request
        co.edu.javeriana.proxies.consultardocumento.types.InputType rq = new co.edu.javeriana.proxies.consultardocumento.types.InputType(); 
        rq.setCodigoCandidato(codigoCandidato);
        
        //2. llamar a la operación
        OutputType rs = getPortConsultarDocumento().process(rq);
        
        //3. construir la salida
        documento = rs.getCodigoDocumento();
    }
}
