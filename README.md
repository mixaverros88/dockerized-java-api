# RESTful APIs with JAX-RS


## Postman Collection ##
You can find in postman folder a json to run tests via newman


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
3. 


### Jenkins
![preview image](https://github.com/mixaverros88/java-api/tree/master/src/main/webapp/resources/img/jenkins.jpg)
mvn test
