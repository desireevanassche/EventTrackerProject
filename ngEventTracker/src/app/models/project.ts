export class Project {
  id: number;
  name: string;
  description: string;
  budget: number;
  imageUrl : string;
  startDate: string;
  endDate: string;
  completed: boolean;

  constructor(id: number = 0,  name: string = "", description: string = "", budget: number = 0, imageUrl : string ="", startDate: string ="", endDate: string ="", completed: boolean = false ) {

    this.id = id;
    this.name = name;
    this.description = description;
    this.budget = budget;
    this.imageUrl = imageUrl;
    this.startDate = startDate;
    this.endDate = endDate;
    this.completed = completed;
  }
}
