# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.6.6/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.6.6/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.6.6/reference/htmlsingle/#boot-features-developing-web-applications)

### Guides

The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)




1 tabella:

DBHammurabi

-Turni //forse

Popolazione
- diminuire (a causa degli eventi random *plague*)
- aumenta (all'inizio del nuovo anno/turno)
- è int
- valore di default


    10 persone
ID - Quantità(val.default) 


Grano
- è int
  - valore di default (circa 3 ad 1 con la popolazione)

    diminuisce:
    - usato per creare terreni
    - viene usato per seminare i terreni
    - sfamare la popolazione()
    - evento random ratti
    
    aumenta:
    - per ogni terreno coltivato ti restituisce una certa quantità(in un certo range) di grano
    
    
    30 grani

ID - Quantità(val.default) 

Terreno
- è int
- valore di default 0
- valore di default per il costo in grano
- per convenzione 1 terreno alloggia masimo 1o2 persona/e
- nell'avanzare dei turni il costo aumenta //da decidere


    0 terreni 
    2 grani di costo

ID - Quantità - Costo 

Tabella2:

Terreni-Grano

ID - Quantitàtotale - QuantitàSeminati - 