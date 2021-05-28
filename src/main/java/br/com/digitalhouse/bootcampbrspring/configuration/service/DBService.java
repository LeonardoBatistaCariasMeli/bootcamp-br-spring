package br.com.digitalhouse.bootcampbrspring.configuration.service;

import br.com.digitalhouse.bootcampbrspring.dataprovider.repository.DishRepository;
import br.com.digitalhouse.bootcampbrspring.dataprovider.repository.entity.DishData;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    private DishRepository dishRepository;

    public DBService(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    public void InstantiateH2Database() {
        DishData dish1 = new DishData(null, 25.00, "Iscas de peixe");
        DishData dish2 = new DishData(null, 20.00, "Batata Frita");
        DishData dish3 = new DishData(null, 35.00, "Porção de Carne");
        DishData dish4 = new DishData(null, 30.00, "Tulipas");

        this.dishRepository.saveAll(Arrays.asList(dish1, dish2, dish3, dish4));
    }
}
