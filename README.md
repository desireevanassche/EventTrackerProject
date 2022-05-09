# EventTrackerProject
Created by: Desiree VanAssche

### Overview

### Routes

## Project Routes
| Return Type       | Route                                 | CRUD Functionality               |
|------------------ | ------------------------------------- |----------------------------------|
| 'List<Project>'   | 'GET api/projects'                    | Read all projects                |
| 'List<Project>'   | 'GET api/projects/search/{keyword}'   | Read all projects by keyword     |
| 'Project'         | 'GET api/projects/{id}'               | Read a project by id             |
| 'Project'         | 'POST api/projects                    | Create a project                 |
| 'Void'            | 'DELETE api/ projects/{id}'           | Delete a project by id           |
| 'Project'         | 'PUT projects/{id}'                   | Update a project by id           |


## Task Routes
| Return Type       | Route                                      | CRUD Functionality                |
|------------------ | ------------------------------------------ | ----------------------------------|
| 'List <Task>'     | 'GET api/tasks'                            | Read all tasks                    |
| 'List <Task>'     | 'GET projects/{projectId}/tasks'           | Read all tasks by keyword         |
| 'List <Task>'     | 'GET tasks/search/{keyword}'               | Read all project tasks by id      |
| 'Task'            | 'POST projects/{projectId}/tasks/{taskId}' | Create a project task             |
| 'Void'            | 'DELETE api/ projects/{id}'                | Delete a project by id            |
| 'Task'            | 'PUT projects/{projectId}/tasks/{taskId}'  | Update a project task             |
