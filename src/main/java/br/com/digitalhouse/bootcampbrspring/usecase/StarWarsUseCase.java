package br.com.digitalhouse.bootcampbrspring.usecase;

import java.util.List;

public interface StarWarsUseCase {

    public List<String> getAllCharactersByName(String name);
}
