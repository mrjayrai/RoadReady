// import { Role } from "./Role";

// export interface User {
//     userId: number;
//     email: string;
//     name: string;
//     password: string;
//     phoneNumber: string;
//     roleId: Role; // Reference to a Role interface or class
//     createdAt: Date; // ISO 8601 format to represent LocalDateTime
//   }
import { Role } from "./Role"; // Assuming Role is in the same folder or import path

export interface user {
    userId: number;              // Matches Java 'int'
    email: string;               // Matches Java 'String'
    name: string;                // Matches Java 'String'
    password: string;            // Matches Java 'String'
    phoneNumber: string;         // Matches Java 'String'
    roleId: Role;                // Role is an object, so we reference the Role interface
    createdAt: Date;             // Java's 'LocalDateTime' can be represented as Date in TypeScript
}
