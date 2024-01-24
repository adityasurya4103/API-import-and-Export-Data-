import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FileUploadComponent } from './file-upload/file-upload.component';
import { LoginComponent } from './login/login.component';
import { ShowListComponent } from './show-list/show-list.component';

const routes: Routes = [
{path:"file-upload",component: FileUploadComponent},
{path:'', redirectTo: "file-upload", pathMatch:"full"},
{path:'login',component:LoginComponent},
{path:"User",component:ShowListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
