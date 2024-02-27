
package co.edu.javeriana.proxies.advancesearch.types;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SearchResponse complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="SearchResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="searchResults" type="{http://xmlns.javeriana.edu.co/co/schemas/process/bpm/WCC_Search/v1.0}AdvancedSearchResult" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SearchResponse", propOrder = { "searchResults" })
public class SearchResponse {

    protected List<AdvancedSearchResult> searchResults;

    /**
     * Gets the value of the searchResults property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the searchResults property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSearchResults().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AdvancedSearchResult }
     *
     *
     */
    public List<AdvancedSearchResult> getSearchResults() {
        if (searchResults == null) {
            searchResults = new ArrayList<AdvancedSearchResult>();
        }
        return this.searchResults;
    }

}
