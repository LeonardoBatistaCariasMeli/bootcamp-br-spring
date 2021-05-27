package br.com.digitalhouse.bootcampbrspring.entrypoint.controller;

import br.com.digitalhouse.bootcampbrspring.domain.entity.House;
import br.com.digitalhouse.bootcampbrspring.usecase.CalculatorUseCase;
import br.com.digitalhouse.bootcampbrspring.usecase.model.HouseResponse;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    public CalculatorUseCase calculatorUseCase;

    public CalculatorController(CalculatorUseCase calculatorUseCase) {
        this.calculatorUseCase = calculatorUseCase;
    }

    @GetMapping("/{year}/{month}/{day}")
    public String ageCalculator(@PathVariable int year, @PathVariable int month, @PathVariable int day) {
        LocalDate birthdate = LocalDate.of(year, month, day);

        var age = calculatorUseCase.calculateAge(birthdate);

        return age == 0 ? "É UM BEBÊ" : "IDADE: " + age + " anos";
    }

    @PostMapping("/house")
    public HouseResponse squareCalculator(@RequestBody House house) {

        return this.calculatorUseCase.calculateSquareMeters(house);
    }
}
