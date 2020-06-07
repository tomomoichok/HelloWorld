import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { UserComponent } from './components/user/user.component';
import { SampleComponent } from './components/sample/sample.component';
import { Sample2Component } from './components/sample2/sample2.component';
import { AViewComponent } from './components/aview/aview.component';
import { BViewComponent } from './components/bview/bview.component';
const routes: Routes = [
  {
    path :'sample',
    component:SampleComponent
  },
  {
    path :'sample2',
    component:Sample2Component
  },
  {
    path :'user',
    component:UserComponent
  },
  {
    path :'aview',
    component:AViewComponent
  },  {
    path :'bview',
    component:BViewComponent
  },

  {
    path:'',
    redirectTo:'user',
    pathMatch:'full'
  }
  ,
    {
    path :'**',
   // component:SampleComponent
        redirectTo:'sample'
  }
   

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
