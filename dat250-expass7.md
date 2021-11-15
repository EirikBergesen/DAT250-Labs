

Expass 7

Problem: During Experiment 1
I did not manage to get Send and Recv to be run in the cli. I tried many different approaches, but I could not figure it out.

I tried for example:

java -cp ;amqp-client-5.7.1.jar;slf4j-api-1.7.26.jar;slf4j-simple-1.7.26.jar;. .\src\workqueues\Worker.java

java -cp .;amqp-client-5.7.1.jar;slf4j-api-1.7.26.jar;slf4j-simple-1.7.26.jar .\src\workqueues\Worker.java

javac -cp .;.\amqp-client-5.7.1.jar;slf4j-api-1.7.26.jar;slf4j-simple-1.7.26.jar; .\src\workqueues\Worker.java

java -cp .\amqp-client-5.7.1.jar;.\slf4j-api-1.7.26.jar;.\slf4j-simple-1.7.26.jar; .\src\workqueues\Worker.java

java -cp .\amqp-client-5.7.1.jar;.\slf4j-api-1.7.26.jar;.\slf4j-simple-1.7.26.jar; .\src\workqueues\Worker

java -cp .;amqp-client-5.7.1.jar;slf4j-api-1.7.26.jar;slf4j-simple-1.7.26.jar .\src\workqueues\Worker.java



I just could not figure this one out.

This also causes problems for the later experiments, but i will try to iron out this mistake.

Note: Even though I can not run these programs in the cli, they still work in intellij, which can run several classes at the same time.
