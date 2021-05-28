package br.com.digitalhouse.bootcampbrspring.dataprovider.repository;

import br.com.digitalhouse.bootcampbrspring.dataprovider.repository.entity.IngredientData;
import br.com.digitalhouse.bootcampbrspring.dataprovider.repository.entity.StarWarsData;
import br.com.digitalhouse.bootcampbrspring.usecase.exceptions.ObjectNotFoundException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public interface StarWarsRepository {

    public static List<String> getAllCharactersByName(String name) {
        try {
            File file = ResourceUtils.getFile("classpath:starwars.json");
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);

            var listStarWarsData = objectMapper.readValue(file, new TypeReference<List<StarWarsData>>() {
            });

            var filterList = listStarWarsData.stream().filter(s -> s.getName().toLowerCase(Locale.ROOT)
                    .contains(name.toLowerCase(Locale.ROOT)))
                    .collect(Collectors.toList());

            return filterList.stream().map(StarWarsData::getName).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        throw new ObjectNotFoundException("The name doesn't have a match");
    }

}
