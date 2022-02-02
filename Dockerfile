FROM openjdk:8
ADD target/HospitalManagement.jar HospitalManagement.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","HospitalManagement.jar"]