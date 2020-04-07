# WSCBS SOAP
All the service and clients projects are located in a seperate folder. To get it running, import the project as a Maven project in eclipse using the pom.xml file. After loading the project, you will have to create a server for the service/client. If you don't see a tab "Servers" in your menu, you can add it by navigating to Window > Show View > Other > Server and dubbelclick servers. Here you can rightclick in the Servers menu and click on new > Server. Select the TomCat v9.0 server and click next. Now add your service to the server and click on finish. The service is now ready to run. You can edit the ports by dubbelclicking on the tomcat server that has your service in it. Make sure to use different ports if you want to run different services (or clients) at the same time. To use the web links that we provide, your service port should be 8080 and your client port should be 8081.

The bottom-up SOAP calculator is located in the CalculatorService folder.
After running the server, the service can be located at:
http://localhost:8080/CalculatorService/ws/calculator

The bottom-up SOAP client is located in the CalculatorClient folder.
After running the server, the service can be located at:
http://localhost:8081/CalculatorClient/sampleCalculatorProxy/TestClient.jsp

The top-down SOAP calculator is located in the TopDownCalculator.
After running the server, the service can be located at:
http://localhost:8080/TopDownCalculator/services/CalculatorPort

The top-down SOAP client is located in TopDownClient.
After running the service, the service can be located at:
http://localhost:8081/TopDownClient/sampleCalculatorProxy/TestClient.jsp
