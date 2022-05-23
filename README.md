resolve# EventTrackerProject
Created by: Desiree VanAssche

## Project Overview

### User Overview
This application allows contractors and DIY'ers to plan, organize, and track home and commercial renovation projects. A renovation has many moving parts and a "Project" such as a complete kitchen overhaul, replacement of a vanity in a bathroom, or even just painting an accent wall in the living room takes immense planning, consideration, and budgeting. This application takes the guess work out of what comes next and allows the user to assign a list "Tasks" to each individual project. A Project has a start date, end date, inspiration photo, budget, and a list list tasks necessary to complete a project. The tasks themselves also include start and end dates helping those using the app stay on schedule and organized.

### Development Overview Phase 1
This is a three part project, in part one of this project I have created only the back end. Testing the functionality of the back end with Junit test, and the REST endpoints in the tables below. This phase of the project is focused on CRUD operations. In order to validate the schema I turned to the single source of truth when writing my tests as well as end point routes, the database. While running these operations I kept a terminal window open that was logged onto the database as well as the Postman application. To verify that the Project and Task controllers were working properly I would validate the response from the post man route by check it again the database. Had the database performed the crud operation as is should and the Postman show the correct result, then I would move onto the next route. This phase was incredibly fun and boosted my back end confidence quite a bit.

### Phase 2 Javascript
Javascript is utilized to perform CRUD operations using event listeners. An event listener allow the user to Create, Edit, Read, or Delete a Project by manipulation of the DOM. Event listeners are able to aid in the performance of crud operations by attaching an event handler to a specified element.

### Phase 3 Angular
Upon loading this application the user enters the home page. This page is currently blank, but leaves room for me to come back later to design. The navbar has a few options but for now the user should click on the "Projects" section, this will allow the user to perform crud operations, or allow them to Create, Read, Update, or Delete a project.


### Learning Objectives

* Create a JPA Project
    * Create a Java entity class POJO that models your database table.
    *  Map your POJO using JPA.

* Configure a Spring Boot app to publish a REST API.
    * Use Spring REST annotations.
    * Use Spring Data JPA to perform all CRUD operations.
    * Send and receive JSON.

### Technologies Used
* Spring Tool Suite 4
* MySQL
* JUnit
* Apache Tomcat
* Atom
* Potman
* Gradel
* Spring Data JPA  
* REST API
* Send & Recieve JSON
* Angular
* Components
* Directives
* Services
* Asynchronous Requests
* DOM Manipulation



### Database Schema

![Image of MySQL Database Schema](https://github.com/desireevanassche/EventTrackerProject/blob/main/db/ProjectSchema.png)

## Project Routes
| Return Type       | Route                                 | CRUD Functionality               |
|------------------ | ------------------------------------- |----------------------------------|
| `List<Project>`   | `GET api/projects`                    | Read all projects                |
| `List<Project>`   | `GET api/projects/search/{keyword}`   | Read all projects by keyword     |
| `Project`         | `GET api/projects/{id}`               | Read a project by id             |
| `Project`         | `POST api/projects`                   | Create a project                 |
| `Void`            | `DELETE api/ projects/{id}`           | Delete a project by id           |
| `Project`         | `PUT projects/{id}`                   | Update a project by id           |


## Task Routes
| Return Type       | Route                                      | CRUD Functionality                |
|------------------ | ------------------------------------------ | ----------------------------------|
| `List <Task>`     | `GET api/tasks`                            | Read all tasks                    |
| `List <Task>`     | `GET projects/{projectId}/tasks`           | Read all tasks by keyword         |
| `List <Task>`     | `GET tasks/search/{keyword}`               | Read all project tasks by id      |
| `Task`            | `POST projects/{projectId}/tasks/{taskId}` | Create a project task             |
| `Void`            | `DELETE api/ projects/{id}`                | Delete a project by id            |
| `Task`            | `PUT projects/{projectId}/tasks/{taskId}`  | Update a project task             |

## JSON Create a Project
`    {
        "name": "Sring",
        "description": "String",
        "budget": double,
        "imageUrl": "String",
        "startDate": "2022-12-07T00:00:00",
        "endDate": "2022-12-09T00:00:00",
    }`

## JSON Updating a Project
`{
    "id": 3,
    "name": "String - example text",
    "description": "String - example Complete kitchen overhaul with the intention of repurposing as much material as possible",
    "imageUrl": "String url"
}`

## JSON Create a Task
`    {
        "name": "String",
        "description": "String",
        "priorityLevel": int,
        "startDate": "2022-07-07T00:00:00",
        "endDate": null,
        "project": {
            "id": 1
        }
    }`

## JSON Updating a Task
`{
     "name": "String  ",
     "description": "String",
     "priorityLevel": int,
     "startDate": "2022-07-08T00:00:00",
     "endDate": "2022-07-08T00:00:00"
 }`

### Lessons Learned

#### Infinite Recursion
Infinite recursion can be spotted quite quickly if you know what you are looking for. In this project a Project has a list of Tasks and a list of tasks is assigned to a single project. Sloppily, I forgot to add `@JSONIgnore` to my relationship mappings within the entities and quickly spotted this infinite loop when testing in Postman. The Project listed the Tasks which Listed the Project which listed the task and so on. As my instructors showed us a few examples of this, I was able to quickly resolve this issue by adding the proper annotation to my relationship mappings. In order for Jackson to work well it is important that one of the two sides of a relationship is not serialized, this will allow us to avoid infinite recursion.

### Define your Goals
I was unclear with my end goal for the Task routes and that lead to me going back over my work and correcting mistakes. Originally, I had created a method to create a task, willy nilly(as my instructors might say). Meaning that I was creating tasks that were not assigned to a Project object, but after realizing that the goal of this application is to assign tasks to a Project, not simply to have a list of tasks I found myself backtracking and deleting code, to make the correction of creating a task, which would be assigned to a list of task, that belongs to a Project. In order to prevent this from happening again I will be more intentional about my goals for an application and their desired outcome, before writing any code.

### Project Id Cannot Be Null
On my final route I was not receiving the value I was attempting to pass the method from Post man, my end route was right, I had verified that the project and task id both existed in the database but something in my code was not right, and the task I was attempting to update was not changing. A list of task belongs to a Project, and the Project id was not being passed. My update method in the TaskServiceImpl was missing an instance of the project repository, which would allow the application to identify which Project, based upon the passed id and which task, based upon the task id would be updated.
