package co.com.adf.proxies.countries.facade;

import co.com.adf.modelo.exceptions.CountryCodeFormatException;
import co.com.adf.modelo.exceptions.CountryCodeNullOrEmtyException;
import co.com.adf.modelo.exceptions.CountryNotFoundException;
import co.com.adf.modelo.negocio.Pais;
import co.com.adf.proxies.countries.proxy.CountryInfoServiceSoapType;

import co.com.adf.proxies.countries.types.ArrayOftLanguage;
import co.com.adf.proxies.countries.types.TCountryInfo;

import co.com.adf.proxies.countries.types.TLanguage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FacadeCountriesTest {
    
    @Mock
    private CountryInfoServiceSoapType port;
    
    @InjectMocks
    private FacadeCountries sut = new FacadeCountries();
    
    private TCountryInfo colombia;
    private TCountryInfo countryNotFound;
    private Pais pais;
    
    private final String CO_ISO = "CO";
    
    @Before
    public void setUp() {
        pais = new Pais();
        
        colombia = new TCountryInfo();
        colombia.setSISOCode("CO");
        colombia.setSName("Colombia");
        colombia.setSCapitalCity("Bogota");
        colombia.setSCurrencyISOCode("COP");
        colombia.setSCountryFlag("http://www.oorsprong.org/WebSamples.CountryInfo/Flags/Colombia.jpg");
        
        ArrayOftLanguage languages = new ArrayOftLanguage();
        
        TLanguage spanish = new TLanguage();
        spanish.setSISOCode("ES");
        spanish.setSName("Español");
        
        languages.getTLanguage().add(spanish);
        
        colombia.setLanguages(languages);
        
        countryNotFound = new TCountryInfo();
        countryNotFound.setSName("Country not found in the database");
    }
    
    @Test
    public void testConsultarPaisPorCodigo() {
        when(this.port.fullCountryInfo(CO_ISO)).thenReturn(colombia);
        
        this.sut.consultarInformacionPais(CO_ISO, this.pais);
        
        assertEquals(this.colombia.getSName(), this.pais.getNombre());
        
        verify(this.port, times(1)).fullCountryInfo(CO_ISO);
    }
    
    @Test(expected = CountryNotFoundException.class)
    public void testCountryInfoNotFoundException1() {
        when(this.port.fullCountryInfo("PX")).thenReturn(null);
        
        this.sut.consultarInformacionPais("PX", this.pais);
        
        assertNotNull(null, null);
    }
    
    @Test(expected = CountryNotFoundException.class)
    public void testCountryInfoNotFoundException2() {
        when(this.port.fullCountryInfo("PX")).thenReturn(countryNotFound);
        
        this.sut.consultarInformacionPais("PX", this.pais);
        
        assertEquals("Country not found in the database", this.pais.getNombre());
    }    
    
    @Test(expected = CountryCodeFormatException.class)
    public void testCountryCodeFormaException() {
        this.sut.consultarInformacionPais("C1", this.pais);    
    }
    
    @Test(expected = CountryCodeNullOrEmtyException.class)
    public void testCountryCodeNullOrEmtyExceptionNull() {
        String iso_code = null;
        this.sut.consultarInformacionPais(iso_code, this.pais);    
    }
    
    @Test(expected = CountryCodeNullOrEmtyException.class)
    public void testCountryCodeNullOrEmtyExceptionEmpty() {
        this.sut.consultarInformacionPais("", this.pais);    
    }
        
    @After
    public void cleanUp() {
        this.port = null;
        this.sut = null;
    }
}
