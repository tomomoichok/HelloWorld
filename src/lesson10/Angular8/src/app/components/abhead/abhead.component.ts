import { Component, OnInit ,Input,Output,EventEmitter} from '@angular/core';

@Component({
  selector: 'app-abhead',
  templateUrl: './abhead.component.html',
  styleUrls: ['./abhead.component.css']
})
export class ABHeadComponent implements OnInit {

 @Input() title:string;
 @Input() caMethod:any;
 @Output() subOut = new EventEmitter<string>();


 subMessag ="head message";
 constructor() { }

  ngOnInit(): void {
  }

  callMethod() {
    //alert('11111');
    this.caMethod();
  }

  callOut(){
      this.subOut.emit(this.title);
  }

  callHeadMethod(){
    alert('callHeadMethod@@@@@@@');
  }

}
