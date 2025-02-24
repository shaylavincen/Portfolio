# Shayla Vincent's ePortfolio
## Introduction
Software Developer. Graduated from SNHU 2025. 
## Artifact
### Grazioso Salvare Animal Application - Full Stack Web Application
This is a single-page application where users can view the animals in a database. It is currently a work in progress and additional functionality will be enabled later. The user will eventually be able to add, update, and delete animals via the website. The user must now use Postman (or a similar application) to add, update, or delete animals. Additional user interface designs, such as adding a picture to the animal card, will be implemented in the future. There will be additional functionality added to demonstrate the ability to filter and sort objects in the future. Some commented-out code can be seen in the artifact in place of future additional functions.

Please see the link for the GitHub Repository for the artifact:
[Grazioso Salvare Animal Application](https://github.com/shaylavincen/Animal-Application)


## Narratives

#### Software Design/Engineering:
  The artifact that I have chosen to improve through the course of this class is the final project that I created in the class CS340. It is a program that generates reports of database information. MongoDB is used to hold this information in a database. The information that the database contains is dog attributes such as age, sex, name, etc. The project aimed to cater to a client, Grazioso Salvare. The program was created in Jupyter Notebook and was developed in Python. I completed the project in June 2024. 
  I originally chose to include this artifact in my portfolio to fulfill the database category requirement. Since the main topic of the project was server/database development. Now I am using this one artifact as the basis of a much larger and more involved project. I have chosen to pursue the creation of a full-stack web application using the CS340 project as the foundation. After the improved project is completed, it will also fulfill the other two categories: software design/engineering, and algorithms/data structures. I will focus on improving this one artifact for the whole course. I have decided to do this to get more experience with real-life work that I am likely to encounter. I feel that I did not get a good grasp of making a web application in the last course, CS465, so I want to try my hand at it. I will be using MongoDB, Express, and React to develop this application. I chose React instead of Angular(used in CS465) because it is much more widely used and I would like a chance to learn it. 
	I have overhauled the enhancement plan that I created in Module One. I was having a difficult time deciding on enhancements that would meet the level required. That’s when I thought of developing my full-stack application using previous work as a starting place. This would cover each category and I could focus on one artifact. This is not to say I will not update other artifacts in the future. 
	I have already learned a great deal from setting up my application in Visual Studio Code. I have generated the backend framework and the frontend has been initialized. I have also discovered and implemented a docker-compose yaml file to run my MongoDB database. This makes it easy to start the database. I was having a lot of trouble trying to set up the MongoDB database. I couldn’t remember how to make a user and then set a username and password. As I was searching how to run the database I stumbled upon many articles suggesting the use of Docker. I have linked them at the bottom. This benefitted me by making it easy to set up the username and password for authentication. 
	I still have a long way to go before this application is ready but I have made some progress towards completing it.
#### Algorithms and Data Structures:
  As I mentioned in the last milestone, the artifact that I have chosen to improve through the course of this class is the final project that I created in the class CS340. I will be upgrading this project for every milestone. It is a program that generates reports of database information. MongoDB is used to hold this information in a database. The information that the database contains is dog attributes such as age, sex, name, etc. The project aimed to cater to a client, Grazioso Salvare. The program was created in Jupyter Notebook and was developed in Python. I completed the project in June 2024. 
	I chose this item for a couple of reasons. I originally selected it because it was an interesting topic to me. I am very interested in the field of service animals and that is what the database was aimed to cater to. I wanted to see how I could expand upon it, to make it useful to a real client. Another reason was that creating an application based on the CS340 project would hit every category required by the final project in this course. It has a database component, data structures, and software design. I have just about completed setting up the database component and am working on the software design and data structures. 
	In this milestone, I started implementing the CRUD operations in the backend. I finished setting up the framework for the routes and controllers needed for the said operations. I even tested the get and post methods to see if they connected to the URL and the database. I tested the get method by returning an empty list in the web browser. I then tested the post method by hardcoding some data in and using Postman to enact the method. I also checked my MongoDB database in MongoCompass and saw the document in the correct collection. The next step will be setting up the put and delete methods. Then instead of hardcoding the information I will have it access the database directly. 
One item that I struggled with in the beginning was understanding how to initiate an object. In the original Python code, each animal was an object. In this code, I had to create a schema to then connect to the controller, which you can see in the post method. I feel that I learned a lot more about how the controller, model, and route files interact. I even discovered that you don’t technically need a separate controller and a separate route file. I did put them as two different though because it is a better decision design-wise, which is one of our class categories. 

#### Database:
  As we are nearing the end of the course, my web application is beginning to take shape, particularly the backend. I chose to focus on enhancing one artifact during the course period. The artifact was originally the final project of CS340. The project was created to give shape to a mongoDB database. The final project was implemented using Jupyter Notebook and Python. Jupyter Notebook enabled the user to enact filters on the data displayed. I wanted to take this concept and make it customer interactable. I am personally interested in the topic of animals so I wanted to see if I could make something that could be useful to places like animal shelters.  I decided to use Express, MongoDB, and React to create the web application. 
  I have set up the MVC framework in the backend and will start working on the React front end soon. I have created a MongoDB schema for the model that creates an animal object with fields such as name, age, breed, etc. I created a route.js file and interconnected that to the index.js file and the controller.js file. The controller.js file is what I focused on for this milestone. I implemented the CRUD operations (and appropriate comments) that will be needed to interact with the MongoDB database. As I was implementing the basic CRUD operations I also added error handling, this was done to minimize security risks from the program unexpectedly crashing. The handling also helps the developer provide essential information, for example, when a user doesn’t input data for all the required fields when posting a new animal object. 
  Now that the backend’s basics are complete I will implement the React frontend in the next milestones. I am not sure if I will get to add all of the functionality that I will want. I wanted to add more ways for the user to interact with the database in the future; filters such as by age, breed, etc. This might not be possible as the deadline is approaching. My goal is to get the basic website up and able to run basic CRUD commands. Eventually, I will work on enhancing the project further, but that might not happen until after this course is done. 


## Self-Assessment

