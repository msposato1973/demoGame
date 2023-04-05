# Read Me First
The following was discovered as part of building this project:

* The JVM level was changed from '11' to '17', review the [JDK Version Range](https://github.com/spring-projects/spring-framework/wiki/Spring-Framework-Versions#jdk-version-range) on the wiki for more details.

# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.0.5/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.0.5/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.0.5/reference/htmlsingle/#web)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.0.5/reference/htmlsingle/#data.sql.jpa-and-spring-data)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.0.5/reference/htmlsingle/#using.devtools)
* [Validation](https://docs.spring.io/spring-boot/docs/3.0.5/reference/htmlsingle/#io.validation)
* [Spring Security](https://docs.spring.io/spring-boot/docs/3.0.5/reference/htmlsingle/#web.security)

### Guides
The following guides illustrate how to use some features concretely:

## Functional requirements:

1.REST endpoint for login that can receive the following POST data:

```json
 curl -X POST -H 'Content-Type: application/json' -d 

	{
	        "user": "demo1",
	        "password": "password1"
	}
	
 http://localhost:7000/api/login -i
 ```
 


2. REST endpoint for game launch that can receive the following POST data:

```json
  curl -X POST -H 'Content-Type: application/json' -d 

	{
	        "token":"<token returned in the previous API call>",
			 "gameid":"superspins"
	}
	
 http://localhost:7000/api/lunchGaming -i
 ```

 ### How to compile ?
- If you use Maven, run the following command in a terminal window (in the complete directory):
	`mvn clean install`
	
### How to Run ?

- If you use Maven, run the following command in a terminal window (in the complete directory):
 `mvn spring-boot:run`



Run Spring Boot application with command: `mvn spring-boot:run`

If you want to test URL by client service example : 'Postman'

- 1 rest endpoint implementation 
- Create a new POST request and as body > raw , add this 
- url http://localhost:7000/api/v1/login

{
    "user": "demo1",
    "password": "password1"
}

- 2 rest endpoint implementation 
- Create a new POST request and as body > raw , add this 
- url localhost:7000/api/v1/lunchGaming

{
    "token": "66d488ba-cf4a-11ed-afa1-0242ac120002",
    "gameid": "superspins"
}

