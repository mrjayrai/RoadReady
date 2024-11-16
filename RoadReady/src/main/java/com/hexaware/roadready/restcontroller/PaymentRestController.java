package com.hexaware.roadready.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.roadready.entities.Payments;
import com.hexaware.roadready.services.IPaymentService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/payments")
public class PaymentRestController {
	@Autowired
	IPaymentService paymentService;
	@PostMapping("/addnewpayment")
	public Payments addNewPayment(@Valid @RequestBody Payments payment ) {
		return paymentService.addPayment(payment);
	}
	@GetMapping("/getallpayments")
	public List<Payments> getAllPayments(){
		return paymentService.getAllPayments();
	}


}
