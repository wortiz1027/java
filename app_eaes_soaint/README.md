# TABLA DE CONTENIDO

1. [Proyecto Final Procesos de Negocio](#Projecto-Final-Procesos-de-Negocio)
    1. [AS-IS](#AS-IS)
    2. [TO-BE](#TO-BE)
    3. [Other information](#other-information)
        

# Proyecto Final Procesos de Negocio

El siguiente proyecto ilustra la aplicación de los conceptos aprendidos en clase  y desarrollar el TO-BE para la capacidad de negocio seleccionada por el grupo para el desarrollo de las actividades de la asignatura

![alt text](images/bpm.png "Modelo conceptual E-R del proceso Estratégico")

### AS-IS <a name="AS-IS"></a>

Después de el proceso de evaluación con APQC de describe el AS-IS de la capacidad de negocio seleccionada:

### Diagramas

#### Proceso Estrategico

![alt text](images/AS_IS/DisenoPrototipoProductosServicios.png "Modelo conceptual E-R del proceso Estratégico")

#### Proceso de Soporte

![alt text](images/AS_IS/FiltrarSeleccionarCandidato.png "Modelo conceptual E-R del proceso Estratégico")

### TO-BE

Después de realizar una evaluación del proceso existente se realizaron las mejoras respectivas que se visualizan en los siguientes diagramas BPMN:

### Diagramas

#### Misionales

![alt text](images/TO_BE/Misional/1_disenio_prototipo_productos_servicios.png "Disenio de prototipos de productos y servicios")

![alt text](images/TO_BE/Misional/2_verificar_asignar_recursos.png "Verificar y asignar recursos")

![alt text](images/TO_BE/Misional/3_desarrollar_especificaciones_disenio.png "Desarrollar especificaciones de disenio")

![alt text](images/TO_BE/Misional/4_construir_probar_prototipo.png "Contruir y probar prototipo")

#### Soporte

![alt text](images/TO_BE/Soporte/5_reclutar_seleccionar_empleados.png "Reclutar y seleccionar empleados")

![alt text](images/TO_BE/Soporte/6_filtrar_seleccionar_empleados.png "Filtrar y seleccionar empleados")

![alt text](images/TO_BE/Soporte/7_notificar_resultados.png "Notificar resultados")


## Descripción del Ambiente

Para el desarrollo del proyecto se seleccionaron productos Oracle en su versión 12c y otras herramientas que contribuyeron a construir el ambiente de desarrollo de la solución propuesta, dichas herramientas se describen a continuación:

| Nombre de la Herramienta | Versión |
|---|:-:|
| Clientes |  |
| Equipo comercial |  |
| Equipo de mercadeo |  |
| Equipo técnico | X |  

## Built With

* [jDeveloper](http://www.dropwizard.io/1.0.2/docs/) - The web framework used
* [Oracle SoaSuite 12c](https://maven.apache.org/) - Dependency Management
* [Oracle Database 12cR2](https://rometools.github.io/rome/) - Used to generate RSS Feeds

## Estructura de la Aplicacion

Parael desarrollo final de la solucion se decidio estructurar los proyectos en diferentes categorias de acuerdo a su proposito por ejemplo los proyectos bpm con los procesos, los proyectos adf con todo lo necesario para implementar las vistas y los procesos soa con la implementacion de los servicios.

### Proyectos ADF

A continuacion se ilustran los proyectos adf para la implementacion de las vistas de cada uno de los procesos:

![alt text](images/Proyectos/1_adf_configuracion.PNG "Proyecto de utilidades y configuracion")

![alt text](images/Proyectos/2_adf_estrategico.PNG "Proyecto con las vistas del proceso misional")

![alt text](images/Proyectos/3_adf_lookandfeel.PNG "Proyecto con los estilos de las vistas")

![alt text](images/Proyectos/4_adf_model.PNG "Proyecto con las definiciones del modelo java de las vistas")

![alt text](images/Proyectos/5_ad_proxy_content.PNG "Proyecto con cliente web service de los servicios del web center content de oracle")

![alt text](images/Proyectos/6_adf_proxy_database.PNG "Proyecto con cliente de web service de los servicios de bases de datos")

![alt text](images/Proyectos/7_adf_proxy_database2.PNG "Proyecto con cliente de web service de los servicios de bases de datos")

![alt text](images/Proyectos/8_adf_soporte.PNG "Proyecto con las vistas del procesos de soporte")

### Proyectos BPM

A continuacion se listan los proyectos con los procesos bpm mejorados(To-Be):

![alt text](images/Proyectos/9_bpm_estrategico.PNG "Proyecto con el disenio e implementacion del proceso y subprocesos misional")

![alt text](images/Proyectos/10_bpm_soporte.PNG "Proyecto con el disenio e implementacion del procesos y subprocesos de soporte")

### Proyectos SOA

A continuacion se listan los proyectos con las implementaciones de los servicios tanto de la base de datos como del gestor documental:

![alt text](images/Proyectos/11_soa_content.PNG "Proyecto con los servicios de gestion documental")

![alt text](images/Proyectos/12_soa_database_2.PNG "Proyecto con los servicios y conexiones a bases de datos 2")

![alt text](images/Proyectos/13_soa_database.PNG "Proyecto con los servicios y conexiones a bases de datos 1")

### Vistas

#### Vistas del proceso misional

[Nota]: Insertar imagenes

#### Vistas del proceso de soporte

[Nota]: Insertar imagenes

## Modelo E-R de la solución

[Nota]: Insertar imagenes

### Modelo E-R Proceso Estratégico

![alt text](images/MER/ERDPrototipoProductosServicios.jpg "Modelo conceptual E-R del proceso Estratégico")

### Modelo E-R Proceso de Soporte

![alt text](images/MER/ERDFiltroSeleccionCandidatos.jpg "Modelo conceptual E-R del proceso de soporte")

## Versiones

Para llevar un mejor control de los fuentes y su trazabilidad el equipo decidio utilizar repositorios git y [gitlab](https://gitlab.com/wortiz1027/app_eaes_soaint.git) para mantener centralizado 

## Autores

* **Brian Suarez Botia** - *Encargado del diseño del modelo de base de datos y los procedimeintos alamacenados, creación y configuración de indicadores en Oracle BAM 12c*
* **Eduardo Franco Rivera** - *Encargado de definición de procesos AS-IS y TO-BE e implementación de vistas Oracle ADF 12c*
* **Jhon Celemin Florez** - *Encargado de la creación del ambiente de gestión documental y crear las estructuras documentales y los web services para consultar los documentos*
* **Wilman Ortiz Navarro** - *Encargado de la creación del ambiente Oracle SoaSuite con todas las herramientas necesarias, adicional la creación de los BPELs para la centralización de los servicios que van a consumir las actividades y las vistas de los procesos*


## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details