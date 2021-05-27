package br.com.digitalhouse.bootcampbrspring.usecase;

import br.com.digitalhouse.bootcampbrspring.domain.entity.House;
import br.com.digitalhouse.bootcampbrspring.usecase.model.response.HouseResponse;

import java.time.LocalDate;

public interface CalculatorUseCase {

    public int calculateAge(LocalDate date);

    public HouseResponse calculateSquareMeters(House house);

}
