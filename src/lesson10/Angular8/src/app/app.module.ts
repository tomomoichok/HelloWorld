import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';


import {HttpClientModule, HttpClientJsonpModule} from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { SampleComponent } from './components/sample/sample.component';
import { UserComponent } from './components/user/user.component';
import { StorageService } from './services/storage.service';
import { Sample2Component } from './components/sample2/sample2.component';
import { Head2Component } from './components/head2/head2.component';
import { Sample3Component } from './components/sample3/sample3.component';
import { BViewComponent } from './components/bview/bview.component';
import { AViewComponent } from './components/aview/aview.component';
import { ABHeadComponent } from './components/abhead/abhead.component';

import { MyNewServiceService } from './services/my-new-service.service';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    SampleComponent,
    UserComponent,
    Sample2Component,
    Head2Component,
    Sample3Component,
    BViewComponent,
    AViewComponent,
    ABHeadComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    HttpClientJsonpModule
  ],
  providers: [StorageService,MyNewServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
