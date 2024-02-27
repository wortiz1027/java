package co.edu.javeriana.facade;

import co.edu.javeriana.wcc.CheckinResult;
import co.edu.javeriana.wcc.Documento;
import co.edu.javeriana.wcc.NameValue;

import co.edu.javeriana.facade.FacadeContent;

import co.edu.javeriana.wcc.GetFileResult;

import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class Pruebas {
            
    public static void main(String x[]) throws FileNotFoundException, IOException {
        java.io.File file = new java.io.File("C:\\Users\\javeriana\\Documents\\prueba_06042020.pdf");
        FileInputStream fis = new FileInputStream(file);

        // int byteLength = fff.length(); 

        // In android the result of file.length() is long
        long byteLength = file.length(); // byte count of the file-content

        byte[] content = new byte[(int) byteLength];
        fis.read(content, 0, (int) byteLength);
        
        Documento documento = new Documento();
        
        documento.setDID(1);
        documento.setRevision("");
        documento.setDDocName("");
        documento.setTipo("Document");
        documento.setTitulo("Carga desde clase java");
        documento.setAutor("weblogic");
        documento.setGrupoSeguridad("Public");
        documento.setCuenta("");
        documento.setExtension("");
        documento.setFechaCreacion("");
        documento.setFormato("");
        documento.setUrl("");
        
        NameValue metadata1 = new NameValue();
        metadata1.setName("xNumeroID");
        metadata1.setValue("951235789");
        
        NameValue metadata2 = new NameValue();
        metadata2.setName("xTelefono");
        metadata2.setValue("3109876542");
        
        NameValue metadata3 = new NameValue();
        metadata3.setName("xFolderID");
        metadata3.setValue("SOAint-123456");
        
        documento.getCustomDocMetaData().add(metadata1);
        documento.getCustomDocMetaData().add(metadata2);
        
        documento.getArchivoPrimario().setNombreArchivo("prueba_06042020.pdf");
        documento.getArchivoPrimario().setContenidoArchivo(content);
        
        CheckinResult response = new CheckinResult();
        
        FacadeContent.checkIn(documento, response);
        
        System.out.println("Id         : " + response.getDID());
        System.out.println("IdRevision : " + response.getIdRevision());
        System.out.println("Revision   : " + response.getRevision());
        System.out.println("Label      : " + response.getLabelrevision());
        System.out.println("Codigo     : " + response.getStatus().getCodigo());
        System.out.println("Mensaje    : " + response.getStatus().getMensaje()); 
        
        // Prueba busqueda avanzada
        System.out.println("----------------------------------------------");
        List<Documento> documentos = new ArrayList<>();
        
        FacadeContent.busquedaAvanzada("dDocType <matches> `Document`", documentos);
        
         documentos.forEach(tmp -> {
            System.out.println("dID       :: " + tmp.getDID());
            System.out.println("Autor     :: " + tmp.getAutor());
            System.out.println("Cuenta    :: " + tmp.getCuenta());
            System.out.println("Fecha     :: " + tmp.getFechaCreacion());
            System.out.println("docName   :: " + tmp.getDDocName());
            System.out.println("Extension :: " + tmp.getExtension());
            System.out.println("Formato   :: " + tmp.getFormato());
            System.out.println("Revision  :: " + tmp.getRevision());
            System.out.println("Nombre    :: " + tmp.getNombreOriginal());
            System.out.println("Url       :: " + tmp.getUrl());
            
            for (NameValue nv : tmp.getCustomDocMetaData()) {
                System.out.println("\t Name  :: " + nv.getName());
                System.out.println("\t Value :: " + nv.getValue());
            }
        });
        
        // Consultar archivo
        System.out.println("----------------------------------------------");
        co.edu.javeriana.wcc.File file1 = new co.edu.javeriana.wcc.File();
        file1.setDID(401);
        file1.setTipoArchivo("Primary");
        
        GetFileResult archivo = new GetFileResult();        
        
        FacadeContent.obtenerArchivo(file1, archivo);
        
        System.out.println(archivo.getInformacionArhivo().getDID());
        System.out.println(archivo.getInformacionArhivo().getDDocName());
        System.out.println(archivo.getInformacionArhivo().getTitulo());
        System.out.println(archivo.getInformacionArhivo().getTipo());
        System.out.println(archivo.getInformacionArhivo().getAutor());
        System.out.println(archivo.getInformacionArhivo().getGrupoSeguridad());
    }
    
}
