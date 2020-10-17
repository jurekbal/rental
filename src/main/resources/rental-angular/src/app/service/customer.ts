export interface Address {
  streetWithNumber: string;
  city: string;
  postalCode: string;
}

export interface Customer {
  id: number;
  firstName: string;
  lastName: string;
  email: string;
  address: Address;
}
