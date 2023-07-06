# EDAG-Teszt-Torok-Zsolt
Edag company's test for a successful job application


Java Backend application:

Install the JDK:
In order to start the back-end application you need to install the Oracle Java.
(For help Java installation see this page: https://www.java.com/en/ )

Starting the application:
When the installation of th Java is successfuly done, you can start the app.
On Windows OS for starting the app run the "start.bat" file
which you find in the main directory of the app.

Testing the application:
You have to install a program which capale of sending HTTP requests. (e.g. Postman, download: https://www.postman.com/)

For filling up the database with the JSON text included in the task description file (Webfejlesztés_Teszt_HU.docx), send a 'POST request' to the following endpoint.
http://localhost:8080/api/department/create

You can also test how the application returns the data, send a 'GET request' to the next url:
http://localhost:8080/api/department/findAll


Angular Frontend application:

Install all required programs:
NodeJS:
In order to start the front-end application you need to download and install the NodeJS.
(For help download and install NodeJS, see the following page: https://nodejs.org/en/download)

Angular ClI:
When you finished the installation of the NodeJS, open a console on your computer and install the Angular from Node Package Manager (npm)
Type into the console and run the following command: "npm install -g @angular/cli"
(For help installing Angular, see the relevant page: "https://angular.io/guide/setup-local")

Starting Angular application:
To start the frontend application go to the next folder ../Angular-FE-user-management-app/
In this folder run the following commands in the terminal window to generate the requred dependecies. "npm i"
When this command finished, run the next command to start the app: "npm run start"

Testing the app:
When the app start properly, open your browser (e.g. Google Chrome) and navigate to "http://localhost:4200/" page.


Enjoy the program.


