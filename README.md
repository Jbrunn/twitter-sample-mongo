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

	as long as that doesn't produce any errors, you should now have a jar. Now you can run it with 
	java -jar target/twitter-sample-mongo-0.1-jar-with-dependencies.jar
	
### Check the DB
	
#### To start the mongo shell
	
	mongo localhost/twitter_sample

*	db.tweets.count() - how many tweets have been collected
*	db.tweets.findOne() - display one tweet
*	db.tweets.find().sort({$natural:-1}).limit(1) - display the most recent tweet
*	db.tweets.find() - display all tweets 10 at a time. Show more by typing "it"
