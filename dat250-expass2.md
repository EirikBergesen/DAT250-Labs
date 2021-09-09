## DAT250: Software Technology Experiment Assignment 2





#### Problem: I get an error while trying to vertify the program in point 4.3:
![Error in eclipse dat250 lab2](https://user-images.githubusercontent.com/46929671/132375133-c7fad33a-8c73-429d-ac3c-e14240ca00b8.png)

I do not understand what is going on. I'll wait for the group session and try to get help there.

Solution: Seems like that was supposed to happen and that maven is wierd?


#### Problem:

I had problems adding lombok correctly to my dependencies.

Solution:

Got help from a friend whom told me to click a "maven refresh"(?) button that pups up. I dont know what this is but it worked.

#### Problem:

I met problems running lombok after having deleted the boilerplate code.

Solution:

Seemed like i had to manually update the dependency. From 1.16.20, to 1.18.20

#### Problem:

In point 6, where I am to create a new project and add the eclipselink files and the derby file, there is no javax.persistence_*.jar file in the downloaded folder:
![no search results for javax](https://user-images.githubusercontent.com/46929671/132701597-e70d0adf-bc6a-4973-ae27-eee5f8e3cc5f.png)

Solution:

Looked at the filestructure from the earlier project and found some of the .jar files that might hold the files that i needed. I then had problems getting intellij to recognise them as libraries. This page helped me here: https://stackoverflow.com/questions/1051640/correct-way-to-add-external-jars-lib-jar-to-an-intellij-idea-project


#### Problem:
![image](https://user-images.githubusercontent.com/46929671/132710479-f36db6a0-e570-463f-b14f-0fde7f568df8.png)
All my junit tests fail at point 6.
I assume that my problem might come from not having copied all of the classes from the earlier project, so ill try to do the rest as well.

So I tried to simply put my classes into the jpl-basic project to see if it then worked. It does not i and get the same error.
![image](https://user-images.githubusercontent.com/46929671/132723366-8571f453-6cce-4042-ac2a-8024bbaf0e13.png)

### After 5 hours of scratching my head and stressing out because of the deadline and being stuck on this stupid problem i can finally present my solution:


    persistence-unit name="people" transaction-type="RESOURCE_LOCAL"
   
     provider org.eclipse.persistence.jpa.PersistenceProvider /provider
     
       class model.Person /class 
       
       class model.Family /class 
       
       class model.Job /class 

By adding this in the pom file, it finaly worked. Couldnt make it look good in the markdown, so it looks a little wonky.
![image](https://user-images.githubusercontent.com/46929671/132726275-a06f2426-6295-4cff-b494-830211a8a400.png)

