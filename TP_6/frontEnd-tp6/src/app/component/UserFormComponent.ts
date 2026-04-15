import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ValidationService } from '../services/validationService';
import { CustomValidators } from '../validators/customValidator';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-user-form',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './userFormComponent.html'
})

export class UserFormComponent {

  form: FormGroup;

  constructor(private fb: FormBuilder,
              private validationService: ValidationService) {

    this.form = this.fb.group({
      username: [
        '',
        [Validators.required, Validators.minLength(4)],
        [CustomValidators.uniqueValue(this.validationService, 'username')]
      ],
      email: [
        '',
        [Validators.required, Validators.email],
        [CustomValidators.uniqueValue(this.validationService, 'email')]
      ]
    });
  }

  get f() {
    return this.form.controls;
  }
}
