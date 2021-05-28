package br.com.digitalhouse.bootcampbrspring.usecase.impl;

import br.com.digitalhouse.bootcampbrspring.dataprovider.repository.IngredientRepository;
import br.com.digitalhouse.bootcampbrspring.domain.entity.House;
import br.com.digitalhouse.bootcampbrspring.domain.entity.Room;
import br.com.digitalhouse.bootcampbrspring.usecase.CalculatorUseCase;
import br.com.digitalhouse.bootcampbrspring.usecase.exceptions.DataIntegrityException;
import br.com.digitalhouse.bootcampbrspring.usecase.model.request.FoodRequest;
import br.com.digitalhouse.bootcampbrspring.usecase.model.request.IngredientRequest;
import br.com.digitalhouse.bootcampbrspring.usecase.model.request.StudentRequest;
import br.com.digitalhouse.bootcampbrspring.usecase.model.request.SubjectRequest;
import br.com.digitalhouse.bootcampbrspring.usecase.model.response.*;

import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

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
    public HouseResponse calculateSquareMeters(House house) {

        return createHouseResponse(house);
    }

    @Override
    public StudentResponse calculateAverageGrade(StudentRequest student) {

        if (student == null || student.getSubjects() == null || student.getSubjects().size() <= 0) {
            throw new DataIntegrityException("Nao envie objetos vazios!!!");
        }

        var average = student.getSubjects().stream()
                .mapToDouble(SubjectRequest::getGrade)
                .reduce(0, Double::sum);

        average /= student.getSubjects().size();

        var message = "";
        if (average >= 9) {
            message = "Parabéns";
        }
        else {
            message = "Busque melhorar";
        }

        DecimalFormat df = new DecimalFormat("0.00");

        return new StudentResponse(student.getName(), message, Double.parseDouble(df.format(average)));
    }

    @Override
    public FoodResponse calculateCalories(FoodRequest foodRequest) {
        List<IngredientResponse> ingredientResponses = new ArrayList<>();
        var ingredientCalories = IngredientRepository.findAll(foodRequest.getIngredients());
        double totalCalories = 0, mostCaloric = 0;
        String mostCaloricIngredient = "";

        for(var ingredientData : ingredientCalories) {
            var ingredientRequest = foodRequest.getIngredients().stream().filter(i -> i.getName().equals(ingredientData.getName())).findFirst().get();
            double calories = ingredientData.getCalories() * ingredientRequest.getWeight();
            totalCalories += calories;
            if(calories > mostCaloric) {
                mostCaloric = calories;
                mostCaloricIngredient = ingredientData.getName();
            }
            ingredientResponses.add(new IngredientResponse(ingredientData.getName(),calories));
        }

        return new FoodResponse(totalCalories,ingredientResponses,mostCaloricIngredient);

    }

    private HouseResponse createHouseResponse(House house) {
        double totalArea = 0;
        double biggestArea = 0;
        Room biggestRoom = null;
        ArrayList<RoomResponse> roomResponse = new ArrayList<>();

        for (var room : house.getRooms()) {
            var area = calculateArea(room);

            totalArea += area;

            roomResponse.add(new RoomResponse(room.getName(), area));

            if (biggestArea < area) {
                biggestArea = area;
                biggestRoom = room;
            }
        }

        return new HouseResponse(house.getName(), totalArea, (totalArea * 800), biggestRoom, roomResponse);
    }

    private double calculateArea(Room room) {

        return room.getWidth() * room.getHeight();
    }

}
