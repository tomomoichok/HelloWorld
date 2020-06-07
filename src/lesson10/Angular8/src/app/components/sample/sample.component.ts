import { Component, OnInit } from '@angular/core';
import { StorageService } from '../../services/storage.service';  
import {HttpClient,HttpHeaders } from '@angular/common/http';
// import {catchError, map,timeout} from 'rxjs/operators';
import {throwError} from 'rxjs';
import { concat, merge, zip, combineLatest, race } from 'rxjs/index';
// import { filter, map, startWith,  } from 'rxjs/internal/operators';

@Component({
  selector: 'app-sample',
  templateUrl: './sample.component.html',
  styleUrls: ['./sample.component.css']
})
export class SampleComponent implements OnInit {
    userName : any;
    userNameList = [];
  private headers = new HttpHeaders({'Content-Type': 'application/json'});
  constructor(private store : StorageService,private http : HttpClient) { 
        // http.response.setHeader("Access-Control-Allow-Origin",  request.getHeader("Origin"));
        // response.setHeader("Access-Control-Allow-Credentials", "true");
        // response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");  
        // response.setHeader("Access-Control-Allow-Headers", "x-requested-with, Content-Type");  

  }

  ngOnInit(): void {
      this.userName ="";

  }
  addUserName() {
     this.userNameList.push(this.userName);
     this.userName="";
     this.store.setItem("list",this.userNameList);
     console.log(this.userNameList);
  }

  getUserName() {
    this.userNameList = this.store.getItem("list");
  }

  getUserInfHttpGet(){
    const url = 'http://localhost:8080/test-demo/search';
    let param = {name: 'tttt',pwd:'123456'};
   // const url ="http://www.phonegap100.com/appapi.php?a=getPortalList&catid=20&page=1"
    this.http.get<any>(url,{params:param}).subscribe(
        function(data) {
            console.log("@@@@@@@@@@@@@@@@@@@@@@@@");
            console.log(data);
        },
        function(err) {
            console.log('################');
            console.log(err);
        }
    );
  }

  getUserInfHttpPost(){
    const url = 'http://localhost:8080/test-demo/searchPost';
   // const url ="http://www.phonegap100.com/appapi.php?a=getPortalList&catid=20&page=1"
    this.http.post(url,
     JSON.stringify({name:'tttt',pwd:'123456'}),
     {headers:this.headers}
    ).subscribe(
        function(data) {
            console.log("@@@@@@@@@@@@@@@@@@@@@@@@");
            console.log(data);
        },
        function(err) {
            console.log('################');
            console.log(err);
        }
    );
  }

  	getUserInfJSONP() {
        //   const url = 'http://localhost:8080/test-demo/searchJsonp?name=tttt&pwd=123456789';
        //const url = 'http://localhost:8080/test-demo/searchJsonp?name=tttt&pwd=123456789';
	    const url = "http://www.phonegap100.com/appapi.php?a=getPortalList&catid=20&page=1";
        this.http.jsonp<any>(url, "callback").subscribe(
            function(data) {
                console.log("OK");
                console.log(data);
            },
            function(err) {
                console.log('err');
                console.log(err);
            }
        );
	 }
	
}
