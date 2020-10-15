export interface Booking {
  id: number;
  createdTimestamp: Date;
  customerId: number;
  employeeId: number;
  carId: number;
  rentalDay: string;
  returnDay: string;
  rentBranchId: number;
  returnBranchId: number;
  totalCost: number;
}
