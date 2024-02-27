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
    - Sobre el directorio raiz del repositorio paywaoint-query-service  
    > docker build --no-cache=true --build-arg BUILD_DATE=$(date -u +'%Y-%m-%dT%H:%M:%SZ') --build-arg BUILD_VERSION='1.0-stable' --tag=equipo5/paywoaint-query-service --rm=true . 

#### Iniciar los contenedores
    - Sobre el directorio raiz del repositorio paywaoint-query-service
    > docker-compose up
    
#### Request GET METHOD http://localhost:8080/paywaoint/api/v1/validation
```json
{
    "creditCard": {
        "mount": 20000,
        "type": "AMEX",
        "number": "3778-1363-3989-3386"
    }
}
```

#### Response GET METHOD http://localhost:8080/paywaoint/api/v1/validation
```json
{
    "status": {
        "code": "SUCCESS",
        "description": "CreditCardValidation query has been success"
    },
    "result": true
}
```

#### Request POST METHOD http://localhost:8080/paywaoint/api/v1/charge
```json
{
    "creditCard": {
        "mount": 30000,
        "type": "AMEX",
        "number": "3778-1363-3989-3386"
    }
}
```

#### Response POST METHOD http://localhost:8080/paywaoint/api/v1/charge
```json
{
    "status": {
        "code": "SUCCESS",
        "description": "ChargeCreditCard query has been success"
    },
    "result": true
}
```