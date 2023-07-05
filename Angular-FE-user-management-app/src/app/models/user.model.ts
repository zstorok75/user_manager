import { Department } from "./department.model";

export interface User {
    id?: number;
    department: Department;
    name: string,
    birthday: string
}