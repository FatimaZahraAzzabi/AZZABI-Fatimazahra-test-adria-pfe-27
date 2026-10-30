
import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-accounts',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './account.html',
  styleUrls: ['./account.css']
})
export class AccountsComponent {

  accounts = [
    {
      id: '550e8400-e29b-41d4-a716-446655440000',
      customerReference: 'CUST-001',
      status: 'ACTIVE',
      currency: 'EUR',
      balance: 5000.00
    },
    {
      id: '123e4567-e89b-12d3-a456-426614174000',
      customerReference: 'CUST-002',
      status: 'ACTIVE',
      currency: 'USD',
      balance: 1500.50
    },
    {
      id: '987fcdeb-51a2-43d1-b789-123456789abc',
      customerReference: 'CUST-003',
      status: 'BLOCKED',
      currency: 'EUR',
      balance: 100.00
    },
    {
      id: '456e7890-e12b-34d5-a678-426614174111',
      customerReference: 'CUST-004',
      status: 'ACTIVE',
      currency: 'MAD',
      balance: 25000.00
    }
  ];

  getStatusBadgeClass(status: string): string {
    return status === 'ACTIVE' ? 'bg-success' : 'bg-danger';
  }

}
