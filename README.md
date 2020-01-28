# RESTful APIs with JAX-RS


## Postman Collection ##
You can find in postman folder a json to run tests via newman

## Docker ##
You can run the dockerRun.sh in order to spin up in a docker container

Download the war file from github
````
curl -LOk https://github.com/mixaverros88/java-api/raw/master/target/demorest.war
````
Spin up the container
````
docker run -it -p 80:8080 -v /$(pwd):/usr/local/tomcat/webapps mixaverross88/java-restfull-api:1.0
````
https://hub.docker.com/r/mixaverross88/java-restfull-api

### Status codes for CRUD operations

|Operation|URI|Method|Success/Failure|Status Code|
|----  |:-----:|:-----:|:-----:|:-----:|
|Get Message|messages/{messageId}|Get|Success|200|
| | | |Not found|404|
| | | |Failure|500|
|Delete Message|messages/{messageId}|Delete|Success|200 or 204|
| | | |Not found|404|
| | | |Failure|500|
|Edit Message|messages/{messageId}|Put|Success|201|
| | | |Wrong Format data|400 or 415|
| | | |Not found|404|
| | | |Failure|500|
|Create Message|messages|Post|Success|201|
| | | |Wrong Format data|400 or 415|
| | | |Not found|404|
| | | |Failure|500|


### This rest api follows the Richardson Maturity Model
1. Resource URI
2. HTTP Methods
3. HATEOAS (Hypermedia) 


### Jenkins
![preview image](https://raw.githubusercontent.com/mixaverros88/java-api/master/src/main/webapp/resources/img/jenkins.jpg)
mvn test

[![Known Vulnerabilities](https://snyk.io/test/github/mixaverros88/java-api/badge.svg?targetFile=pom.xml)](https://snyk.io/test/github/mixaverros88/java-api?targetFile=pom.xml)
