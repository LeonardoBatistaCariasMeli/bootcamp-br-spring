package br.com.digitalhouse.bootcampbrspring.dataprovider.repository;


import br.com.digitalhouse.bootcampbrspring.dataprovider.repository.entity.IngredientData;
import br.com.digitalhouse.bootcampbrspring.usecase.model.request.IngredientRequest;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public interface IngredientRepository {

    static List<IngredientData> findAll(List<IngredientRequest> ingredientRequest){
        File file = null;

        try{
            file = ResourceUtils.getFile("classpath:food.json");

            ObjectMapper objectMapper = new ObjectMapper();
            TypeReference<List<IngredientData>> typeRef = new TypeReference<List<IngredientData>>() {};
            List<IngredientData> ingredientDbs = null;

            ingredientDbs = objectMapper.readValue(file,typeRef);

            List<IngredientData> ingredientDatas = new ArrayList<>();

            for( var ingredient : ingredientRequest) {
                ingredientDatas.add(ingredientDbs.stream().filter(i -> i.getName().equals(ingredient.getName())).findFirst().get());
            }

            return ingredientDatas;

        } catch (IOException e){
            e.printStackTrace();
        }

        return new ArrayList<>();
    }
}
