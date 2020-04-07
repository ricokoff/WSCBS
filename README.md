# WSCBS#

Welcome to group 18 of Web Service and Cloud Based Systems 2020. We implemented a SOAP calculator and a REST URLshortener. Please take a look at the folders of the respective project to learn more about our implementation.

## Prerequisities ##

To be able to run our implementations, some basic packages and programs are needed. We used the following settings:

### JDK 14 ###
We used Java Development Kit 14 to develop and run our programs. This JDK can be downloaded [here](https://www.oracle.com/java/technologies/javase-jdk14-downloads.html).

### Eclipse ###
We used Eclipse IDE 2020-03 which can be downloaded for windows [here](https://www.eclipse.org/downloads/download.php?file=/oomph/epp/2020-03/R/eclipse-inst-win64.exe).

### TomCat 9 ###
The Apache Tomcat® software is an open source implementation of the Java Servlet, JavaServer Pages, Java Expression Language and Java WebSocket technologies. We will use it to run the webservices and clients. TomCat 9 can be downloaded [here](https://tomcat.apache.org/download-90.cgi), and you can put it in any folder you'd like. To integrate TomCat with Eclipse follow the following steps:
In Eclipse, click on Windows > Preferences > Server > Runtime Environment. Here you can see the server runtime environments that are already installed in eclipse. Now you can click on "Add". Now you can enter a name for the TomCat environment and link to the installation folder of TomCat. Also specify JDK 14 as your JRE. Click "Finish", then "Apply and Close". You can now use the TomCat environment to run the services.

## Troubleshooting ##
Please come back to this section if you ever run into troubles while running our code. Often this is due to some invalid environment settings or missing packages. Here we will outline some of the errors that we encountered and how we fixed them.

### PORT already in use or invalid PORT ###
When you run a service, you will run it on the port that you specify at the server settings. This is port is 8080 by default. When you make 2 servers for 2 services, both will have the same port by default. This also holds when one of the services is a client. Our services assume that the Service Ports are 8080 and the Client ports are 8081. However you can choose whatever port you prefer. To edit your port settings go to "Servers" (Window > Show View > Other > Server > Servers), dubbelclick on the TomCat server where your service is in and go to the "ports" field. Change **BOTH** the admin port and the HTTP/1.1 port. It doesn't matter to which port you change it, as long as the port is not used by any other process. 


