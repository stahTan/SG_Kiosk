package ca.sheridancollege.tanciong.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.sheridancollege.tanciong.beans.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long>{

}
