# BankWSClient

*BankWSClient* is a spring-boot application written in java language that consumes soap web services, computes the data retrieved 
from soap calls, exposes the result via rest services.

## Business case

Our application need to access the core banking system to retrieve all transaction history of the user. After that it computes the
current balance of the user. Finally it will exposes the balance to client apps that can be mobile application or single page application.

## Technology

BankWS is using the following technologies:
- Java [version: 11] (the language used to write the application)
- Maven [version:3.6] (the tool for managing dependencies and building the project) 
- Lombok [version:1.18.12] (the java library for removing boiler plate code from pojos)
- Spring-Boot [version:2.3.0.RELEASE] (the framework for creating spring application that just run)
- Liquibase [version:3.8.9] (the tool for keeping the version control for relational databases)
- JAX-WS [version:2.3.0] (the library for exposing soap web service endpoints)

## Implementation Details

Below is the maven plugin that generates all the classes from wsdl:

```	
<plugin>
    <groupId>org.jvnet.jaxb2.maven2</groupId>
    <artifactId>maven-jaxb2-plugin</artifactId>
    <version>0.13.2</version>
    <executions>
        <execution>
            <goals>
                <goal>generate</goal>
            </goals>
        </execution>
    </executions>
    <configuration>
        <generatePackage>com.github.rshtishi.bankws.soap.client.bankws</generatePackage>
        <generateDirectory>${project.basedir}/src/main/java</generateDirectory>
        <schemaDirectory>${project.basedir}/src/main/resources/WSDL</schemaDirectory>
        <schemaIncludes>
            <include>*.wsdl</include>
        </schemaIncludes>
    </configuration>
</plugin>
```
When we run the build of project the plugin will be executed and generate the classes from wsdl. The classes generated will
be used to create request and response.

Below we prepare request to the soap service by using the class ```ObjectFactory``` generated during the build of the project:
```
public JAXBElement < GetTrasactionsResponse > getAllTransactions() {
 template = new WebServiceTemplate(marshaller);
 ObjectFactory factory = new ObjectFactory();
 GetTrasactions getTransactions = factory.createGetTrasactions();
 JAXBElement < GetTrasactions > request = factory.createGetTrasactions(getTransactions);
 JAXBElement < GetTrasactionsResponse > response = (JAXBElement < GetTrasactionsResponse > ) template
  .marshalSendAndReceive(soapProperties.getEndpoint().getUrl(), request);
 return response;
}
```

In application.properties file you can configure the soap endpoint url:
```
#Soap
soap.endpoint.url=http://localhost:8888/baws
```

## Setting up the project

Before starting to setup the *BankWSClient* projet you need to have already set up and running the *BankWS* project. 
Check this link [BankWS Project Information](https://github.com/rshtishi/BankWS/blob/master/README.md) for setting up 
running the *BankWS* project.

After have set up and run the *BankWS* project, we can proceed with step below  for setting up the *BankWSClient* project:

- Clone the repository in you computer by executing: ```git clone https://github.com/rshtishi/BankWSClient.git```
- build the application by executing the command: ```mvn clean install```
- run the application by executing the command: ```mvn spring-boot:run```
- access url: ```http://localhost:9090/bank/rshtishi``` to check if application started successfully
