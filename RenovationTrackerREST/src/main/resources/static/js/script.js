window.addEventListener('load', function(e) {
	console.log('script.js loaded');
	init();
});

function init() {

	document.projectForm.lookup.addEventListener('click', function(e) {
		e.preventDefault();
		let projectId = document.projectForm.projectId.value;
		if (!isNaN(projectId) && projectId > 0) {
			getProject(projectId);
			getTasks(projectId);
		}
	});

	document.allProjectForm.findAll.addEventListener('click', function(e) {
		e.preventDefault();
		getAllProjects();
	});

	document.createProjectForm.submit.addEventListener('click', createProject);



}





// ------------------------ END INIT ------------------------------------------



//---------START Create Project --------------------------------------------------
function createProject(e) {
	e.preventDefault();

	let xhr = new XMLHttpRequest();
	xhr.open('POST', 'api/projects', true);

	xhr.setRequestHeader("Content-type", "application/json"); // Specify JSON request body

	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status == 200 || xhr.status == 201) { // Ok or Created
				let data = JSON.parse(xhr.responseText);
				displayProject(data);
			}
			else {
				console.error("POST request failed.");
				console.error(xhr.status + ': ' + xhr.responseText);
			}
		}
	};


	let project = {
		name: document.createProjectForm.name.value,
		description: document.createProjectForm.description.value,
		budget: document.createProjectForm.budget.value,
		imageUrl: document.createProjectForm.imageUrl.value,
		startDate: document.createProjectForm.startDate.value,
		endDate: document.createProjectForm.endDate.value
	};
	xhr.send(JSON.stringify(project));
}

//--- END Start Projects -------------------------------------------------------

//START EDIT PROJECT ------------------------------------------------------------

function createProject(e) {
	e.preventDefault();

	let xhr = new XMLHttpRequest();
	xhr.open('POST', 'api/projects', true);

	xhr.setRequestHeader("Content-type", "application/json"); // Specify JSON request body

	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status == 200 || xhr.status == 201) { // Ok or Created
				let data = JSON.parse(xhr.responseText);
				displayProject(data);
			}
			else {
				console.error("POST request failed.");
				console.error(xhr.status + ': ' + xhr.responseText);
			}
		}
	};


	let project = {
		name: document.createProjectForm.name.value,
		description: document.createProjectForm.description.value,
		budget: document.createProjectForm.budget.value,
		imageUrl: document.createProjectForm.imageUrl.value,
		startDate: document.createProjectForm.startDate.value,
		endDate: document.createProjectForm.endDate.value
	};
	xhr.send(JSON.stringify(project));
}






// START Find project by id & display ----------------------------------------- 

function getProject(projectId) {

	let xhr = new XMLHttpRequest();

	xhr.open('GET', 'api/projects/' + projectId);

	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200) {

				let project = JSON.parse(xhr.responseText);
				console.log(project);
				displayProject(project);
			} else {
				console.log('Project not found')
			}
		}
	};
	xhr.send();
}

function displayProject(project) {
	let dataDiv = document.getElementById('projectData');
	dataDiv.textContent = '';
	let h1 = document.createElement('h1');
	h1.textContent = project.name;
	dataDiv.appendChild(h1);


}

//END Find by id & disply -------------------------------------------------------------

// Start GET All Projects ------------------------------------------------------------

function getAllProjects() {

	let xhr = new XMLHttpRequest();

	xhr.open('GET', 'api/projects');

	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200) {
				let projects = JSON.parse(xhr.responseText);
				displayAllProjects(projects);
			} else {
				console.log('Projects not found')
			}
		}
	};
	xhr.send();
}

function displayAllProjects(projects) {
	let div = document.getElementById('findAllData');
	div.textContent = '';

	let title = document.createElement('h2'); 
	title.textContent = "All Projects";
	div.appendChild(title); 
	
	let table = document.createElement('table');
	table.id = 'projectTable';
	
	let thead = document.createElement('thead');
	
	
	
	for(p in projects[0]) {
		let th = document.createElement('th');
		th.textContent = p; 
		thead.appendChild(th); 
		}
		
		
		table.appendChild(thead); 
	

		
		let tBody = document.createElement('tbody'); 

	
	
	projects.forEach(function(val) {
		let tr = document.createElement('tr');
		
		let id = document.createElement('td'); 
		
		let name = document.createElement('td'); 
		
		let description = document.createElement('td'); 
		
		let budget = document.createElement('td'); 
		
		let imageUrl = document.createElement('td'); 
		
		let startDate = document.createElement('td'); 
		let endDate = document.createElement('td'); 
		let createdAt = document.createElement('td'); 
		
		
		
		id.textContent = val.id; 
		name.textContent = val.name; 
		description.textContent = val.description; 
		budget.textContent = val.budget; 
		imageUrl.textContent = val.imageUrl; 
		startDate.textContent = val.startDate; 
		endDate.textContent = val.endDate; 
		createdAt.textContent = val.createdAt; 
		
		
		tr.appendChild(id);
		tr.appendChild(name);
		tr.appendChild(description); 
		tr.appendChild(budget); 
		tr.appendChild(imageUrl); 
		tr.appendChild(startDate); 
		tr.appendChild(endDate); 
		tr.appendChild(createdAt); 
		
		
		let editButton = document.createElement('button');
		editButton.textContent = 'Edit'; 
		tr.appendChild(editButton);
		
		
		tBody.append(tr); 
		
		
	});
	
	table.appendChild(tBody); 
	div.appendChild(table); 
	
	let br = document.createElement('br');
	table.appendChild(br); 
	
	document.getElementById('button').Edit.addEventListener('click', updateProject);
	
	

	}
	
//------START Get Project Tasks -------
function getTasks(projectId) {

  let xhr = new XMLHttpRequest();

  xhr.open('GET', 'api/project/' + projectId + '/tasks');

  xhr.onreadystatechange = function() {
    if (xhr.readyState === 4) {
      if (xhr.status === 200) {
        
        let tasks = JSON.parse(xhr.responseText);
          console.log(tasks);
          displayTasks(tasks);
        } else {
        console.log('No tasks found not found')
      }
    }
  };
  xhr.send();
}

function displayTasks(tasks) {
  let taskDiv = document.getElementById('taskData');
  taskDiv.textContent = '';
  
  let ul = document.createElement('ul');
  taskDiv.appendChild(ul); 
  
  
  for (var i = 0; i < tasks.length; i++) {
  let list = document.createElement('li');
  list.textContent = tasks[i].name + ' ' + tasks[i].startDate; 
  ul.appendChild(list); 
}
}
