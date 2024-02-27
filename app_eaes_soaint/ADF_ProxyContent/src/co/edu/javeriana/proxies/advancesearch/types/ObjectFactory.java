
package co.edu.javeriana.proxies.advancesearch.types;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the co.edu.javeriana.proxies.advancesearch.types package.
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
        new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Search/v1.0", "input");
    private final static QName _Output_QNAME =
        new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Search/v1.0", "output");
    private final static QName _SearchDID_QNAME =
        new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Search/v1.0", "dID");
    private final static QName _SearchRevision_QNAME =
        new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Search/v1.0", "revision");
    private final static QName _SearchDDocName_QNAME =
        new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Search/v1.0", "dDocName");
    private final static QName _SearchTitulo_QNAME =
        new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Search/v1.0", "titulo");
    private final static QName _SearchTipo_QNAME =
        new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Search/v1.0", "tipo");
    private final static QName _SearchAutor_QNAME =
        new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Search/v1.0", "autor");
    private final static QName _SearchGrupoSeguridad_QNAME =
        new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Search/v1.0", "grupoSeguridad");
    private final static QName _SearchCuenta_QNAME =
        new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Search/v1.0", "cuenta");
    private final static QName _SearchExtension_QNAME =
        new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Search/v1.0", "extension");
    private final static QName _SearchExtensionWeb_QNAME =
        new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Search/v1.0", "extensionWeb");
    private final static QName _SearchFechaCreacion_QNAME =
        new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Search/v1.0", "fechaCreacion");
    private final static QName _SearchFormato_QNAME =
        new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Search/v1.0", "formato");
    private final static QName _SearchNombreOriginal_QNAME =
        new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Search/v1.0", "nombreOriginal");
    private final static QName _SearchUrl_QNAME =
        new QName("http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Search/v1.0", "url");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: co.edu.javeriana.proxies.advancesearch.types
     *
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AdvancedSearch }
     *
     */
    public AdvancedSearch createAdvancedSearch() {
        return new AdvancedSearch();
    }

    /**
     * Create an instance of {@link SearchResponse }
     *
     */
    public SearchResponse createSearchResponse() {
        return new SearchResponse();
    }

    /**
     * Create an instance of {@link Property }
     *
     */
    public Property createProperty() {
        return new Property();
    }

    /**
     * Create an instance of {@link ListaPropiedades }
     *
     */
    public ListaPropiedades createListaPropiedades() {
        return new ListaPropiedades();
    }

    /**
     * Create an instance of {@link Search }
     *
     */
    public Search createSearch() {
        return new Search();
    }

    /**
     * Create an instance of {@link AdvancedSearchResult }
     *
     */
    public AdvancedSearchResult createAdvancedSearchResult() {
        return new AdvancedSearchResult();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AdvancedSearch }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AdvancedSearch }{@code >}
     */
    @XmlElementDecl(namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Search/v1.0", name = "input")
    public JAXBElement<AdvancedSearch> createInput(AdvancedSearch value) {
        return new JAXBElement<AdvancedSearch>(_Input_QNAME, AdvancedSearch.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchResponse }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SearchResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Search/v1.0", name = "output")
    public JAXBElement<SearchResponse> createOutput(SearchResponse value) {
        return new JAXBElement<SearchResponse>(_Output_QNAME, SearchResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Search/v1.0", name = "dID",
                    scope = Search.class)
    public JAXBElement<String> createSearchDID(String value) {
        return new JAXBElement<String>(_SearchDID_QNAME, String.class, Search.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Search/v1.0",
                    name = "revision", scope = Search.class)
    public JAXBElement<String> createSearchRevision(String value) {
        return new JAXBElement<String>(_SearchRevision_QNAME, String.class, Search.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Search/v1.0",
                    name = "dDocName", scope = Search.class)
    public JAXBElement<String> createSearchDDocName(String value) {
        return new JAXBElement<String>(_SearchDDocName_QNAME, String.class, Search.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Search/v1.0", name = "titulo",
                    scope = Search.class)
    public JAXBElement<String> createSearchTitulo(String value) {
        return new JAXBElement<String>(_SearchTitulo_QNAME, String.class, Search.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Search/v1.0", name = "tipo",
                    scope = Search.class)
    public JAXBElement<String> createSearchTipo(String value) {
        return new JAXBElement<String>(_SearchTipo_QNAME, String.class, Search.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Search/v1.0", name = "autor",
                    scope = Search.class)
    public JAXBElement<String> createSearchAutor(String value) {
        return new JAXBElement<String>(_SearchAutor_QNAME, String.class, Search.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Search/v1.0",
                    name = "grupoSeguridad", scope = Search.class)
    public JAXBElement<String> createSearchGrupoSeguridad(String value) {
        return new JAXBElement<String>(_SearchGrupoSeguridad_QNAME, String.class, Search.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Search/v1.0", name = "cuenta",
                    scope = Search.class)
    public JAXBElement<String> createSearchCuenta(String value) {
        return new JAXBElement<String>(_SearchCuenta_QNAME, String.class, Search.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Search/v1.0",
                    name = "extension", scope = Search.class)
    public JAXBElement<String> createSearchExtension(String value) {
        return new JAXBElement<String>(_SearchExtension_QNAME, String.class, Search.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Search/v1.0",
                    name = "extensionWeb", scope = Search.class)
    public JAXBElement<String> createSearchExtensionWeb(String value) {
        return new JAXBElement<String>(_SearchExtensionWeb_QNAME, String.class, Search.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Search/v1.0",
                    name = "fechaCreacion", scope = Search.class)
    public JAXBElement<String> createSearchFechaCreacion(String value) {
        return new JAXBElement<String>(_SearchFechaCreacion_QNAME, String.class, Search.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Search/v1.0",
                    name = "formato", scope = Search.class)
    public JAXBElement<String> createSearchFormato(String value) {
        return new JAXBElement<String>(_SearchFormato_QNAME, String.class, Search.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Search/v1.0",
                    name = "nombreOriginal", scope = Search.class)
    public JAXBElement<String> createSearchNombreOriginal(String value) {
        return new JAXBElement<String>(_SearchNombreOriginal_QNAME, String.class, Search.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Search/v1.0", name = "url",
                    scope = Search.class)
    public JAXBElement<String> createSearchUrl(String value) {
        return new JAXBElement<String>(_SearchUrl_QNAME, String.class, Search.class, value);
    }

}
