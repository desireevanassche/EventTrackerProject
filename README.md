# EventTrackerProject
Created by: Desiree VanAssche

## Project Overview

### User Overview
This application allows contractors and DIY'ers to plan, organize, and track home and commercial renovation projects. A renovation has many moving parts and a "Project" such as a complete kitchen overhaul, replacement of a vanity in a bathroom, or even just painting an accent wall in the living room takes immense planning, consideration, and budgeting. This application takes the guess work out of what comes next and allows the user to assign a list "Tasks" to each individual project. A Project has a start date, end date, inspiration photo, budget, and a list list tasks necessary to complete a project. The tasks themselves also include start and end dates helping those using the app stay on schedule and organized.

### Development Overview Phase 1
This is a three part project, in part one of this project I have created only the back end. Testing the functionality of the back end with Junit test, and the REST endpoints in the tables below. This phase of the project is focused on CRUD operations. In order to validate the schema I turned to the single source of truth when writing my tests as well as end point routes, the database. While running these operations I kept a terminal window open that was logged onto the database as well as the Postman application. To verify that the Project and Task controllers were working properly I would validate the response from the post man route by check it again the database. Had the database performed the crud operation as is should and the Postman show the correct result, then I would move onto the next route. This phase was incredibly fun and boosted my back end confidence quite a bit.


### Learning Objectives

* Create a JPA Project
    * Create a Java entity class POJO that models your database table.
    *  Map your POJO using JPA.

* Configure a Spring Boot app to publish a REST API.
    * Use Spring REST annotations.
    * Use Spring Data JPA to perform all CRUD operations.
    * Send and receive JSON.



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
