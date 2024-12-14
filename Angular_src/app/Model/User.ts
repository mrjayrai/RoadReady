import { Role } from "./Role";

export interface User {
    userId: number;
    email: string;
    name: string;
    password: string;
    phoneNumber: string;
    roleId: Role; // Reference to a Role interface or class
    createdAt: string; // ISO 8601 format to represent LocalDateTime
  }