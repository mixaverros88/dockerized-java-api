filepath=$PWD
cd $filepath
mkdir deploy
cd deploy
# Download the war from gihub
curl -LOk https://github.com/mixaverros88/java-api/raw/master/target/demorest.war
# run the docker
winpty docker run -it -p 80:8080 -v /$(pwd):/usr/local/tomcat/webapps mixaverross88/java-restfull-api:1.0