import { Component, OnInit,ViewChild } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-bview',
  templateUrl: './bview.component.html',
  styleUrls: ['./bview.component.css']
})
export class BViewComponent implements OnInit {

  constructor(private rout:Router) { }
  bFlag="*B画面*";  
  @ViewChild('abc')  aaaa;
  ngOnInit(): void {
  }

  bMethod(){
    alert('bbbbbbbb1111')
  }
  
  bCall(msg1:string) {
    alert(msg1);
  }


  Hai() {
    this.aaaa.callHeadMethod();
  }

  A(){
    this.rout.navigate(['/aview']);
  }
}
