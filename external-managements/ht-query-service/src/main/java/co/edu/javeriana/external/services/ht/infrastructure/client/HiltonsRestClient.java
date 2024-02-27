package co.edu.javeriana.external.services.ht.infrastructure.client;

import co.edu.javeriana.external.services.ht.domain.RestClient;
import co.edu.javeriana.external.services.ht.dtos.Response;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.text.ParseException;
import java.util.*;

@Service
public final class HiltonsRestClient implements RestClient {

    @Value("${client.host}")
    private String PROXY_SERVER_HOST;

    @Value("${client.port}")
    private int PROXY_SERVER_PORT;

    @Value("${rest.api.url.booking}")
    private String URL;

    private RestTemplate restTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper();

    private void setUp() {
        if (this.restTemplate == null) {
            final Proxy proxy = new Proxy(Type.HTTP, new InetSocketAddress(PROXY_SERVER_HOST, PROXY_SERVER_PORT));
            final SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
            requestFactory.setProxy(proxy);

            this.restTemplate = new RestTemplate(requestFactory);
        }
    }

    private Map<String, String> getResponseFromRestTemplate() {
        final ResponseEntity<String> responseEntity = restTemplate.getForEntity(URL, String.class);
        Map <String,String> paramsMap = null;

        try {
            paramsMap = objectMapper.readValue(responseEntity.getBody(), Map.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return paramsMap;
    }

    private Response mapResponseToRespose(Map<String, String> mapParams) {
        if (mapParams != null) {
            String date = mapParams.get("date");
            String request = mapParams.get("request");
            String response = mapParams.get("response");

            date = date.replace("T", " ");
            date = date.substring(0, date.indexOf("+") - 1);

            try {
                return new Response(DateUtils.parseDate(date, new String[] {"yyyy-MM-ss HH:mm:ss.SSS"}), request, response.equalsIgnoreCase("true"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        return new Response(new Date(), "", Boolean.FALSE);
    }

    @Override
    public Response getBooking() {
        setUp();
        Map<String, String> paramsMap = getResponseFromRestTemplate();
        return mapResponseToRespose(paramsMap);
    }
}
