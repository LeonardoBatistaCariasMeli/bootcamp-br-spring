package br.com.digitalhouse.bootcampbrspring.usecase.impl;

import br.com.digitalhouse.bootcampbrspring.usecase.CalculatorUseCase;
import br.com.digitalhouse.bootcampbrspring.usecase.exceptions.DataIntegrityException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class CalculatorUseCaseImpl implements CalculatorUseCase {

    @Override
    public int calculateAge(LocalDate date) {
        if (date.isAfter(LocalDate.now())) {

            throw new DataIntegrityException("Insira uma data valida!!!");
        }

        var age = Period.between(date, LocalDate.now());

        return age.getYears();
    }

    @Override
    public int calculateSquareMeters(LocalDate date) {

        return 0;
    }
}
