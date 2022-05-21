
import { ProjectsService } from '../../services/projects.service';
import { Component, OnInit } from '@angular/core';
import { Project } from 'src/app/models/project';
import { IncompletePipe } from './../../pipes/incomplete.pipe';

@Component({
  selector: 'app-projects',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.css']
})
export class ProjectsComponent implements OnInit {

  title: String = 'ngModel';

  selected: Project | null = null;

  newProject: Project = new Project();

  editProject: Project | null = null;

  showComplete: boolean = false;

  projects: Project[] = [];

  constructor(private projSvc: ProjectsService, private incompletePipe: IncompletePipe) { }

  ngOnInit(): void {
  this.reload();
  }



  getNumOfProjects() {
    return this.incompletePipe.transform(this.projects, this.showComplete).length;
  }

  displayProject(project: Project) {
    this.selected = project;
  }

  displayTable(){
    this.selected = null;
  }

  addProject(formProject: Project) {
    this.projSvc.create(formProject).subscribe(
      data => {
        this.reload();
        this.newProject = new Project();
      },
      err => console.log(err)
    );
  }

  setEditProject() {
    this.editProject = Object.assign({}, this.selected);
  }

  updateProject(project: Project){
    this.projSvc.update(project).subscribe(
      data => {
        this.reload();
        this.selected = null;
        this.editProject = null;
      }
    );
  }

   deleteProject(id: number) {
    this.projSvc.destroy(id).subscribe(
      data => this.reload(),
      err => console.log(err)
    );
  }

  reload() {
    this.projSvc.index().subscribe(
      data => this.projects = data,
      err => console.log(err)
    );
  }

}
