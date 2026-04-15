import { AbstractControl, AsyncValidatorFn, ValidationErrors } from '@angular/forms';
import { Observable, timer, of } from 'rxjs';
import { switchMap, map, catchError, first } from 'rxjs/operators';
import { ValidationService } from '../services/validationService';

export class CustomValidators {

  static uniqueValue(
    service: ValidationService,
     field: string
     ): AsyncValidatorFn {


    return (control: AbstractControl):
                     Observable<ValidationErrors | null> => {

      if (!control.value) return of(null);

      return timer(500).pipe(
        switchMap(() => service.checkIfExists(field, control.value)),
        map(exists => exists ? { [`${field}Taken`]: true } : null),
        catchError(err => {
          console.error('Error validator:', err);
          return of(null);
        }),
        first()
      );
    };
  }
}
