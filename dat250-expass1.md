# DAT250Lab1
First lab of dat250



Problems with running HelloWorld application in Intellij after installation:

Intellij would not give me the run application option, and the run-configuration would not allow me to select my HelloWorld-class as the main class to run.
So i restarted the Intellij. I rewrote the code. And like magic, I was allowed to run the application.


Creating account Heroku:

After creating my account and validating my email, Heroku tells me that my account credidentials are invalid.
I closed the browser and went to the official Heroku site again, end then it worked.


PostgreSQL:

I was not able to use the commands even after doing the install and adding "C:\Program Files\PostgreSQL\13\bin" to PATH.
![envpic](https://user-images.githubusercontent.com/46929671/132041478-c9fc34eb-3a45-46f0-aed0-006e2db93f13.png)
![filepic](https://user-images.githubusercontent.com/46929671/132041697-16468d5d-ddfb-4741-b1a4-ecbe6e787ea0.png)
It seems that when i added the PATH of PostgreSQL i managed to delete the Heroku path, putting this back in made it work.


I then ran into another problem:
![probpic](https://user-images.githubusercontent.com/46929671/132044738-e4703c32-7926-4d54-9e55-ebd32c7d07d8.png)

Solved by simply typing "chcp 1252" into powershell before doing the command. Credit to various people at: https://stackoverflow.com/questions/20794035/postgresql-warning-console-code-page-437-differs-from-windows-code-page-125


