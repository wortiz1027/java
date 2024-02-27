package co.edu.javeriana.configuracion.load;

import co.edu.javeriana.configuracion.conf.Configuracion;

import java.io.File;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import org.xml.sax.SAXException;

public class LeerXMLDom {
    public LeerXMLDom() {
        super();
    }
    public Configuracion cargarConfiguracion(File fila){
        Configuracion conf=null;
        try {
            conf= new Configuracion();
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder;
            dBuilder = dbFactory.newDocumentBuilder();
       
            Document doc = dBuilder.parse(fila);
            doc.getDocumentElement().normalize();
            /**
             * Se obtiene la configuracion del OSB
             * */
            
            NodeList nodes = doc.getElementsByTagName("osb");
            Node node = nodes.item(0);
            Element element = (Element) node;
            
            conf.getOsb().setHost(this.getValue("host", element));
            conf.getOsb().setPort(this.getValue("port", element));
            conf.getOsb().setProtocol(this.getValue("protocol", element));
            
            /**
             * Se obtiene si se trabaja en modo desarrollo o nop
             */
            
            nodes = doc.getElementsByTagName("desarrollo");
            node = nodes.item(0).getChildNodes().item(0);
            conf.setDesarrollo(Boolean.parseBoolean(node.getNodeValue())); 
            
            /**
             * Se obtiene la configuracion del BPM
             * */
            nodes = doc.getElementsByTagName("bpm");
            node = nodes.item(0);
            element = (Element) node;
            
            conf.getBpm().setHost(this.getValue("host", element));
            conf.getBpm().setPort(this.getValue("port", element));
            conf.getBpm().setProtocol(this.getValue("protocol", element));
            
            /**
             * Se obtiene la configuracion del WCC
             * */
            nodes = doc.getElementsByTagName("wcc");
            node = nodes.item(0);
            element = (Element) node;
            
            conf.getWcc().setHost(this.getValue("host", element));
            conf.getWcc().setPort(this.getValue("port", element));
            conf.getWcc().setProtocol(this.getValue("protocol", element));
            
            
            /**
             * Se obtiene la configuracion del WCC
             * */
            nodes = doc.getElementsByTagName("visor-wcc");
            node = nodes.item(0);
            element = (Element) node;
            
            conf.getVisorWcc().setHost(this.getValue("host", element));
            conf.getVisorWcc().setPort(this.getValue("port", element));
            conf.getVisorWcc().setProtocol(this.getValue("protocol", element));
            
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        return conf;
    }
    private String getValue(final String tag, final Element element) {
        try{
            final NodeList nodes = element.getElementsByTagName(tag).item(0).getChildNodes();
            final Node node = nodes.item(0);
            return node.getNodeValue();
        }catch(NullPointerException e){
            return "";
        }
    }
}
