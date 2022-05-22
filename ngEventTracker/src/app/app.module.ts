
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EventComponent } from './components/event/event.component';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import { AboutComponent } from './components/about/about.component';
import { HomeComponent } from './components/home/home.component';
import { ProjectsComponent } from './components/project/project.component';
import { DatePipe } from '@angular/common';
import { ProjectsService } from './services/projects.service';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { IncompletePipe } from './pipes/incomplete.pipe';



@NgModule({
  declarations: [
    AppComponent,
    EventComponent,
    NavBarComponent,
    AboutComponent,
    HomeComponent,
    ProjectsComponent,
    IncompletePipe

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    NgbModule
  ],
  providers: [
    ProjectsService,
    DatePipe,
    IncompletePipe
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
