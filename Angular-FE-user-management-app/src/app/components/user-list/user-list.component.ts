import { Component } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { User } from 'src/app/models/user.model';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
    selector: 'app-user-list',
    templateUrl: './user-list.component.html',
    styleUrls: ['./user-list.component.scss']
})
export class UserListComponent {

    userList: User[];
    displayedColumns: string[];
    messageToSnackbar: string;

    isAdd: boolean = false;

    constructor(
        private userService: UserService,
        private snackBar: MatSnackBar
    ) {
        this.messageToSnackbar = "";

        this.displayedColumns = ['department', 'name', 'birthday', 'action'];
        this.userList = [];

        this.fetchUserList();
    }

    fetchUserList(message?: string): void {
        if (message === 'refresh') {
            this.isAdd = false;
        }
        this.userService.getUsers().subscribe(
            users => { 
                this.userList = users
            },
            error => console.log(error),
        );
    }

    deleteUser(id: number): void {
        this.userService.deleteUser(id).subscribe(
            () => {
                this.messageToSnackbar = "User deleted successfully!";
                this.snackBar.open(this.messageToSnackbar, '', { duration: 5000 });
                this.fetchUserList();
            },
            (error) => {
                console.log(error);
                this.messageToSnackbar = "We can't delete the selected user!";
                this.snackBar.open( this.messageToSnackbar, 'Close' );
            }
        );
    }

}
