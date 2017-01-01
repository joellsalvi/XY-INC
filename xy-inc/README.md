SERVIDOR UTILIZADO NO DESENVOLVIMENTO

* JBOSS AS 7.1

INSTRUCOES PARA EXECUÇÃO

* Colocar arquivo xy-inc.war em um servidor Jboss AS 7.1 e subir o mesmo.
* Caso for subir pelos fontes, executar clean install antes.

SERVIÇOS DISPONÍVEIS

* FIND ALL
	- pattern = host/xy-inc
	- http://localhost:8080/xy-inc/
	
* INSERT
	- pattern = host/xy-inc/insert/nomePontoDeInteresse/CoordenadaX/CoordenadaY
	- http://localhost:8080/xy-inc/insert/teste/123/345

* FIND BY MARGEM
	- pattern = host/xy-inc/margem/CoordenadaX/CoordenadaY/Margem
	- http://localhost:8080/xy-inc/margem/20/10/10