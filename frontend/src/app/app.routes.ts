import { Routes } from '@angular/router';
import { PostStudentComponent } from './component/post-student/post-student.component';
import { GetAllstudentComponent } from './component/get-allstudent/get-allstudent.component';
import { UpdateStudentComponent } from './component/update-student/update-student.component';

export const routes: Routes = [
    {
        path: 'students',
        component: PostStudentComponent
    },
    {
        path: 'viewallstudents',
        component: GetAllstudentComponent
    },
    {
        path: 'students/:id',
        component: UpdateStudentComponent 
    }
];
