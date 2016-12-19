
# Base container contains maven, jdk on ubuntu
FROM maven:3.3-jdk-8

#EXPOSE 8080
ADD settings.xml /root/.m2/settings.xml

RUN mkdir -p /usr/src/app

# move the app directory inside container to perform mvn buill
WORKDIR /usr/src/app

#firstly add pom.xml because its a archive with few modifications so we avoid to run the nex commands
#because maven pull data from cache
ADD pom.xml /usr/src/app

ADD . /usr/src/app

# build by using maven
RUN mvn install




CMD ["java","-jar","target/proyectoPrueba-1.0-SNAPSHOT.jar"]
