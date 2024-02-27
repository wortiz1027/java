package co.com.adf.proxies.countries.facade;

import co.com.adf.modelo.enums.ErrorCodes;
import co.com.adf.modelo.exceptions.CountryCodeFormatException;
import co.com.adf.modelo.exceptions.CountryCodeNullOrEmtyException;
import co.com.adf.modelo.exceptions.CountryNotFoundException;
import co.com.adf.modelo.negocio.Pais;
import co.com.adf.modelo.negocio.ParNombreValor;

import co.com.adf.proxies.countries.proxy.CountryInfoService;
import co.com.adf.proxies.countries.proxy.CountryInfoServiceSoapType;
import co.com.adf.proxies.countries.types.TCountryInfo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.ws.BindingProvider;

import oracle.adf.share.logging.ADFLogger;

public class FacadeCountries implements java.io.Serializable {
    @SuppressWarnings("compatibility:-8965407141697667012")
    private static final long serialVersionUID = 1L;

    private static final ADFLogger LOGGER = ADFLogger.createADFLogger(FacadeCountries.class);
    
    private static final String ISO_CODE_PATTERN = "^[A-Z ]{2}+$";
    private static final String ERROR_TEMPLATE = "\nERROR-CODE: %s \nERROR-DESC: %s";
    private static final String ENDPOINT_WS = "http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso?WSDL";
    private static final String MSG_COUNTRY_NOT_FOUND = "Country not found in the database";
        
    private transient CountryInfoService service;
    private transient CountryInfoServiceSoapType port;
    
    private CountryInfoService getService() {
        if (this.service == null) {
            this.service = new CountryInfoService();
        }
        return this.service;
    }

    private CountryInfoServiceSoapType getPort() {
        try {
            if (this.port == null) {
                this.port = getService().getCountryInfoServiceSoap();
                ((BindingProvider) this.port).getRequestContext()
                                             .put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, ENDPOINT_WS);
            }
        } catch (Exception e) {
            LOGGER.severe("Error creando la conexion al servicio", e);
        }
        return this.port;
    }
    
    public void consultarInformacionPais(final String codigo, final Pais pais) {
        LOGGER.fine("::: Consultando Pais :::");
        if (codigo == null || codigo.isEmpty()) {
            throw new CountryCodeNullOrEmtyException(String.format(ERROR_TEMPLATE, 
                                                                   ErrorCodes.COUNTRY_CODE_NULL_EMPTY_ERROR.getCode(), 
                                                                   "El codigo de pais no puede ser nulo o vacio!"), ErrorCodes.COUNTRY_CODE_NULL_EMPTY_ERROR);
        }
                
        if (!validateCountryCodeFormat(codigo)) {
            throw new CountryCodeFormatException(String.format(ERROR_TEMPLATE, 
                                                               ErrorCodes.COUNTRY_CODE_ISO_ERROR.getCode(), 
                                                               "Error en el formato del codigo!"), ErrorCodes.COUNTRY_CODE_ISO_ERROR);
        }
        
        TCountryInfo response = this.getPort().fullCountryInfo(codigo);
        
        if (response == null || response.getSName().equalsIgnoreCase(MSG_COUNTRY_NOT_FOUND)) {
            throw new CountryNotFoundException(String.format(ERROR_TEMPLATE, 
                                                             ErrorCodes.COUNTRY_NOT_FOUND_ERROR.getCode(), 
                                                             "El pais buscado no existe!"), ErrorCodes.COUNTRY_NOT_FOUND_ERROR);
        }
        
        pais.setCodigo(response.getSISOCode());
        pais.setNombre(response.getSName());
        pais.setCapital(response.getSCapitalCity());
        pais.setMoneda(response.getSCurrencyISOCode());
        pais.setBandera(response.getSCountryFlag());
        
        response.getLanguages()
                .getTLanguage().forEach(tmp -> {
                                        ParNombreValor idioma = new ParNombreValor();
                                        
                                        idioma.setLlave(tmp.getSISOCode());
                                        idioma.setValor(tmp.getSName());
                                        
                                        pais.getIdiomas().add(idioma);
                                    });
        
    }
        
    private boolean validateCountryCodeFormat(String code) {
        Pattern pattern = Pattern.compile(ISO_CODE_PATTERN);
        
        Matcher m = pattern.matcher(code);
        
        return m.find();
    }
    
}