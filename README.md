# Sample Twitter Stram

This project collects from the sample twitter stream and stores the tweets in 
A mongoDB collection called Tweets

## Local Development and Testing

This set of instructions explains how to prepare your system for the local
development of Twitris' backend pipeline.

### Ubuntu 12.04

#### Installing Dependencies

*   Maven
*   Git
*   MongoDB

To install these dependencies, simply execute the following using the command line:

	sudo apt-get install git maven mongodb-server

### Clone the Repository
	
	git clone https://github.com/Jbrunn/twitter-sample-mongo.git

### Start Mongo

	mongod & or nohup mongod &

#### Enter your Twitter Credentials

	The file Stream.java contains four private static final string variables corresponding to 
	the twitter credentials made during app creation (you need to have a twitter account and 
	then create a new app, then generate the necessary keys).

#### Run from Command Line
	
*	Install mongodb in your local machine.
*	Open Terminal or Command prompt reach to the Project folder where your *pom.xml* file is kept.
*	Type *mvn clean* to clean the project and *mvn install* to run the project
	                            or
	You can type the *mvn clean install* to do both.

