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
	let updateDiv = document.getElementById('projectData');
	updateDiv.textContent = '';

	/* let h1 = document.createElement('h1');
	h1.textContent = project.name;
	dataDiv.appendChild(h1);  */

	while (updateDiv.firstElementChild) {
		updateDiv.removeElement(findAllData.firstElementChild);
	}

	let name = document.createElement('h1');
	updateDiv.appendChild(name);
	name.textContent = 'Project Name: ' + project.name;

	let projectInfo = document.createElement('ul');
	updateDiv.appendChild(projectInfo);

	let description = document.createElement('li');
	updateDiv.appendChild(description);
	description.textContent = 'Description: ' + project.description;

	let budget = document.createElement('li');
	updateDiv.appendChild(budget);
	budget.textContent = 'Budget: ' + project.budget;

	let imageUrl = document.createElement('li');
	updateDiv.appendChild(imageUrl);
	imageUrl.textContent = 'Image Url' + project.imageUrl;

	let startDate = document.createElement('li');
	updateDiv.appendChild(startDate);
	startDate.textContent = 'Start Date: ' + project.startDate;

	let endDate = document.createElement('li');
	updateDiv.appendChild(endDate);
	endDate.textContent = 'Start Date: ' + project.endDate;


	let updateForm = document.createElement('form');
	updateDiv.appendChild(updateForm);

	var updateBtn = document.createElement('button');
	updateDiv.appendChild(updateBtn);

	updateBtn.name = "update";
	updateBtn.textContent = "update";

	updateBtn.addEventListener('click', function(e) {
		e.preventDefault();
		projectUpdateForm(project);
	});
	//add a function call / event listener to delete the project here 


	let deleteProjectForm = document.createElement('form');
		 updateDiv.appendChild(deleteProjectForm);

		var deleteProjectButton = document.createElement('button');
		 updateDiv.appendChild(deleteProjectButton);
		
		deleteProjectButton.name = 'deleteProjectButton';
		deleteProjectButton.textContent = 'Delete';

		deleteProjectForm.deleteProjectButton.addEventListener('click', function(event) {
			event.preventDefault();
			deleteProject(project.id);

});

}

//---------Delete Project --------------------------
function deleteProject(projectId) {
	let xhr = new XMLHttpRequest();

	xhr.open('DELETE', 'api/projects/' + projectId);

	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status == 200 || xhr.status == 204) {
				let deleteProjectDiv = document.getElementById('deleteProject');
				deleteProjectDiv.textContent = '';
				let deleteVerification = document.createElement('h2');
				deleteVerification.textContent = "Sucessfully Deleted Project: " + projectId;
				deleteProjectDiv.appendChild(deleteVerification);

			}
			else {
				console.error("POST request failed.");
				console.error(xhr.status + ': ' + xhr.responseText);
				console.log('Project not deleted');
				let deleteVerification = document.getElementById('deleteProject');
				deleteVerification.textContent = 'Unsucessfully deletion attempt, please try again';
				deleteProjectDiv.appendChild(deleteVerification);


			};
			xhr.send();
		}
	}
}


// ----------- Update Form ------------------------
function projectUpdateForm(project) {

	let findAllData = document.getElementById('findAllData');
	findAllData.textContent = '';

	let updateH3 = document.createElement('h3');
	updateH3.textContent = 'Update Project: ' + project.name;
	findAllData.appendChild(updateH3);

	let formContainer = document.createElement('div');
	findAllData.appendChild(formContainer);

	let updateProjectForm = document.createElement('form');
	updateProjectForm.name = 'updateProjectForm';
	findAllData.appendChild(updateProjectForm);

	let newProjectName = document.createElement('input');
	newProjectName.type = 'text';
	newProjectName.name = 'name';
	newProjectName.placeholder = project.name;
	updateProjectForm.appendChild(newProjectName);

	let newProjectDesc = document.createElement('input');
	newProjectDesc.type = 'text';
	newProjectDesc.name = 'description';
	newProjectDesc.placeholder = project.description;
	updateProjectForm.appendChild(newProjectDesc);

	let newProjectBudget = document.createElement('input');
	newProjectBudget.type = 'text';
	newProjectBudget.name = 'budget';
	newProjectBudget.placeholder = project.budget;
	updateProjectForm.appendChild(newProjectBudget);

	let newProjectImageUrl = document.createElement('input');
	newProjectImageUrl.type = 'text';
	newProjectImageUrl.name = 'imageUrl';
	newProjectImageUrl.placeholder = project.imageUrl;
	updateProjectForm.appendChild(newProjectImageUrl);

	let newProjectStartDate = document.createElement('input');
	newProjectStartDate.type = 'text';
	newProjectStartDate.name = 'startDate';
	newProjectStartDate.placeholder = project.startDate;
	updateProjectForm.appendChild(newProjectStartDate);

	let newProjectEndDate = document.createElement('input');
	newProjectEndDate.type = 'text';
	newProjectEndDate.name = 'endDate';
	newProjectEndDate.placeholder = project.endDate;
	updateProjectForm.appendChild(newProjectEndDate);

	let updateFormButton = document.createElement('button');
	updateFormButton.id = 'updateFormButton';
	updateFormButton.innerHtml = 'Update Project';
	updateProjectForm.appendChild(updateFormButton);

	updateProjectForm.updateFormButton.addEventListener('click', function(e) {
		e.preventDefault();
		updateProject(project);
	});
}

//START Update PROJECT ------------------------------------------------------------



function updateProject(project) {

	let xhr = new XMLHttpRequest();
	xhr.open('PUT', 'api/projects/' + project.id, true);

	xhr.setRequestHeader("Content-type", "application/json");

	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status == 200 || xhr.status == 201) {
				let updatedProject = JSON.parse(xhr.responseText);
				displayProject(updatedProject);
			}
			else {
				console.error("Put request failed.");
				console.error(xhr.status + ': ' + xhr.responseText);
			}
		}
	};


	let updatedProject = {
		name: document.updateProjectForm.name.value,
		description: document.updateProjectForm.description.value,
		budget: document.updateProjectForm.budget.value,
		imageUrl: document.updateProjectForm.imageUrl.value,
		startDate: document.updateProjectForm.startDate.value,
		endDate: document.updateProjectForm.endDate.value
	};
	xhr.send(JSON.stringify(updatedProject));
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



	for (p in projects[0]) {
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




		tBody.append(tr);

	


	});



	table.appendChild(tBody);
	div.appendChild(table);

	let br = document.createElement('br');
	table.appendChild(br);




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
		list.textContent = tasks[i].name + ' ' + tasks[i].startDate
		ul.appendChild(list);
	}
}
