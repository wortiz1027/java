package co.edu.javeriana.facade;

import co.edu.javeriana.proxies.advancesearch.proxy.BpelAdvanceSearch;
import co.edu.javeriana.proxies.advancesearch.proxy.BpelAdvancesearchClientEp;
import co.edu.javeriana.proxies.advancesearch.types.AdvancedSearch;
import co.edu.javeriana.proxies.advancesearch.types.AdvancedSearchResult;
import co.edu.javeriana.proxies.advancesearch.types.SearchResponse;
import co.edu.javeriana.proxies.checkin.proxy.BpelCheckinWcc;
import co.edu.javeriana.proxies.checkin.proxy.BpelCheckinWccClientEp;
import co.edu.javeriana.proxies.checkin.types.CheckInUniversal;
import co.edu.javeriana.proxies.checkin.types.CheckInUniversalResult;
import co.edu.javeriana.proxies.checkin.types.PrimaryFile;
import co.edu.javeriana.proxies.getfile.proxy.BpelGetFile;
import co.edu.javeriana.proxies.getfile.proxy.BpelGetfileClientEp;

import co.edu.javeriana.proxies.getfile.types.GetFileByID;
import co.edu.javeriana.proxies.getfile.types.GetFileByIDResponse;
import co.edu.javeriana.proxies.getfile.types.FileInfo;
import co.edu.javeriana.proxies.advancesearch.types.Property;
import co.edu.javeriana.wcc.CheckinResult;
import co.edu.javeriana.wcc.Documento;
import co.edu.javeriana.wcc.File;
import co.edu.javeriana.wcc.GetFileResult;
import co.edu.javeriana.wcc.NameValue;

import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.ws.BindingProvider;
import javax.xml.namespace.QName;

public class FacadeContent {
    
    private static final String WSDL_GET_FILE       = "http://bpm-dv1:7003/soa-infra/services/default/SOA_Content/bpel_getfile_client_ep?WSDL";
    private static final String WSDL_ADVANCE_SEARCH = "http://bpm-dv1:7003/soa-infra/services/default/SOA_Content/bpel_advancesearch_client_ep?WSDL";
    private static final String WSDL_CHECKIN        = "http://bpm-dv1:7003/soa-infra/services/default/SOA_Content/bpel_checkin_wcc_client_ep?WSDL";
    
    private static BpelGetfileClientEp service1;
    private static BpelGetFile port1;
    
    private static BpelAdvancesearchClientEp service2;
    private static BpelAdvanceSearch port2;
    
    private static BpelCheckinWccClientEp service3;
    private static BpelCheckinWcc port3;
    
    public FacadeContent() {
    }
    
    public static BpelGetfileClientEp getServiceGetFile() {
        if (service1 == null) {
            service1 = new BpelGetfileClientEp();
        }
        
        return service1;
    }
    
