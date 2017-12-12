import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';


import { FormsModule }   from '@angular/forms';//New 
import { HttpModule }    from '@angular/http';//New

import { AppComponent } from './app.component';
import { ArticleListComponent } from './article-list.component';//New
import { ArticleService } from './article.service';//New

import {MatDatepickerModule,MatNativeDateModule,MatFormFieldModule,MatInputModule} from '@angular/material';
//import { DatePickerModule } from 'angular-material-datepicker';

import {MomentDateAdapter} from '@angular/material-moment-adapter';
import {DateAdapter, MAT_DATE_FORMATS, MAT_DATE_LOCALE} from '@angular/material/core';


import { DateTimePickerModule } from 'ng-pick-datetime';

export const MY_FORMATS = {
  arse: {
    dateInput: 'YYYY/MM/DD'
  },
  display: {
    dateInput: 'YYYY/MM/DD',
    monthYearLabel: 'MMMM Y',
    dateA11yLabel: 'LL',
    monthYearA11yLabel: 'MMMM Y'
  }
};

@NgModule({
  declarations: [
    AppComponent,
    ArticleListComponent //New
  ],
  imports: [
  	BrowserModule,
  	DateTimePickerModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatFormFieldModule,
    MatInputModule,
    BrowserAnimationsModule,
    FormsModule, //New
	HttpModule //New
  ],
  providers: [ArticleService,
  	  {provide: DateAdapter, useClass: MomentDateAdapter, deps: [MAT_DATE_LOCALE]},
	  {provide: MAT_DATE_FORMATS, useValue: MY_FORMATS},
  ],//New
  bootstrap: [AppComponent]
})
export class AppModule { }
