package br.com.digitalhouse.bootcampbrspring.dataprovider;

import br.com.digitalhouse.bootcampbrspring.dataprovider.repository.DishRepository;
import br.com.digitalhouse.bootcampbrspring.dataprovider.repository.entity.DishData;
import br.com.digitalhouse.bootcampbrspring.domain.entity.Dish;
import br.com.digitalhouse.bootcampbrspring.domain.entity.mapper.DishMapper;
import br.com.digitalhouse.bootcampbrspring.domain.gateways.DishGateway;
import br.com.digitalhouse.bootcampbrspring.usecase.exceptions.ObjectNotFoundException;
import br.com.digitalhouse.bootcampbrspring.usecase.model.request.DishRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DishDataProvider implements DishGateway {

    private DishRepository dishRepository;

    public DishDataProvider(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @Override
    public Dish findById(Integer dishId) {
        var data = this.dishRepository.findById(dishId);

        this.validateIfExists(data, dishId);

        return DishMapper.fromDishData(data.get());
    }

    private void validateIfExists(Optional<DishData> data, Integer dishId) {
        if (!data.isPresent())
            throw new ObjectNotFoundException("Dish not found! Id: " + dishId);
    }
}
