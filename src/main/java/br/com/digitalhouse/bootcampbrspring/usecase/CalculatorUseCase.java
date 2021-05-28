package br.com.digitalhouse.bootcampbrspring.usecase;

import br.com.digitalhouse.bootcampbrspring.domain.entity.House;
import br.com.digitalhouse.bootcampbrspring.usecase.model.request.FoodRequest;
import br.com.digitalhouse.bootcampbrspring.usecase.model.request.StudentRequest;
import br.com.digitalhouse.bootcampbrspring.usecase.model.response.FoodResponse;
import br.com.digitalhouse.bootcampbrspring.usecase.model.response.HouseResponse;
import br.com.digitalhouse.bootcampbrspring.usecase.model.response.StudentResponse;

import java.time.LocalDate;

public interface CalculatorUseCase {

    public int calculateAge(LocalDate date);

    public HouseResponse calculateSquareMeters(House house);

    public StudentResponse calculateAverageGrade(StudentRequest student);

    public FoodResponse calculateCalories (FoodRequest foodRequest);
}
