import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ReactiveFormsModule } from '@angular/forms';
import { MaterialModule } from './material-modules/material.module';

import { AppComponent } from './app.component';
import { MenuBarComponent } from './components/menubar/menubar.component';
import { UserListComponent } from './components/user-list/user-list.component';
import { NewUserComponent } from './components/new-user/new-user.component';
import { HttpClientModule } from '@angular/common/http';
import { FooterbarComponent } from './components/footerbar/footerbar.component';

@NgModule({
  declarations: [
    AppComponent,
    MenuBarComponent,
    UserListComponent,
    NewUserComponent,
    FooterbarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    MaterialModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
