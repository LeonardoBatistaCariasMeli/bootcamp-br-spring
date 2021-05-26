package br.com.digitalhouse.bootcampbrspring.dataprovider;

import org.springframework.stereotype.Component;

import br.com.digitalhouse.bootcampbrspring.dataprovider.repository.RomanDadosFake;
import br.com.digitalhouse.bootcampbrspring.domain.gateways.RomanGateway;

@Component
public class RomanDataProvider implements RomanGateway {

	@Override
	public String numberConverter(Integer number) {
		
		return RomanDadosFake.getRomanNumberOf(number);
	}

	
}