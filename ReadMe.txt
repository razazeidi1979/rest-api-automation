Objective:
Developed a simple framework which should support the development of automation test scripts for API services in Java.
This project is an example of API test for a weather application (URL: https://api.openweathermap.org/data/2.5/weather) using Rest Assured and TestNG.

Tools/Libraries Used:
1- Java 1.8 or above
2- Maven 
3- TestNG (Maven will take care of this)
4- Rest Assured (Maven will take care of this)

Steps To Start:
1- Clone/ Download the project into your local machine.
2- Open the command prompt and navigate to project location.
3- Execute the following Maven commands:
	-mvn clean--To clean the maven repo
	-mvn install--To install the maven requirements
	-mvn test--to execute the test scenarios
	
After tests are run, reports are generated at:
1- /target/surefire-reports/emailable-report.html
2- /target/surefire-reports/index.html

