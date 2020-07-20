# Message Delivery System

## Getting Started
This application was developed using Java 8 and Spring Boot 2.3.1 along with [MongoDB](https://www.mongodb.com).
The application uses the following configuration to connect to the database:

 - Host: **localhost**
 - Port: **27017**
 - Database: **messagedeliverydb** (does not need to be created before hand)

The parameters used can be found on the [application.properties](https://github.com/cbalsan/messagedelivery/blob/master/src/main/resources/application.properties) file 

### Running the application
Please run the application with either one of the following:

#### For Linux/Mac users


       ./mvnw spring-boot:run

#### For Window users

    ./mvnw.cmd spring-boot:run

#### Third Alternative ;)

    mvn spring-boot:run

### Running the unit tests
The unit tests can be executed either through your IDE or with the following command

    mvn run test
The following components are covered by unit test

 - Controller
 - Service
 - Delivery

**Note: There are no unit tests validating the communication between the application and the database (DAO layer)** 

## How to schedule a new Message
After running one of the previous command the application will be ready on the  [port 8080](http://localhost:8080), the sections below explain what to expect and how to create new messages

## POST Request structure
In order to create a new Message a POST request to the URL http://localhost:8080/message using the *Content-Type application/json* must be submitted, below is the body structure for the request:

    {
	    "text":"Sample",
	    "deliveryDate":"2020-07-20 12:40 (sample)"
    }

Please be aware of the following restrictions:

 - The fields *text* and *deliveryDate* must be provided
 - The field *deliveryDate* must be in the format YYYY-MM-DD HH:mm
 - The field *deliveryDate* cannot be in the past (based on the server time, this implementation does not support timezone conversion)
 - Only one message can be created at the time (bulk create is not supported at this time)

### In case of errors
In case one of the above conditions is not satisfied the HTTP Code 400 (Bad Request) will be returned
### In case of success
If the message is successful scheduled the HTTP Code 202 will be returned along with Message created

**Note: There is currently no endpoint available to retrieve the messages delivered/to be delivered**

 ## Delivery of the scheduled messages
 The scheduler runs every 1 minute (you cannot schedule a message based on seconds) and looks for any message that satisfies the conditions:
 

 - Delivery date is lower or equals to the current server time **and** the message was not marked as delivered yet

Once a message is delivered, it is marked as delivered and the time of delivery is stored in the database.

In this current implementation the delivered messages are visible on the command line only 

 
