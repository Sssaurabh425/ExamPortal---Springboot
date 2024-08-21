import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrl: './signup.component.css'
})
export class SignupComponent implements OnInit {
  constructor(private userService:UserService,private _snackBar:MatSnackBar) {}

  public user={
    username : '',
    password : '',
    firstName : '',
    lastName : '',
    email : '',
    phone : '',

  }

  ngOnInit(): void{}

  formSubmit()
  {
    console.log(this.user);
    if(this.user.username=='' || this.user.username==null)
    {
      // alert("User is required !!")
      this._snackBar.open("Username is required ||","ok",{
        duration:3000,
        // verticalPosition:'top',
        // horizontalPosition:'right'
      })
      return;
    }

    //validate

    //addUser : userservice
    this.userService.addUser(this.user).subscribe(
      (data:any)=>{
        //success
        console.log(data);
        // alert("success");
        Swal.fire('Successfully done','User id is '+data.id,'success');
      },
      /*this will not work if user already exist(code required changes-do it afterward)*/
      (error)=>{
        //error
        console.log(error);
        this._snackBar.open("Something went wrong ||","ok",{
          duration:3000,
          // verticalPosition:'top',
          // horizontalPosition:'right'
        })

      }
    )

  }

  //this.user

}
