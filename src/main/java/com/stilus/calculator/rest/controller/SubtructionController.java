package com.stilus.calculator.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stilus.calculator.strategy.ICalculation;

@RestController
@RequestMapping("/api/private")
public class SubtructionController {

	@Autowired
	@Qualifier("subtraction")
	private ICalculation calculation;

	@GetMapping("/subtruct/{num1}/{num2}")
	public float add(@PathVariable float num1, @PathVariable float num2) {
		return calculation.calculate(num1, num2);
	}

}
