package br.com.digitalhouse.bootcampbrspring.usecase.impl;

import br.com.digitalhouse.bootcampbrspring.domain.entity.House;
import br.com.digitalhouse.bootcampbrspring.domain.entity.Room;
import br.com.digitalhouse.bootcampbrspring.usecase.CalculatorUseCase;
import br.com.digitalhouse.bootcampbrspring.usecase.exceptions.DataIntegrityException;
import br.com.digitalhouse.bootcampbrspring.usecase.model.HouseResponse;
import br.com.digitalhouse.bootcampbrspring.usecase.model.RoomResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

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
