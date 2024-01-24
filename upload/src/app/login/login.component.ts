import { Component } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {


  credentials={
    userName :'',
    password:''
  };

  onSubmit(){
   

    if((this.credentials.userName!='' && this.credentials.password!='')
      &&(this.credentials.userName!=null && this.credentials.password!=null)){
  
        console.log("fields have value");
        
    }
    else{
      console.log("Fields are empty")
    }
  }
}
