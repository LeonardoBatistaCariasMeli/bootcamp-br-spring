package br.com.digitalhouse.bootcampbrspring.domain.entity.mapper;

import br.com.digitalhouse.bootcampbrspring.domain.entity.Dish;
import br.com.digitalhouse.bootcampbrspring.usecase.model.request.DishRequest;

import java.util.List;
import java.util.stream.Collectors;

public interface DishMapper {

    public static List<Dish> assembleListDishOf(List<DishRequest> list) {
        return list.stream().map(DishMapper::assembleDishOf).collect(Collectors.toList());
    }

    public static Dish assembleDishOf(DishRequest request) {
        return new Dish(null, request.getPrice(), request.getDescription(), request.getQuantity());
    }
}
