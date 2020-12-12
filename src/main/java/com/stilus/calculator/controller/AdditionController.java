package com.stilus.calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stilus.calculator.strategy.ICalculation;

@RestController
@RequestMapping("/api/public")
public class AdditionController {
	
	@Autowired
	@Qualifier("addition")
	private ICalculation calculation;
	
	@GetMapping("/add")
	public double add() {
		return calculation.calculate(1, 2);
	}
	
}
