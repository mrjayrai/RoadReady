import { Booking } from "./Booking";
import { User } from "./User";

export interface Payment{
    paymentId:number,
    amount:number,
    date:Date,
    paymentMethod:string,
    paymentStatus:string,
    userId:User,
    bookingId:Booking
}