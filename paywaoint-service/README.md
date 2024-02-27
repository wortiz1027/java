| <img src="logo/logo_pug.png" width="130px" height="180px"> | <h1> PONTIFICIA UNIVERSIDAD JAVERIANA </h1> |
| :--: |  :--: |

## TALLE PICA(Proyecto de Implementacion Centrado en la Arquitectura)

### EQUIPO 5 
El equipo 5 está conformado por:
  - *Jhon Edward Celemin Florez*
  - *Eduardo José Franco Rivera*
  - *Wilman Alberto Ortiz Navarro*
  - *Brian Camilo Suarez Botia*
  
#### Crear la red que comunica los servicios  
    > docker network create --driver bridge ntw_backend
    
#### Compilar la imagen
    - Sobre el directorio raiz del repositorio paywoaint-service
    >  docker build --no-cache=true --build-arg BUILD_DATE=$(date -u +'%Y-%m-%dT%H:%M:%SZ') --build-arg BUILD_VERSION='1.0-stable' --tag=equipo5/paywoaint-service --rm=true .
    
#### Iniciar los contenedores
    - Sobre el directorio raiz del repositorio paywoaint-service
    > docker-compose up
    
#### WSDL

#### Request operacion verifyCreditCard
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ser="http://services.creditverifier.com/" xmlns:typ="http://services.creditverifier.com/types/">
   <soapenv:Header/>
   <soapenv:Body>
      <ser:verifyCreditCardElement>
         <ser:cc>
            <typ:type>AMEX</typ:type>
            <typ:mount>120000</typ:mount>
            <typ:number>3778-1363-3989-3386</typ:number>
         </ser:cc>
      </ser:verifyCreditCardElement>
   </soapenv:Body>
</soapenv:Envelope>
```

#### Response operacion verifyCreditCard
```xml
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
   <SOAP-ENV:Header/>
   <SOAP-ENV:Body>
      <ns2:verifyCreditCardResponseElement xmlns:ns2="http://services.creditverifier.com/">
         <ns2:result>true</ns2:result>
      </ns2:verifyCreditCardResponseElement>
   </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```

#### Request operacion chargeCreditCard
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ser="http://services.creditverifier.com/" xmlns:typ="http://services.creditverifier.com/types/">
   <soapenv:Header/>
   <soapenv:Body>
      <ser:chargeCreditCardElement>
         <ser:cc>
            <typ:type>AMEX</typ:type>
            <typ:mount>20000</typ:mount>
            <typ:number>3778-1363-3989-3386</typ:number>
         </ser:cc>
      </ser:chargeCreditCardElement>
   </soapenv:Body>
</soapenv:Envelope>
```

#### Response operacion chargeCreditCard   
```xml
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
   <SOAP-ENV:Header/>
   <SOAP-ENV:Body>
      <ns2:chargeCreditCardResponseElement xmlns:ns2="http://services.creditverifier.com/">
         <ns2:result>true</ns2:result>
      </ns2:chargeCreditCardResponseElement>
   </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```