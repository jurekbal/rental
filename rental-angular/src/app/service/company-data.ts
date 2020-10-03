export interface Address {
  streetWithNumber: string;
  city: string;
  postalCode: string;
}

export interface CompanyBranch {
  id: number;
  address: Address;
}

export interface CompanyData {
  id: number;
  name: string;
  webDomain: string;
  owner: string;
  logoURL: string;
  companyBranches: CompanyBranch[];
}
