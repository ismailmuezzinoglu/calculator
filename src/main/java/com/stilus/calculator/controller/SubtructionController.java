package com.stilus.calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stilus.calculator.strategy.ICalculation;

@RestController
@RequestMapping("/api/private")
public class SubtructionController {
	
	@Autowired
	@Qualifier("subtraction")
	private ICalculation calculation;
	
	@GetMapping("/subtruct")
	public double add() {
		return calculation.calculate(1, 2);
	}
	
	
}
