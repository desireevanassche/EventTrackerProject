import { Pipe, PipeTransform } from '@angular/core';
import { Project } from 'src/app/models/project';


@Pipe({
  name: 'incomplete'
})
export class IncompletePipe implements PipeTransform {

  transform(projects: Project[], showAll: boolean): Project[]{

    if(showAll) {
      return projects;
    }

    let result: Project[] = [];
    projects.forEach((project, index, arr) => {
      if(!project.completed) {
        result.push(project);
      }
    });

    return result;
  }

}
