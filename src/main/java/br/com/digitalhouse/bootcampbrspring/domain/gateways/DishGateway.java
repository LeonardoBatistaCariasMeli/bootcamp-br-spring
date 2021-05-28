package br.com.digitalhouse.bootcampbrspring.domain.gateways;

import br.com.digitalhouse.bootcampbrspring.domain.entity.Dish;

public interface DishGateway {

    public Dish findById(Integer dishId);
}
