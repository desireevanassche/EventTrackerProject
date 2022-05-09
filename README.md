# EventTrackerProject
Created by: Desiree VanAssche

### Overview

### Routes

| Return Type       | Route                                | CRUD Functionality             |
|------------------ | ------------------------------------- |----------------------------------|
| 'List<Project>'   | 'GET api/projects'                    | Read all projects           |
|------------------ | ------------------------------------- |-----------------------------------|
| 'List<Project>'   | 'GET api/projects/search/{keyword}'   | Read all projects by keyword|
|------------------ | ------------------------------------- |-------------------------------|
| 'List Project'    | 'GET api/projects/{id}'               | Read a project by id      |
|------------------ | ------------------------------------- |-------------------------------|
| 'Project'         | 'POST api/projects                    | Create a project              |
|------------------ | ------------------------------------- | ------------------------------|
| 'Void'            | 'DELETE api/ projects/{id}'           |        |
|------------------ | ------------------------------------- | -------------------------------|
