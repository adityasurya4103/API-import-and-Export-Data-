import { Component, NgZone } from '@angular/core';
import { Users } from '../users';
import { UserServiceService } from '../user-service.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-show-list',
  templateUrl: './show-list.component.html',
  styleUrls: ['./show-list.component.css']
})
export class ShowListComponent {

  user!: Users[];
  currentDate: Date;
  constructor(private userService: UserServiceService, private router: Router, private ngZone: NgZone) {



    this.currentDate = new Date();

  }

  ngOnInit(): void {

    // this.user=[{"contact_no":1231,
    //   "account_no":"ACC", "account_type":"saving", "debit_card_no": "1213",
    //   "user_name":"1231","expiry_date":this.currentDate}]

    this.getUsers();

  }

  getUsers() {
    console.log('Calling getUsers method');

    this.ngZone.run(() => {
      this.userService.getUserList().subscribe(
        data => {
          console.log('Data received:', data);
          this.user = data;
          console.log('user', this.user);
          console.log('Users array length:', this.user.length);
        },
        error => {
          console.error('Error fetching user data:', error);
        }
      );
    });
  }






}


