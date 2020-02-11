![preview image](https://img.shields.io/github/followers/mixaverros88?label=Follow&style=plastic)
![preview image](https://img.shields.io/github/forks/mixaverros88/java-api?style=plastic)
![preview image](https://img.shields.io/github/stars/mixaverros88/java-api?style=plastic)
![preview image](https://img.shields.io/github/watchers/mixaverros88/java-api?style=plastic)
[![Known Vulnerabilities](https://snyk.io/test/github/mixaverros88/java-api/badge.svg?targetFile=pom.xml)](https://snyk.io/test/github/mixaverros88/java-api?targetFile=pom.xml)

# RESTful APIs with JAX-RS
![preview image](https://github.com/mixaverros88/java-api/blob/master/icons/java_rest_api.jpg)

## Docker Instructions ##
![preview image](https://github.com/mixaverros88/java-api/blob/master/icons/dockerIcon.png) You can run the dockerRun.sh in order to spin up a docker container or you can download the war file from github.
````
curl -LOk https://github.com/mixaverros88/java-api/raw/master/target/demorest.war
````
Spin up the container.
````
docker run -it -p 80:8080 -v /$(pwd):/usr/local/tomcat/webapps mixaverross88/java-restfull-api:1.0
````
Or run the compose file.
````
docker-compose up
````
Navigate to the following link.
````
[docker-machine ip]:80/demorest/
````
### See the docker file in the Docker Hub ###
https://hub.docker.com/r/mixaverross88/java-restfull-api

## Status codes for CRUD operations ##

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


## This rest api follows the Richardson Maturity Model ##
![preview image](https://github.com/mixaverros88/java-api/blob/master/icons/The-Richardson-Maturity-Model-Nordic-APIs.png) 

1. Resource URI (Individual URIs for each resource)
2. HTTP Methods (GET, POST, PUT, DELETE)
3. HATEOAS (Responses have links that the clients can use) 

## Postman Collection ##
![preview image](https://github.com/mixaverros88/java-api/blob/master/icons/postman2.png) You can find in postman folder a json to run tests via newman.

## Jenkins ##
![preview image](https://raw.githubusercontent.com/mixaverros88/java-api/master/src/main/webapp/resources/img/jenkins.jpg)
mvn test
