package br.com.digitalhouse.bootcampbrspring.usecase.impl;

import br.com.digitalhouse.bootcampbrspring.domain.entity.Dish;
import br.com.digitalhouse.bootcampbrspring.domain.gateways.DishGateway;
import br.com.digitalhouse.bootcampbrspring.usecase.DishUseCase;
import br.com.digitalhouse.bootcampbrspring.usecase.model.request.DishRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DishUseCaseImpl implements DishUseCase {

    private DishGateway dishGateway;

    public DishUseCaseImpl(DishGateway dishGateway) {
        this.dishGateway = dishGateway;
    }

    @Override
    public List<Dish> getDishesOf(List<DishRequest> request) {
        var dishes = request.stream().map(d -> this.dishGateway.findById(d.getDishId())).collect(Collectors.toList());

        return this.placeTheQuantityOfEach(dishes, request);
    }

    private List<Dish> placeTheQuantityOfEach(List<Dish> dishes, List<DishRequest>dishesRequest) {
        for(int i = 0;i < dishes.size(); i++) {
            dishes.get(i).setQuantity(dishesRequest.get(i).getQuantity());
        }
        return dishes;
    }
}
