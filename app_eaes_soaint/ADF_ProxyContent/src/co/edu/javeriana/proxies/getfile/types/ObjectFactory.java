
package co.edu.javeriana.proxies.getfile.types;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the co.edu.javeriana.proxies.getfile.types package.
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
        new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0", "input");
    private final static QName _Output_QNAME =
        new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0", "output");
    private final static QName _GetFileByIDResultArchivoDescargado_QNAME =
        new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0", "ArchivoDescargado");
    private final static QName _GetFileByIDResultStatus_QNAME =
        new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0", "status");
    private final static QName _StatusInfoCodigo_QNAME =
        new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0", "codigo");
    private final static QName _StatusInfoMensaje_QNAME =
        new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0", "mensaje");
    private final static QName _PrimaryFileNombreArchivo_QNAME =
        new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0", "nombreArchivo");
    private final static QName _PrimaryFileContenidoArchivo_QNAME =
        new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0", "contenidoArchivo");
    private final static QName _FileInfoDID_QNAME =
        new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0", "dID");
    private final static QName _FileInfoDDocName_QNAME =
        new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0", "dDocName");
    private final static QName _FileInfoTitulo_QNAME =
        new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0", "titulo");
    private final static QName _FileInfoTipo_QNAME =
        new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0", "tipo");
    private final static QName _FileInfoAutor_QNAME =
        new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0", "autor");
    private final static QName _FileInfoGrupoSeguridad_QNAME =
        new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0", "grupoSeguridad");
    private final static QName _PropertyName_QNAME =
        new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0", "name");
    private final static QName _PropertyValue_QNAME =
        new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0", "value");
    private final static QName _GetFileByIDResponseGetFileByIDResult_QNAME =
        new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0", "GetFileByIDResult");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: co.edu.javeriana.proxies.getfile.types
     *
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetFileByID }
     *
     */
    public GetFileByID createGetFileByID() {
        return new GetFileByID();
    }

    /**
     * Create an instance of {@link GetFileByIDResponse }
     *
     */
    public GetFileByIDResponse createGetFileByIDResponse() {
        return new GetFileByIDResponse();
    }

    /**
     * Create an instance of {@link Property }
     *
     */
    public Property createProperty() {
        return new Property();
    }

    /**
     * Create an instance of {@link FileInfo }
     *
     */
    public FileInfo createFileInfo() {
        return new FileInfo();
    }

    /**
     * Create an instance of {@link PrimaryFile }
     *
     */
    public PrimaryFile createPrimaryFile() {
        return new PrimaryFile();
    }

    /**
     * Create an instance of {@link StatusInfo }
     *
     */
    public StatusInfo createStatusInfo() {
        return new StatusInfo();
    }

    /**
     * Create an instance of {@link GetFileByIDResult }
     *
     */
    public GetFileByIDResult createGetFileByIDResult() {
        return new GetFileByIDResult();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFileByID }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetFileByID }{@code >}
     */
    @XmlElementDecl(namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0", name = "input")
    public JAXBElement<GetFileByID> createInput(GetFileByID value) {
        return new JAXBElement<GetFileByID>(_Input_QNAME, GetFileByID.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFileByIDResponse }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetFileByIDResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0",
                    name = "output")
    public JAXBElement<GetFileByIDResponse> createOutput(GetFileByIDResponse value) {
        return new JAXBElement<GetFileByIDResponse>(_Output_QNAME, GetFileByIDResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrimaryFile }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PrimaryFile }{@code >}
     */
    @XmlElementDecl(namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0",
                    name = "ArchivoDescargado", scope = GetFileByIDResult.class)
    public JAXBElement<PrimaryFile> createGetFileByIDResultArchivoDescargado(PrimaryFile value) {
        return new JAXBElement<PrimaryFile>(_GetFileByIDResultArchivoDescargado_QNAME, PrimaryFile.class,
                                            GetFileByIDResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StatusInfo }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link StatusInfo }{@code >}
     */
    @XmlElementDecl(namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0",
                    name = "status", scope = GetFileByIDResult.class)
    public JAXBElement<StatusInfo> createGetFileByIDResultStatus(StatusInfo value) {
        return new JAXBElement<StatusInfo>(_GetFileByIDResultStatus_QNAME, StatusInfo.class, GetFileByIDResult.class,
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
    @XmlElementDecl(namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0",
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
    @XmlElementDecl(namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0",
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
    @XmlElementDecl(namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0",
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
    @XmlElementDecl(namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0",
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
    @XmlElementDecl(namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0", name = "dID",
                    scope = FileInfo.class)
    public JAXBElement<Integer> createFileInfoDID(Integer value) {
        return new JAXBElement<Integer>(_FileInfoDID_QNAME, Integer.class, FileInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0",
                    name = "dDocName", scope = FileInfo.class)
    public JAXBElement<String> createFileInfoDDocName(String value) {
        return new JAXBElement<String>(_FileInfoDDocName_QNAME, String.class, FileInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0",
                    name = "titulo", scope = FileInfo.class)
    public JAXBElement<String> createFileInfoTitulo(String value) {
        return new JAXBElement<String>(_FileInfoTitulo_QNAME, String.class, FileInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0", name = "tipo",
                    scope = FileInfo.class)
    public JAXBElement<String> createFileInfoTipo(String value) {
        return new JAXBElement<String>(_FileInfoTipo_QNAME, String.class, FileInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0", name = "autor",
                    scope = FileInfo.class)
    public JAXBElement<String> createFileInfoAutor(String value) {
        return new JAXBElement<String>(_FileInfoAutor_QNAME, String.class, FileInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0",
                    name = "grupoSeguridad", scope = FileInfo.class)
    public JAXBElement<String> createFileInfoGrupoSeguridad(String value) {
        return new JAXBElement<String>(_FileInfoGrupoSeguridad_QNAME, String.class, FileInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0", name = "name",
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
    @XmlElementDecl(namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0", name = "value",
                    scope = Property.class)
    public JAXBElement<String> createPropertyValue(String value) {
        return new JAXBElement<String>(_PropertyValue_QNAME, String.class, Property.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFileByIDResult }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetFileByIDResult }{@code >}
     */
    @XmlElementDecl(namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0",
                    name = "GetFileByIDResult", scope = GetFileByIDResponse.class)
    public JAXBElement<GetFileByIDResult> createGetFileByIDResponseGetFileByIDResult(GetFileByIDResult value) {
        return new JAXBElement<GetFileByIDResult>(_GetFileByIDResponseGetFileByIDResult_QNAME, GetFileByIDResult.class,
                                                  GetFileByIDResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     */
    @XmlElementDecl(namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_GetFile/v1.0", name = "dID",
                    scope = GetFileByID.class)
    public JAXBElement<Integer> createGetFileByIDDID(Integer value) {
        return new JAXBElement<Integer>(_FileInfoDID_QNAME, Integer.class, GetFileByID.class, value);
    }

}
