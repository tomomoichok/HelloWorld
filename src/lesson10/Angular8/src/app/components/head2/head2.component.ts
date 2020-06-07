import { Component, OnInit ,Input,Output,EventEmitter} from '@angular/core';

@Component({
  selector: 'app-head2',
  templateUrl: './head2.component.html',
  styleUrls: ['./head2.component.css']
})
export class Head2Component implements OnInit {

  @Input() msg:string;
  @Input() addIndex;

  @Output() outer = new EventEmitter<string>();

  tmpIndex = 0;
  constructor() { }

  ngOnInit(): void {
  }

 callAddIndex() {
   this.tmpIndex += 1;
   this.addIndex(this.tmpIndex);
 }

 sendMessage() {
   this.outer.emit('hello world1111!');
 }

 callChid(tmpIndex) {
   alert('head message'+tmpIndex);
 }
 callOtherMethod(){
   alert('callOtherMethod');
 }

}
