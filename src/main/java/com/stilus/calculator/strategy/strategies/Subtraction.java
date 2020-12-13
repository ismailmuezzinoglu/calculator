package com.stilus.calculator.strategy.strategies;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.stilus.calculator.strategy.ICalculation;

@Component
@Qualifier("subtraction")
public class Subtraction implements ICalculation {

	@Override
	public float calculate(float a, float b) {
		return a - b;
	}

}
