## Running the Application

To run the project from the root folder use the following command - </br>
` ./gradlew clean build bootRun`  - This will clean, build and run the spring boot application. </br>
   If the commands are executed properly the application should start running the tomcat server at port `8080`

## Ngrok
To let Github hit your endpoint (here `/webhook`), we need to host the localhost such that it can be accessed remotely.</br>
Ngrok allows us to tunnel the locahlhost server and hosts it, so that it can be accessed remotely.</br>
Use the following command for tunneling - `ngrok http 8080`

## Github WebHooks
To test whether the application is working correctly, we need to create webhooks in the `"dummy-github-events"` repository.
For now, I have created the webhook that sends details of any activity to `${url from ngrok}/webhook`. 