import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UserService } from 'src/app/services/user.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Department } from 'src/app/models/department.model';
import { User } from 'src/app/models/user.model';
import { Observable } from 'rxjs';
import { startWith, map } from 'rxjs/operators';

@Component({
    selector: 'app-new-user',
    templateUrl: './new-user.component.html',
    styleUrls: ['./new-user.component.scss']
})
export class NewUserComponent implements OnInit {

    @Output() refreshEmitter = new EventEmitter<string>();

    form: FormGroup;
    latestBirthDate: Date;
    earliestBirthDate: Date;

    departments: Department[];
    filteredDepartments!: Observable<Department[]>;

    messageToSnackbar: string = "";

    constructor(
        private formBuilder: FormBuilder,
        private userService: UserService,
        private snackBar: MatSnackBar
    ) {
        this.latestBirthDate = new Date();
        this.earliestBirthDate = new Date(this.latestBirthDate.getFullYear() - 100, this.latestBirthDate.getMonth(), 1);

        this.form = this.formBuilder.group({
            department: ['', Validators.required],
            name: ['', Validators.required],
            birthday: ['', Validators.required]
        });

        this.departments = [];
        this.fetchDepartments();

    }

    ngOnInit(): void {
        this.filteredDepartments = this.form.get("department")!.valueChanges.pipe(
            startWith(''),
            map(value => {
                const name = typeof value === 'string' ? value : value.name;
                return name ? this.departmentFilter(name as string) : this.departments.slice();
            }),
        );
    }

    displayFn(department: Department): string {
        return department && department.name ? department.name : '';
    }

    private departmentFilter(name: string): Department[] {
        const filterValue = name.toLowerCase();

        return this.departments.filter(
            option => option.name.toLowerCase().includes(filterValue)
        );
    }

    saveNewUser(): void {
        if (this.form.valid) {
            const control = this.form.get("department")!;
            let departmentValue = control.value;
            if (typeof departmentValue === 'string') {
                control.setValue({ name: departmentValue, } as Department)
            }
            this.userService.saveNewUser(this.form.getRawValue() as User).subscribe(
                user => {
                    this.messageToSnackbar = "User saved successfully!";
                    this.snackBar.open(this.messageToSnackbar, '', { duration: 5000 });

                    this.fetchDepartments();
                    this.resetFormValue();
                },
                error => {
                    console.log(error);
                    this.messageToSnackbar = "UPS! Something went wrong. Please try again.";
                    this.snackBar.open(this.messageToSnackbar, 'Close')
                }
            );
        }
    }

    resetFormValue() {
        this.department.setValue('');
        this.department.setErrors(null);

        this.birthday.setValue('');
        this.birthday.setErrors(null);

        this.name.setValue('');
        this.name.setErrors(null);

        this.refreshEmitter.emit('refresh');
    }

    fetchDepartments(): void {
        this.userService.getDepartments().subscribe(
            response => {
                this.departments = response;
            },
            error => console.log(error),
        );
    }

    get department(): AbstractControl {
        return this.form.get("department")!;
    }

    get name(): AbstractControl {
        return this.form.get("name")!;
    }

    get birthday(): AbstractControl {
        return this.form.get("birthday")!;
    }

}
