import { Routes } from '@angular/router';
import { AccountsComponent } from './account/account';
import { Transaction } from './transaction/transaction';

export const routes: Routes = [
  {
    path: '',
    redirectTo: 'accounts',
    pathMatch: 'full'
  },
  {
    path: 'accounts',
    component: AccountsComponent
  },
  {
    path: 'transactions',
    component: Transaction
  }
];
