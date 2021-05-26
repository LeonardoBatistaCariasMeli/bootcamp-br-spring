package br.com.digitalhouse.bootcampbrspring.dataprovider;

import org.springframework.stereotype.Component;

import br.com.digitalhouse.bootcampbrspring.dataprovider.repository.RomanRepositoryFake;
import br.com.digitalhouse.bootcampbrspring.domain.gateways.RomanGateway;

@Component
public class RomanDataProvider implements RomanGateway {

	@Override
	public String numberConverter(Integer number) {
		
		return RomanRepositoryFake.getRomanNumberOf(number);
	}

	
}