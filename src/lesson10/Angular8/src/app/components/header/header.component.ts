import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header-1',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  userName="一郎";
  userName2:any;
  userName3:string;
  title="title message";
  htmlstr="<h1>html code</h1>";
  dataList=[];
  dataObjectList = [];
  dataArrayList = [];
  visFlag = true;

  inText="テストデータ"

  dataObj = {
    name:'大郎',
    age:30,
    address:'日本'
  }
  constructor() { 
     this.dataList = ['1111','22222','33333'];
     this.dataObjectList = [
       {name:'一郎',age:20,address:'東京'}
       ,{name:'次郎',age:25,address:'千葉県'}
      ,{name:'三郎',age:30,address:'神奈川県'}
      ,{name:'大郎',age:21,address:'東京'}
      ,{name:'郎郎',age:22,address:'東京'}
     ];
  }

  ngOnInit(): void {
    this.userName="111";
    this.userName3="次郎";
    this.userName2=2222;


    this.dataArrayList=[
      {name:1111,data:['a1','a2','a3']},
 {name:2222,data:['b1','b2','b3']},
 {name:3333,data:['c1','c2','c3']},
 {name:4444,data:['d1','d2','d3']},
 {name:5555,data:['e1','e2','e3']},
  {name:6666,data:['f1','f2','f3']},
    ];
  }

  setVis(){
     this.visFlag = !this.visFlag;
  }

  keyTest(e) {
    console.log(e);
  }

  setInText(){
    this.inText="変更内容";
  }
}
