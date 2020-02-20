import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AgmCoreModule } from '@agm/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http'
import { DataService } from './data.service';
import { PlusPipe } from './plus.pipe';


@NgModule({
  declarations: [
    AppComponent,
    PlusPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyDpcB8Oy8uGSnh4TWE2Z-ifM02gfInRIAs'
    })
  ],
  providers: [DataService],
  bootstrap: [AppComponent]
})
export class AppModule {
  
 }

