#maven con jdk 11
#imagen java
FROM maven:3.6.3-jdk-11-slim 
#se crea una carpeta dentro del container (run)
RUN mkdir /app
WORKDIR /app
#copio lo que esta al nivel dockerfile (proycto) al container
COPY . .
RUN mvn clean install

CMD mvn spring-boot:run