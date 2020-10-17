export interface Address {
  streetWithNumber: string;
  city: string;
  postalCode: string;
}

export interface EmployeeB {
  id: number;
  firstName: string;
  lastName: string;
  position: string;
}

export interface Branch {
  id: number;
  address: Address;
 employees: EmployeeB[];
  employee: EmployeeB;
}
