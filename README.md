# Overview 
A command-line application built using Spring Shell. It demonstrates how to work with Spring Shell by implementing some basic functionalities. It includes examples of file operations, custom greetings, and other simple commands to create a custom shell environment.
For more information, you can refer to the [Spring Shell documentation](https://docs.spring.io/spring-shell/reference/index.html).


# Installation
## Prerequisites
- Java 11 or higher
- Maven 3.6.3 or higher
- Optional: GraalVM for native image generation

## Steps

### Build the application:
```bash
mvn clean package -DskipTests 
```

### Run the application:
```bash
java -jar target/native-cli-app-0.0.1-SNAPSHOT.jar
``` 

## Running with GraalVM Native Image
If you have GraalVM installed, you can build and run a native executable:

### Generate the native executable:
```shell
./mvnw -Pnative native:compile -DskipTests
```

### Run the native executable:
```shell
./target/native-cli-app
```

This will compile your application into a native binary, significantly reducing the startup time and memory usage, making it ideal for deployment in environments where resources are limited.

# Usage
Once the application is running, you can use the following command to test it:

### Custom Greeting
```shell
hello --name "YourName" --counter 3
```
Generates a greeting message for the specified name and number of iterations.

use the ```help``` command to list all the available commands so you can try them.
