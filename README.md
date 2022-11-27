# informaticaTest
Informatica GIT repo sample
The InformaticaTest project is a spring boot application which runs on port 8080 to retrieve the repositories from Github by given languauge.

**Steps to run in local :**
1. Since this application is developed and compiled on Java 11, So Java 11 has to be installed on the machine.
2. Once the application is downloaded in local make sure it's cleaned and compiled with **mvn clean install** to download all the required dependencies
3. Once it's cleaned and installed run http://localhost:8080/api/repo?lang=java in browser to get all the repositories developed in java language. here lang=java can be anything like (ruby,java,spring,aws,docker and etc.)

**Sample Url requests:**

 http://localhost:8080/api/repo?lang=java ---> lists all repos with java
 http://localhost:8080/api/repo?lang=docker ---> lists all repos with docker
 http://localhost:8080/api/repo?lang=$$ ---> throws an error response for invalid language value
 http://localhost:8080/api/repo  ---> throws an error response for not providing language value
  http://localhost:8080/api/asdosd ---> throws an error response for invalid request url
