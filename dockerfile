FROM tomcat:8.0-alpine

LABEL maintainer="mixalisverros@hotmail.gr"

# ADD demorest.war /usr/local/tomcat/webapps/

EXPOSE 8080

CMD ["catalina.sh", "run"]
