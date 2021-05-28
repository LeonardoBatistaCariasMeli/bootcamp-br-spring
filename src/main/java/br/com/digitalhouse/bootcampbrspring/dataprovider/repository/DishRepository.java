package br.com.digitalhouse.bootcampbrspring.dataprovider.repository;

import br.com.digitalhouse.bootcampbrspring.dataprovider.repository.entity.DishData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DishRepository extends JpaRepository<DishData, Integer> {
}
