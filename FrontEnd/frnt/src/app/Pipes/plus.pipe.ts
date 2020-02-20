import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'plus'
})
export class PlusPipe implements PipeTransform {

  transform(address:string): string {
    let newAddress=address.replace(/ /g,"+");
    return newAddress;
  }
}
