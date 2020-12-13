package com.stilus.calculator.soap.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.stilus.calculator.soap.model.add.AddRequest;
import com.stilus.calculator.soap.model.add.AddResponse;
import com.stilus.calculator.strategy.ICalculation;

@Endpoint
public class AdditionEndPoint {

	private static final String NAMESPACE_URI = "http://www.stilus.com/calculator/soap/model/add";

	@Autowired
	@Qualifier("addition")
	private ICalculation calculation;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "AddRequest")
	@ResponsePayload
	public AddResponse calculate(@RequestPayload AddRequest addRequest) {
		AddResponse response = new AddResponse();
		response.setResult(calculation.calculate(addRequest.getNum1(), addRequest.getNum2()));

		return response;
	}

}
