import { Component, OnInit,ViewChild } from '@angular/core';

@Component({
  selector: 'app-sample2',
  templateUrl: './sample2.component.html',
  styleUrls: ['./sample2.component.css']
})
export class Sample2Component implements OnInit {
  heardMessag = "head message";
  @ViewChild('headObject') headObj;
  constructor() { }

  ngOnInit(): void {
  }

 public addIndex(tmpIndex) {
   alert(tmpIndex);
 }

  runParam(msgstr:string){
    alert(msgstr)
  } 

  callHeadMethod(){
    this.headObj.callOtherMethod();
    alert(this.headObj.tmpIndex);
  }

}
