package br.com.digitalhouse.bootcampbrspring.usecase;

import java.time.LocalDate;

public interface CalculatorUseCase {

    public int calculateAge(LocalDate date);

    public int calculateSquareMeters(LocalDate date);

}
