import { booking } from "./Booking";
import { user } from "./User";

export interface Review{
    reviewId:number,
    rating:number,
    reviewText:string,
    reviewDate:Date,
    user:user,
    booking:booking

}