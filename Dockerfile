FROM openjdk:8-jdk-alpine
WORKDIR /
ADD ./BookingService/BookingLookupService/target/BookingLookupService-0.0.1.jar BookingLookupService-0.0.1.jar
EXPOSE 8280
ENTRYPOINT ["java","-jar","/BookingLookupService-0.0.1.jar"]

