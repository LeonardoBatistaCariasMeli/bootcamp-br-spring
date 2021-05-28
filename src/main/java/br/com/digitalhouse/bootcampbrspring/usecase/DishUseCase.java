package br.com.digitalhouse.bootcampbrspring.usecase;

import br.com.digitalhouse.bootcampbrspring.domain.entity.Dish;
import br.com.digitalhouse.bootcampbrspring.usecase.model.request.DishRequest;

import java.util.List;

public interface DishUseCase {

    List<Dish> getDishesOf(List<DishRequest> request);
}
