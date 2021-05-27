package br.com.digitalhouse.bootcampbrspring.entrypoint.controller;

import java.time.LocalDate;

import br.com.digitalhouse.bootcampbrspring.usecase.model.request.StudentRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.digitalhouse.bootcampbrspring.domain.entity.House;
import br.com.digitalhouse.bootcampbrspring.usecase.CalculatorUseCase;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

	public CalculatorUseCase calculatorUseCase;

	public CalculatorController(CalculatorUseCase calculatorUseCase) {
		this.calculatorUseCase = calculatorUseCase;
	}

	@GetMapping("/{year}/{month}/{day}")
	public ResponseEntity<String> ageCalculator(@PathVariable int year, @PathVariable int month,
			@PathVariable int day) {
		try {
			LocalDate birthdate = LocalDate.of(year, month, day);

			var age = calculatorUseCase.calculateAge(birthdate);

			var response = age == 0 ? "É UM BEBÊ" : "IDADE: " + age + " anos";

			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (RuntimeException ex) {

			return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {

			return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/house")
	public ResponseEntity<Object> areaCalculator(@RequestBody House house) {
		try {

			return new ResponseEntity<>(this.calculatorUseCase.calculateSquareMeters(house), HttpStatus.OK);
		} catch (RuntimeException ex) {

			return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {

			return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/average-grade")
	public ResponseEntity<Object> gradeCalculator(@RequestBody StudentRequest student) {
		try {

			return new ResponseEntity<>(this.calculatorUseCase.calculateAverageGrade(student), HttpStatus.OK);
		} catch (RuntimeException ex) {

			return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {

			return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
