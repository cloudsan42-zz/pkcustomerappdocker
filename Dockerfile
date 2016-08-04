FROM java:openjdk-8u91-jdk
MAINTAINER snukala@prokarma.com
EXPOSE 8080
ADD target/customer-microservice-1.0.0.jar .
CMD java -Ddbhosts=mongodbpk:27017 -jar customer-microservice-1.0.0.jar
