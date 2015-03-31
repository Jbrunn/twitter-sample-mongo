# Sample Twitter Stram

This project collects from the sample twitter stream and stores the tweets in 
A mongoDB collection called Tweets

## Local Development and Testing

This set of instructions explains how to prepare your system for the local
development of Twitris' backend pipeline.

### Ubuntu 12.04 with Eclipse

#### Installing Dependencies

*   Maven 2
*   Git
*   MongoDB

To install these dependencies, simply execute the following using the command line:

	sudo apt-get install git maven mongodb-server

#### Enter your Twitter Credentials

	The file Stream.java contains four private static final string variables corresponding to 
	the twitter credentials made during app creation.

#### Run from Command Line
	This project is maven enable project and can be run by command prompt also.
	
*	Install mongodb in your local machine.
*	Open Terminal or Command prompt reach to the Project folder where your *pom.xml* file is kept.
*	Type *mvn clean* to clean the project and *mvn install* to run the project
	                            or
	You can type the *mvn clean install* to do both.