    public static BpelGetFile getPortGetFile() {
        try {
            if (port1 == null) {
                port1 = getServiceGetFile().getBpelGetFilePt();
                ((BindingProvider) port1).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, WSDL_GET_FILE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return port1;
    }
    
    public static BpelAdvancesearchClientEp getServiceAdvanceSearch() {
        if (service2 == null) {
            service2 = new BpelAdvancesearchClientEp();
        }
        
        return service2;
    }
    
    public static BpelAdvanceSearch getPortAdvanceSearch() {
        try {
            if (port2 == null) {
                port2 = getServiceAdvanceSearch().getBpelAdvanceSearchPt();
                ((BindingProvider) port2).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, WSDL_ADVANCE_SEARCH);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return port2;
    }
    
    public static BpelCheckinWccClientEp getServiceCheckIn() {
        if (service3 == null) {
            service3 = new BpelCheckinWccClientEp();
        }
        
        return service3;
    }
    
    public static BpelCheckinWcc getPortCheckIn() {
        try {
            if (port3 == null) {
                port3 = getServiceCheckIn().getBpelCheckinWccPt();
                ((BindingProvider) port3).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, WSDL_CHECKIN);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return port3;
    }
    
    @SuppressWarnings("unchecked")    
    public static void obtenerArchivo(File file, GetFileResult archivo) {
        //1. contruir el request
        GetFileByID rq = new GetFileByID();

        JAXBElement<Integer> did = new JAXBElement(new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0", "dID"), Integer.class, file.getDID());
        
        rq.setDID(did);
        rq.setTipoArchivo(file.getTipoArchivo());
        
        //2. llamar a la operación
        GetFileByIDResponse rs = getPortGetFile().process(rq);
        
        //3. construir la salida    
        //archivo.setArchivoDescargado(rs.getGetFileByIDResult().getValue().getArchivoDescargado());
        archivo.getArchivoDescargado().setContenidoArchivo(rs.getGetFileByIDResult().getValue().getArchivoDescargado().getValue().getContenidoArchivo().getValue());
        archivo.getArchivoDescargado().setNombreArchivo(rs.getGetFileByIDResult().getValue().getArchivoDescargado().getValue().getNombreArchivo().getValue());
        
        //Informacion Archivo
        for(FileInfo documentos : rs.getGetFileByIDResult().getValue().getInformacionArhivo()){

            archivo.getInformacionArhivo().setDID(documentos.getDID().getValue());
            archivo.getInformacionArhivo().setDDocName(documentos.getDDocName().getValue());
            archivo.getInformacionArhivo().setTitulo(documentos.getTitulo().getValue());
            archivo.getInformacionArhivo().setTipo(documentos.getTipo().getValue());
            archivo.getInformacionArhivo().setAutor(documentos.getAutor().getValue());
            archivo.getInformacionArhivo().setGrupoSeguridad(documentos.getGrupoSeguridad().getValue());
            
            break;    
        }        
        
        //Status
        archivo.getStatus().setCodigo(rs.getGetFileByIDResult().getValue().getStatus().getValue().getCodigo().getValue());
        archivo.getStatus().setMensaje(rs.getGetFileByIDResult().getValue().getStatus().getValue().getMensaje().getValue());
    }
    
    @SuppressWarnings("unchecked")
    public static void busquedaAvanzada(String queryText, List<Documento> documentos) {
        //1. contruir el request
        AdvancedSearch rq = new AdvancedSearch(); 
        rq.setQueryText(queryText);
        
        //2. llamar a la operación
        SearchResponse rs = getPortAdvanceSearch().process(rq);
        
        int index = 0;
        //3. construir la salida
        for(AdvancedSearchResult asr : rs.getSearchResults()){
            Documento item = new Documento();
        
            for (JAXBElement element : asr.getInformacion().getContent()) {
                QName name = element.getName();
                
                if (name.getLocalPart().equalsIgnoreCase("dID")) {
                    JAXBElement<String> dID = new JAXBElement(new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0", "dID"), String.class, element.getValue());
                    item.setDID(Integer.parseInt(dID.getValue() != null || dID.getValue().toString().isEmpty() ? dID.getValue().toString() : "0"));
                }
                
                if (name.getLocalPart().equalsIgnoreCase("revision")) {
                    JAXBElement<String> revision = new JAXBElement(new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0", "revision"), String.class, element.getValue());                    
                    item.setRevision(revision.getValue().toString());
                }
                
                if (name.getLocalPart().equalsIgnoreCase("dDocName")) {
                    JAXBElement<String> dDocName = new JAXBElement(new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0", "dDocName"), String.class, element.getValue());
                    item.setDDocName(dDocName.getValue().toString());
                }
                
                if (name.getLocalPart().equalsIgnoreCase("titulo")) {
                    JAXBElement<String> titulo = new JAXBElement(new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0", "titulo"), String.class, element.getValue());
                    item.setTitulo(titulo.getValue().toString());
                }
                
                if (name.getLocalPart().equalsIgnoreCase("tipo")) {
                    JAXBElement<String> tipo = new JAXBElement(new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0", "tipo"), String.class, element.getValue());
                    item.setTipo(tipo.getValue());
                }
                
                if (name.getLocalPart().equalsIgnoreCase("autor")) {
                    JAXBElement<String> autor = new JAXBElement(new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0", "titulo"), String.class, element.getValue());
                    item.setAutor(autor.getValue().toString());
                }
                
                if (name.getLocalPart().equalsIgnoreCase("grupoSeguridad")) {
                    JAXBElement<String> grupoSeguridad = new JAXBElement(new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0", "grupoSeguridad"), String.class, element.getValue());
                    item.setGrupoSeguridad(grupoSeguridad.getValue().toString());
                }
                
                if (name.getLocalPart().equalsIgnoreCase("cuenta")) {
                    JAXBElement<String> cuenta = new JAXBElement(new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0", "cuenta"), String.class, element.getValue());
                    item.setCuenta(cuenta.getValue().toString());
                }
                
                if (name.getLocalPart().equalsIgnoreCase("extension")) {
                    JAXBElement<String> extension = new JAXBElement(new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0", "extension"), String.class, element.getValue());
                    item.setExtension(extension.getValue().toString());
                }
                
                if (name.getLocalPart().equalsIgnoreCase("extensionWeb")) {
                    JAXBElement<String> extensionWeb = new JAXBElement(new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0", "extensionWeb"), String.class, element.getValue());
                    item.setExtensionWeb(extensionWeb.getValue().toString());
                }
                
                if (name.getLocalPart().equalsIgnoreCase("fechaCreacion")) {
                    JAXBElement<String> fechaCreacion = new JAXBElement(new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0", "fechaCreacion"), String.class, element.getValue());
                    item.setFechaCreacion(fechaCreacion.getValue().toString());
                }
                
                if (name.getLocalPart().equalsIgnoreCase("formato")) {
                    JAXBElement<String> formato = new JAXBElement(new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0", "formato"), String.class, element.getValue());
                    item.setFormato(formato.getValue().toString());
                }
                
                if (name.getLocalPart().equalsIgnoreCase("nombreOriginal")) {
                    JAXBElement<String> nombreOriginal = new JAXBElement(new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0", "url"), String.class, element.getValue());
                    item.setNombreOriginal(nombreOriginal.getValue().toString());
                }
                
                if (name.getLocalPart().equalsIgnoreCase("url")) {
                    JAXBElement<String> url = new JAXBElement(new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0", "url"), String.class, element.getValue());
                    item.setUrl(url.getValue().toString());
                }
            }
            
            for (Property tmp : asr.getCustomDocMetaData().getPropiedades()) {
                 JAXBElement<String> nombre = new JAXBElement(new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0", "name"), String.class, tmp.getName());
                 JAXBElement<String> valor = new JAXBElement(new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0", "value"), String.class, tmp.getValue());
                
                 NameValue propiedad = new NameValue();
                 propiedad.setName(nombre.getValue().toString());
                 propiedad.setValue(valor.getValue().toString());
                
                 item.getCustomDocMetaData().add(propiedad);
            }
            
            documentos.add(item);
        } 
    }
    
    @SuppressWarnings("unchecked")
    public static void checkIn(Documento documento, CheckinResult response) {
        //1. contruir el request
        CheckInUniversal rq = new CheckInUniversal(); 
        
        JAXBElement<String> autor     = new JAXBElement(new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0", "autor"), String.class, documento.getAutor());
        JAXBElement<String> cuenta    = new JAXBElement(new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0", "cuenta"), String.class, documento.getCuenta());
        JAXBElement<String> dDocName  = new JAXBElement(new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0", "dDocName"), String.class, documento.getDDocName());
        JAXBElement<String> seguridad = new JAXBElement(new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Checkin/v1.0", "grupoSeguridad"), String.class, documento.getGrupoSeguridad());
        JAXBElement<String> tipo      = new JAXBElement(new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Checkin/v1.0", "tipo"), String.class, documento.getTipo());
        JAXBElement<String> titulo    = new JAXBElement(new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Checkin/v1.0", "titulo"), String.class, documento.getTitulo());
        
        JAXBElement<String> nombre    = new JAXBElement(new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Checkin/v1.0", "nombreArchivo"), String.class, documento.getArchivoPrimario().getNombreArchivo());
        JAXBElement<byte[]> contenido = new JAXBElement(new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Checkin/v1.0", "contenidoArchivo"), byte[].class, documento.getArchivoPrimario().getContenidoArchivo());
        
        PrimaryFile primary = new PrimaryFile();
        primary.setNombreArchivo(nombre);
        primary.setContenidoArchivo(contenido);
        
        JAXBElement<PrimaryFile> archivo   = new JAXBElement(new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Checkin/v1.0", "archivoPrimario"), PrimaryFile.class, primary);
        
        rq.setAutor(autor);
        rq.setCuenta(cuenta);
        rq.setDDocName(dDocName);
        rq.setGrupoSeguridad(seguridad);
        rq.setTipo(tipo);
        rq.setTitulo(titulo);
        rq.setArchivoPrimario(archivo);
        rq.getArchivoPrimario().getValue().setNombreArchivo(nombre);
        rq.getArchivoPrimario().getValue().setContenidoArchivo(contenido);
        
        for(NameValue propiedades : documento.getCustomDocMetaData()){
            co.edu.javeriana.proxies.checkin.types.Property item = new co.edu.javeriana.proxies.checkin.types.Property();
            
            JAXBElement<String> llave = new JAXBElement(new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Checkin/v1.0", "name"), String.class, propiedades.getName());
            JAXBElement<String> valor = new JAXBElement(new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Checkin/v1.0", "value"), String.class, propiedades.getValue());
            
            item.setName(llave);
            item.setValue(valor);
            
            rq.getCustomDocMetaData().add(item);
        }
        
        //2. llamar a la operación
        CheckInUniversalResult rs = getPortCheckIn().process(rq);
        
        //3. construir la salida    
        response.setDID(rs.getDID().getValue());
        response.setIdRevision(rs.getIdRevision().getValue());
        response.setLabelrevision(rs.getLabelrevision().getValue());
        response.setRevision(rs.getRevision().getValue());
        response.getStatus().setCodigo(rs.getStatus().getValue().getCodigo().getValue());
        response.getStatus().setMensaje(rs.getStatus().getValue().getMensaje().getValue());
        
    }
}
