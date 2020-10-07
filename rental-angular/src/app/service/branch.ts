export interface Address {
  streetWithNumber: string;
  city: string;
  postalCode: string;
}

export interface Employee {
  id: number;
  firstName: string;
  lastName: string;
  position: string;
}

export interface Branch {
  id: number;
  address: Address;
 employees: Employee[];
  employee: Employee;
}
