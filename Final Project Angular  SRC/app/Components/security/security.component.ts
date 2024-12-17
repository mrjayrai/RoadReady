import { Component, OnInit } from '@angular/core';
import { JwtClientService } from 'src/app/Services/jwt-client.service';

@Component({
  selector: 'app-security',
  templateUrl: './security.component.html',
  styleUrls: ['./security.component.css']
})
export class SecurityComponent implements OnInit {

  response:any;
  token:any;


  // authRequest: AuthRequest = new AuthRequest();

  authRequest:any = {
    "userName": "Shreya542@gmail.com",
    "userPassword": "aBc@123456"
  }

constructor(private jwtService:JwtClientService){}


ngOnInit(): void {
  
   this.getAccessToken(this.authRequest);
}


//  readFormData(formData:any){

//     this.authRequest.username = formData.form.value.username;
//     this.authRequest.password = formData.form.value.password;

//     this.getAccessToken(this.authRequest);

//  }



public getAccessToken(authRequest:any){

 let response =  this.jwtService.getGeneratedToken(authRequest);

    response.subscribe( (genToken)=> {
         this.token = genToken ;
         console.log(genToken); 
         console.log(this.token);
        this.accessApi(this.token) });

    

}

// public accessApi(token:any){



// let responseBody =    this.jwtService.authorizationTest(token);

//     console.log(responseBody )

// responseBody.subscribe( responseData => {
//                          this.response = responseData;
//                           console.log('responseData '+responseData)
//                           } , error => {console.log('myerror '+error)});

// }
public accessApi(token: any) {
  // Call the authorizationTest method and get the observable
  let responseBody = this.jwtService.authorizationTest(token);

  // Log the observable itself (this will not log the response, only the observable object)
  console.log('Observable:', responseBody);

  // Subscribe to the observable to handle the actual response and error
  responseBody.subscribe(
      (responseData) => {
          // Handle the successful response
          this.response = responseData;
          console.log('responseData:', responseData);
      },
     (error )=> {
          // Handle any error that occurs during the request
          console.log('Error:', error);
      }
  );
}


}
