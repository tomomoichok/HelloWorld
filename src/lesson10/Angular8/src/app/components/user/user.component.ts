import { Component, OnInit } from '@angular/core';

import {MyNewServiceService} from '../../services/my-new-service.service'
@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  //servObj = new MyNewServiceService();

  constructor(private servObj:MyNewServiceService) { }

  userName = "";
  userAge :any;
  userAddress = "";
  userList = [];
  dataList:any;
  
  ngOnInit(): void {
    this.dataList = this.servObj.getItem("userData");
    if(this.dataList ){
         this.userList = this.dataList ;
    }
    // let rowData = {
    //     name:'テストユーザ',
    //     age:20,
    //     address:'東京'
    // };
    // this.userList.push(rowData);
  }
  
  addUserInfo(){
    if(this.userName=="") {
      alert('ユーザ名を入力してください。');
      return false;
    }
    //alert('1111111111');
    let rowData = {
        name:this.userName,
        age:this.userAge,
        address:this.userAddress
    };
   // console.log("11111111");
    this.userList.push(rowData);
    this.userName="";
    this.userAge ="";
    this.userAddress="";

    this.servObj.setItem("userData",this.userList);
    // console.log(this.userList);
  }

}
