package br.com.digitalhouse.bootcampbrspring.entrypoint.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.digitalhouse.bootcampbrspring.usecase.RomanUseCase;

@RequestMapping("/roman")
@RestController
public class RomanConverterController {

	private RomanUseCase romanUseCase;

	public RomanConverterController(RomanUseCase romanUseCase) {
		this.romanUseCase = romanUseCase;
	}

	@GetMapping("/{number}")
	public String getNumberInRoman(@PathVariable("number") Integer number) {
		return romanUseCase.numberConverter(number);
	}

}
