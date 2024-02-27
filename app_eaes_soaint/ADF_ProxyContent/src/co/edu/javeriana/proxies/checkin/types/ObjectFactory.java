
package co.edu.javeriana.proxies.checkin.types;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the co.edu.javeriana.proxies.checkin.types package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 *
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Input_QNAME =
        new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Checkin/v1.0", "input");
    private final static QName _Output_QNAME =
        new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Checkin/v1.0", "output");
    private final static QName _StatusInfoCodigo_QNAME =
        new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Checkin/v1.0", "codigo");
    private final static QName _StatusInfoMensaje_QNAME =
        new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Checkin/v1.0", "mensaje");
    private final static QName _PropertyName_QNAME =
        new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Checkin/v1.0", "name");
    private final static QName _PropertyValue_QNAME =
        new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Checkin/v1.0", "value");
    private final static QName _PrimaryFileNombreArchivo_QNAME =
        new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Checkin/v1.0", "nombreArchivo");
    private final static QName _PrimaryFileContenidoArchivo_QNAME =
        new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Checkin/v1.0", "contenidoArchivo");
    private final static QName _CheckInUniversalResultDID_QNAME =
        new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Checkin/v1.0", "dID");
    private final static QName _CheckInUniversalResultRevision_QNAME =
        new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Checkin/v1.0", "revision");
    private final static QName _CheckInUniversalResultIdRevision_QNAME =
        new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Checkin/v1.0", "idRevision");
    private final static QName _CheckInUniversalResultLabelrevision_QNAME =
        new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Checkin/v1.0", "labelrevision");
    private final static QName _CheckInUniversalResultStatus_QNAME =
        new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Checkin/v1.0", "status");
    private final static QName _CheckInUniversalDDocName_QNAME =
        new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Checkin/v1.0", "dDocName");
    private final static QName _CheckInUniversalTitulo_QNAME =
        new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Checkin/v1.0", "titulo");
    private final static QName _CheckInUniversalTipo_QNAME =
        new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Checkin/v1.0", "tipo");
    private final static QName _CheckInUniversalAutor_QNAME =
        new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Checkin/v1.0", "autor");
    private final static QName _CheckInUniversalGrupoSeguridad_QNAME =
        new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Checkin/v1.0", "grupoSeguridad");
    private final static QName _CheckInUniversalCuenta_QNAME =
        new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Checkin/v1.0", "cuenta");
    private final static QName _CheckInUniversalArchivoPrimario_QNAME =
        new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Checkin/v1.0", "archivoPrimario");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: co.edu.javeriana.proxies.checkin.types
     *
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CheckInUniversal }
     *
     */
    public CheckInUniversal createCheckInUniversal() {
        return new CheckInUniversal();
    }

    /**
     * Create an instance of {@link CheckInUniversalResult }
     *
     */
    public CheckInUniversalResult createCheckInUniversalResult() {
        return new CheckInUniversalResult();
    }

    /**
     * Create an instance of {@link PrimaryFile }
     *
     */
    public PrimaryFile createPrimaryFile() {
        return new PrimaryFile();
    }

    /**
     * Create an instance of {@link Property }
     *
     */
    public Property createProperty() {
        return new Property();
    }

    /**
     * Create an instance of {@link StatusInfo }
     *
     */
    public StatusInfo createStatusInfo() {
        return new StatusInfo();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckInUniversal }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CheckInUniversal }{@code >}
     */
    @XmlElementDecl(namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Checkin/v1.0", name = "input")
    public JAXBElement<CheckInUniversal> createInput(CheckInUniversal value) {
        return new JAXBElement<CheckInUniversal>(_Input_QNAME, CheckInUniversal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckInUniversalResult }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CheckInUniversalResult }{@code >}
     */
    @XmlElementDecl(namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Checkin/v1.0",
                    name = "output")
    public JAXBElement<CheckInUniversalResult> createOutput(CheckInUniversalResult value) {
        return new JAXBElement<CheckInUniversalResult>(_Output_QNAME, CheckInUniversalResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     */
    @XmlElementDecl(namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Checkin/v1.0",
                    name = "codigo", scope = StatusInfo.class)
    public JAXBElement<Integer> createStatusInfoCodigo(Integer value) {
        return new JAXBElement<Integer>(_StatusInfoCodigo_QNAME, Integer.class, StatusInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Checkin/v1.0",
                    name = "mensaje", scope = StatusInfo.class)
    public JAXBElement<String> createStatusInfoMensaje(String value) {
        return new JAXBElement<String>(_StatusInfoMensaje_QNAME, String.class, StatusInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Checkin/v1.0", name = "name",
                    scope = Property.class)
    public JAXBElement<String> createPropertyName(String value) {
        return new JAXBElement<String>(_PropertyName_QNAME, String.class, Property.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Checkin/v1.0", name = "value",
                    scope = Property.class)
    public JAXBElement<String> createPropertyValue(String value) {
        return new JAXBElement<String>(_PropertyValue_QNAME, String.class, Property.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Checkin/v1.0",
                    name = "nombreArchivo", scope = PrimaryFile.class)
    public JAXBElement<String> createPrimaryFileNombreArchivo(String value) {
        return new JAXBElement<String>(_PrimaryFileNombreArchivo_QNAME, String.class, PrimaryFile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     */
    @XmlElementDecl(namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Checkin/v1.0",
                    name = "contenidoArchivo", scope = PrimaryFile.class)
    public JAXBElement<byte[]> createPrimaryFileContenidoArchivo(byte[] value) {
        return new JAXBElement<byte[]>(_PrimaryFileContenidoArchivo_QNAME, byte[].class, PrimaryFile.class,
                                       ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     */
    @XmlElementDecl(namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Checkin/v1.0", name = "dID",
                    scope = CheckInUniversalResult.class)
    public JAXBElement<Integer> createCheckInUniversalResultDID(Integer value) {
        return new JAXBElement<Integer>(_CheckInUniversalResultDID_QNAME, Integer.class, CheckInUniversalResult.class,
                                        value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     */
    @XmlElementDecl(namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Checkin/v1.0",
                    name = "revision", scope = CheckInUniversalResult.class)
    public JAXBElement<Integer> createCheckInUniversalResultRevision(Integer value) {
        return new JAXBElement<Integer>(_CheckInUniversalResultRevision_QNAME, Integer.class,
                                        CheckInUniversalResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     */
    @XmlElementDecl(namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Checkin/v1.0",
                    name = "idRevision", scope = CheckInUniversalResult.class)
    public JAXBElement<Integer> createCheckInUniversalResultIdRevision(Integer value) {
        return new JAXBElement<Integer>(_CheckInUniversalResultIdRevision_QNAME, Integer.class,
                                        CheckInUniversalResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Checkin/v1.0",
                    name = "labelrevision", scope = CheckInUniversalResult.class)
    public JAXBElement<String> createCheckInUniversalResultLabelrevision(String value) {
        return new JAXBElement<String>(_CheckInUniversalResultLabelrevision_QNAME, String.class,
                                       CheckInUniversalResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StatusInfo }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link StatusInfo }{@code >}
     */
    @XmlElementDecl(namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Checkin/v1.0",
                    name = "status", scope = CheckInUniversalResult.class)
    public JAXBElement<StatusInfo> createCheckInUniversalResultStatus(StatusInfo value) {
        return new JAXBElement<StatusInfo>(_CheckInUniversalResultStatus_QNAME, StatusInfo.class,
                                           CheckInUniversalResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Checkin/v1.0",
                    name = "dDocName", scope = CheckInUniversal.class)
    public JAXBElement<String> createCheckInUniversalDDocName(String value) {
        return new JAXBElement<String>(_CheckInUniversalDDocName_QNAME, String.class, CheckInUniversal.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Checkin/v1.0",
                    name = "titulo", scope = CheckInUniversal.class)
    public JAXBElement<String> createCheckInUniversalTitulo(String value) {
        return new JAXBElement<String>(_CheckInUniversalTitulo_QNAME, String.class, CheckInUniversal.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Checkin/v1.0", name = "tipo",
                    scope = CheckInUniversal.class)
    public JAXBElement<String> createCheckInUniversalTipo(String value) {
        return new JAXBElement<String>(_CheckInUniversalTipo_QNAME, String.class, CheckInUniversal.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Checkin/v1.0", name = "autor",
                    scope = CheckInUniversal.class)
    public JAXBElement<String> createCheckInUniversalAutor(String value) {
        return new JAXBElement<String>(_CheckInUniversalAutor_QNAME, String.class, CheckInUniversal.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Checkin/v1.0",
                    name = "grupoSeguridad", scope = CheckInUniversal.class)
    public JAXBElement<String> createCheckInUniversalGrupoSeguridad(String value) {
        return new JAXBElement<String>(_CheckInUniversalGrupoSeguridad_QNAME, String.class, CheckInUniversal.class,
                                       value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Checkin/v1.0",
                    name = "cuenta", scope = CheckInUniversal.class)
    public JAXBElement<String> createCheckInUniversalCuenta(String value) {
        return new JAXBElement<String>(_CheckInUniversalCuenta_QNAME, String.class, CheckInUniversal.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrimaryFile }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PrimaryFile }{@code >}
     */
    @XmlElementDecl(namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Checkin/v1.0",
                    name = "archivoPrimario", scope = CheckInUniversal.class)
    public JAXBElement<PrimaryFile> createCheckInUniversalArchivoPrimario(PrimaryFile value) {
        return new JAXBElement<PrimaryFile>(_CheckInUniversalArchivoPrimario_QNAME, PrimaryFile.class,
                                            CheckInUniversal.class, value);
    }

}
