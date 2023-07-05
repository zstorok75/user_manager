import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";

import { MatToolbarModule } from "@angular/material/toolbar";
import { MatButtonModule } from "@angular/material/button";
import { MatGridListModule } from "@angular/material/grid-list";
import { MatTableModule,  } from "@angular/material/table";
import { MatInputModule } from "@angular/material/input";
import { MAT_FORM_FIELD_DEFAULT_OPTIONS, MatFormFieldModule } from "@angular/material/form-field";
import { MatSelectModule } from "@angular/material/select";
import { MatDatepickerModule } from "@angular/material/datepicker";
import { MatNativeDateModule, MAT_DATE_LOCALE } from "@angular/material/core";
import { MatIconModule } from "@angular/material/icon";
import { MatSnackBarModule } from "@angular/material/snack-bar";
import { MatAutocompleteModule } from "@angular/material/autocomplete";

const materialModules = [
    MatToolbarModule,
    MatButtonModule,
    MatGridListModule,
    MatTableModule,
    MatInputModule,
    MatFormFieldModule,
    MatSelectModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatIconModule,
    MatSnackBarModule,
    MatAutocompleteModule,
];

@NgModule({
    declarations: [],
    imports: [
        CommonModule,
        materialModules
    ],
    exports: [ materialModules ],
    providers: [
        {
            provide: MAT_FORM_FIELD_DEFAULT_OPTIONS,
            useValue: [
                { appearance: 'fill' },
                { floatLabel: 'auto' }
            ]
        },
        {
            provide: MAT_DATE_LOCALE,
            useValue: 'hu-HU'
        }
    ]
})
export class MaterialModule { }