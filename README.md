# User Creation Microservice with Email Sending

This project consists of two interconnected microservices that work together to create users and send a confirmation email. Using Java, Spring, Postgres, RabbitMQ and Gmail's AMQP.

## Project Components

### 1. User Creation Microservice

<a href="https://github.com/GuiEstevamCorrea/User_Microservice">
  Link to User Creation Microservice Repository
  </a> <br/> <br/>

This microservice is responsible for creating new users. It exposes REST endpoints to receive user creation requests and interacts with a database to store user information.

#### Technologies Used:
- Java
- Spring Boot
- Spring Data JPA
- Postgres
- RabbitMQ

#### Settings:
- Configure database settings in the `application.properties` or `application.yml` file.
- Make sure you correctly configure the dependencies in the `pom.xml` file.

### 2. Email Sending Microservice

This microservice is responsible for sending confirmation emails to users newly created by the first microservice. It consumes messages from the RabbitMQ queue, gets the user details and sends a confirmation email using the Gmail API.

#### Technologies Used:
- Java
- Spring Boot
- RabbitMQ for asynchronous messaging
- Gmail AMQP

#### Settings:
- Configure Gmail API credentials in the `application.properties` or `application.yml` file.
- Make sure you correctly configure the dependencies in the `pom.xml` file.
- Configure the connection with RabbitMQ in the `application.properties` or `application.yml` file.

## Configuration and Execution

1. Clone this repository:

    ```bash
    git clone https://github.com/seu-usuario/nome-do-repositorio.git

2. Import the projects into your preferred IDE (Eclipse, IntelliJ, etc.).

### Additional Settings:

- Make sure RabbitMQ is installed and running.
- Configure the necessary information in the application.properties or application.yml files in both projects.

- Run microservices:

    - Start the User Creation Microservice.
    - Start the Email Sending Microservice.
    - Access the User Creation Microservice endpoints to create users.

- Check the logs and make sure the confirmation emails are sent successfully by the Email Sending Microservice.