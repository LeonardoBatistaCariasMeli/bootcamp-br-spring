package br.com.digitalhouse.bootcampbrspring.domain.entity.mapper;

import br.com.digitalhouse.bootcampbrspring.dataprovider.repository.entity.DishData;
import br.com.digitalhouse.bootcampbrspring.domain.entity.Dish;
import br.com.digitalhouse.bootcampbrspring.usecase.model.request.DishRequest;

import java.util.List;
import java.util.stream.Collectors;

public interface DishMapper {

    public static Dish fromDishData(DishData data) {
        return new Dish(data.getId(), data.getPrice(), data.getDescription(), 0);

    }
}
