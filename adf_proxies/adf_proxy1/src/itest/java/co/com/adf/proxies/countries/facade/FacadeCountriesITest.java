package co.com.adf.proxies.countries.facade;

import co.com.adf.modelo.exceptions.CountryCodeFormatException;
import co.com.adf.modelo.exceptions.CountryCodeNullOrEmtyException;
import co.com.adf.modelo.exceptions.CountryNotFoundException;
import co.com.adf.modelo.negocio.Pais;

import co.com.adf.proxies.countries.types.TCountryInfo;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class FacadeCountriesITest {
    
    private FacadeCountries sut = new FacadeCountries();
    private Pais pais;
    
    private TCountryInfo countryNotFound;
    
    @Before
    public void setUp() {
        pais = new Pais();
        
        countryNotFound = new TCountryInfo();
        countryNotFound.setSName("Country not found in the database");
    }
    
    @Test
    public void testConsultarColombia() {
        this.sut.consultarInformacionPais("CO", pais);
        
        assertEquals("Colombia", this.pais.getNombre());        
    }
    
    @Test(expected = CountryNotFoundException.class)
    public void testCountryInfoNotFoundException1() {
        this.sut.consultarInformacionPais("PX", this.pais);
        
        assertEquals(null, this.pais.getCapital());
    }
    
    @Test(expected = CountryNotFoundException.class)
    public void testCountryInfoNotFoundException2() {
        
        this.sut.consultarInformacionPais("PX", this.pais);
        
        assertEquals(countryNotFound.getSName(), this.pais.getNombre());
        
        verify(this.sut, times(1)).consultarInformacionPais("PX", this.pais);
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
        this.sut = null;
    }
           
}