package br.com.digitalhouse.bootcampbrspring.usecase.impl;

import br.com.digitalhouse.bootcampbrspring.dataprovider.repository.StarWarsRepository;
import br.com.digitalhouse.bootcampbrspring.usecase.StarWarsUseCase;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StarWarsUseCaseImpl implements StarWarsUseCase {

    @Override
    public List<String> getAllCharactersByName(String name) {
        return StarWarsRepository.getAllCharactersByName(name);
    }
}
