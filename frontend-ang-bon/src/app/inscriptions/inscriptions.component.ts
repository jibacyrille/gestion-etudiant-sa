import { Component } from '@angular/core';

@Component({
  selector: 'app-inscriptions',
  templateUrl: './inscriptions.component.html',
  styleUrl: './inscriptions.component.css'
})
export class InscriptionsComponent {

  isChildVisible = false;

  showChild() {
    this.isChildVisible = true;
  }

  hideChild() {
    this.isChildVisible = false;
  }

}
