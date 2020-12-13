package com.stilus.calculator.strategy.strategies;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.stilus.calculator.strategy.ICalculation;

@Component
@Qualifier("addition")
public class Addition implements ICalculation {

	@Override
	public float calculate(float a, float b) {
		return a + b;
	}

}
