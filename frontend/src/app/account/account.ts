import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-accounts',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './accounts.component.html',
  styleUrls: ['./accounts.component.css']
})
export class AccountsComponent implements OnInit {
  accounts: any[] = [];
  loading = true;
  error = '';

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.loadAccounts();
  }

  loadAccounts(): void {
    this.loading = true;
    this.error = '';

    this.http.get<any[]>('http://localhost:8085/accounts').subscribe({
      next: (data) => {
        this.accounts = data;
        this.loading = false;
      },
      error: (err) => {
        this.error = 'Erreur lors du chargement des comptes';
        this.loading = false;
        console.error(err);
      }
    });
  }

  getStatusBadgeClass(status: string): string {
    return status === 'ACTIVE' ? 'bg-success' : 'bg-danger';
  }
}
