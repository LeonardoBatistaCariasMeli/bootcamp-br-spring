package br.com.digitalhouse.bootcampbrspring.usecase.impl;

import org.springframework.stereotype.Component;

import br.com.digitalhouse.bootcampbrspring.domain.gateways.RomanGateway;
import br.com.digitalhouse.bootcampbrspring.usecase.RomanUseCase;

@Component
public class RomanUseCaseImpl implements RomanUseCase {

	private final RomanGateway romanGateway;
	
	public RomanUseCaseImpl(RomanGateway romanGateway) {
		this.romanGateway = romanGateway;
	}
	
	@Override
	public String numberConverter(Integer number) {
		
		return this.romanGateway.numberConverter(number);
	}
	
	
}
