import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-file-upload',
  templateUrl: './file-upload.component.html',
  styleUrls: ['./file-upload.component.css']
})
export class FileUploadComponent {

  constructor(private http: HttpClient) {

  }
  flag = true //file is not being upload 
  file: any
  url = "http://localhost:8080/user/upload";


  selectFile(event: any) {

    this.file = event.target.files[0];

    console.log(this.file);
  }

  
  uploadFile() {
    let formData = new FormData; 
    //FormData object. This is a standard JavaScript object used for constructing key/value pairs representing form fields and their values.
    formData.append("file", this.file);
    this.flag = false;
    this.http.post(this.url, formData).subscribe(
      (data: any) => {
        //success
        console.log(data);
        this.flag = true;
        alert(data.message);
      }, (error) => {
        //errror 
        this.flag = true;
        console.log(error);
        alert(error);
      })

  }
}
