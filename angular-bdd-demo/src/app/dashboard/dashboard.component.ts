import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  movies = []
  mostPopular = {
    movieName: 'test',
    viewStat: 99
  }

  constructor() { }

  ngOnInit() {
  }

}
