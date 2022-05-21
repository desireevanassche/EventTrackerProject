import { Project } from '../models/project';
import { DatePipe } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';



@Injectable({
  providedIn: 'root'
})
export class ProjectsService {

  constructor(private http: HttpClient, private datePipe: DatePipe) { }


  private baseUrl = 'http://localhost:8084/';
  private url = this.baseUrl + 'api/projects';

  index() {
    return this.http.get<Project[]>(this.url)
      .pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError ('KABOOM');
        })
      );
  }


  create(newProject: Project){
  // newProject.completed = false;
  return this.http.post<Project>(this.url, newProject).pipe(
    catchError((err: any) => {
      console.log(err);
      return throwError('KABOOM');

    }
    )
  )
  }
  destroy(id: number) {
    return this.http.delete<void>(this.url + "/" + id).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('ProjectService: error retrieving todo list');

      })
    )
  }

  update(updateProject: Project) {
    if(updateProject.completed) {
      let tempDate = this.datePipe.transform(Date.now(), 'shortDate');
      if(tempDate !== null) {
        updateProject.endDate =  tempDate;
      }

    } else {
      updateProject.endDate = '';
    }
    return this.http.put<Project>(this.url + "/" + updateProject.id, updateProject).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('KABOOM');
      })
    );
  }
  public show(id:number){
    return this.http.get<Project>(this.url + "/" + id)
    .pipe(
      catchError((err:any)=>{
        return throwError('Check this- KABOOM!')
      })
    )
  }


}
