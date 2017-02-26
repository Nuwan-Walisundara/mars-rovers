# The Mars Rovers Problem

## 1. Introduction 
  

A squad of robotic rovers are to be landed by NASA on a plateau on Mars. This plateau, which is curiously rectangular, must be navigated by the rovers so that their on-board cameras can get a complete view of the surrounding terrain to send back to Earth.

## 2. System Requirements

- Java SE Development Kit 1.8 
- Apache Maven 3.0.x 

To build the product from the source distribution both JDK and Apache Maven are required. 

  
## 3. How to run
Two options are avalable 
- USing IDE export IED like eclipse and run the main class
-create as a library
-Create as executable jar

### 2.1 USing IDE
	export the project into eclipse IDE. Specify the the file name as argument. trigger the run as option.

### 2.2 create as a library
Go to folder. run as maven clean install.At this time tescases will trigger. Add commons-logging to class path .
run as 
	java -jar mars-rovers-1.0-SNAPSHOT.jar 'Path to txt'

### 2.2 Create as executable jar
run "mvn clean compile assembly:single" . This will bundle all the dependencies.
run as java -jar mars-rovers-1.0-SNAPSHOT.jar 'Path to txt'

## 3. Test cases
All the test resources are bundle at the testresource folder.Test cases include.
- testcase provied at the problum statement (testcase 1 & 2)
- Invalid Rover placement on plateau (testcase 3)
- Invalid Instruction . Rover try to hit the walls (test case 4)
