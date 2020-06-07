import { Component, OnInit,ViewChild } from '@angular/core';

@Component({
  selector: 'app-aview',
  templateUrl: './aview.component.html',
  styleUrls: ['./aview.component.css']
})
export class AViewComponent implements OnInit {

  constructor() { }
  headFlag="--A画面--";
  @ViewChild('subObj') sub;
  ngOnInit(): void {
  }

  callAMethod(){
    alert('a method333333333333333');
  }


  callA(msg:string){
       alert(msg);
  }

  callSubObj(){
    //  alert(this.sub.subMessag);
    this.sub.callHeadMethod();
  }

}
