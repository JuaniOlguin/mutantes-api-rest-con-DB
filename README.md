# Desafio Mercado Libre

## Integrantes del Grupo
-Daibes Juan Ignacio
-Guevara Florencia
-Lee Angela
-Noseda Santiago
-Olguin Juan Ignacio

## Link Repositorio de Github
https://github.com/JuaniOlguin/mutantes-api-rest-con-DB

## Link para clonar repositorio
https://github.com/JuaniOlguin/mutantes-api-rest-con-DB.git

## Link del Deploy en Heroku
https://dashboard.heroku.com/apps/mutantes-app-tpa

## Tecnologías Utilizadas
- Java 11
- Spring Boot
- MySQL
- JPA y Hibernate
- Test de Estres con JMeter
- Heroku

# Acceso al Deploy de Heroku

## Encontrar mutante (usando postman para hacer el post de un array de strings)
- Metodo POST
- https://mutantes-app-tpa.herokuapp.com/api/tpa/mutant/ 

Ejemplo de entrada: 
{
    "dna": [
        "ATGCGA",
        "CAGTCC",
        "TTGTGT",
        "TGAAGG",
        "TCTCAA",
        "TCAAAA"
    ]
}

Esta petición debería devolver el status 200 (OK) si encuentra mutante o el estado 403 (FORBIDDEN) si no encuentra un mutante

## Traer todos los registros de ADN de la base de datos
https://mutantes-app-tpa.herokuapp.com/api/tpa/ 

## Calcular estadísticas
https://mutantes-app-tpa.herokuapp.com/api/tpa/stats/calcular/ 

## Trae todas las estadísticas calculadas historicamente
https://mutantes-app-tpa.herokuapp.com/api/tpa/stats/ 

## Trae todos los registros ingresados a la base de datos
https://mutantes-app-tpa.herokuapp.com/api/tpa/