package com.hexaware.roadready.restcontroller;
/*
 * Author : Rajeshwari
 * Description : Rest Controller for Payment
 * Date: 17-11-2024
 */
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.roadready.entities.Payments;
import com.hexaware.roadready.entities.Users;
import com.hexaware.roadready.services.IPaymentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/payments")
public class PaymentRestController {
	@Autowired
	IPaymentService paymentService;

	@PostMapping("/addnewpayment")
	public Payments addNewPayment(@Valid @RequestBody Payments payment) {
		// System.out.println(payment.toString());
		return paymentService.addPayment(payment);
		// return null;
	}

	@GetMapping("/getallpayments")
	public List<Payments> getAllPayments() {
		return paymentService.getAllPayments();
	}
	
	@GetMapping("/payment/{paymentId}")
	private Payments getPaymentById(@PathVariable int paymentId){
//		Payments payment=null;
//		payment=paymentService.getPaymentById(paymentId);
//		if(payment!=null) {
//			return payment;
//		}
//		else {
//			throw new NullPointerException();
//		}
		return paymentService.getPaymentById(paymentId);
	}
	
	@GetMapping("/user/{userId}")
	private List<Payments> getPaymentByUserId(@PathVariable int userId){
		List<Payments> payment=new ArrayList<Payments>();
		payment=paymentService.getPaymentsByUserId(userId);
		return payment;
	}
	
//	@GetMapping("/paymentstatus/{paymentId}")
//	private boolean isPaymentCompleted(@PathVariable int paymentId) {
//		return paymentService.isPaymentCompleted(paymentId);
//	}
//	
	@PutMapping("/updatepayment/{paymentId}/{paymentStatus}")
	private boolean updatePaymentStatus(@Valid @PathVariable int paymentId,@PathVariable String paymentStatus) {
		Payments.PaymentStatus status = Payments.PaymentStatus.valueOf(paymentStatus);
		return paymentService.updatePaymentStatus(paymentId, status);
//		if(updateStatus) {
//			return updateStatus;
//		}
//		else {
//			throw new RuntimeException();
//		}
		
	}
	
	@GetMapping("/getPaymentStatus/{paymentId}")
	public String getPaymentStatus(@PathVariable int paymentId) {
		return paymentService.paymentStatus(paymentId);
		
	}
	

}
