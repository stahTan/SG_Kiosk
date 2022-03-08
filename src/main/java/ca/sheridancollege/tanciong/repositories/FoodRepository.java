package ca.sheridancollege.tanciong.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.sheridancollege.tanciong.beans.Food;
import ca.sheridancollege.tanciong.beans.FoodType;

public interface FoodRepository extends JpaRepository<Food, Long> {
	public List<Food> findByVegetarianTrue();
	public List<Food> findByFoodType(FoodType foodType);
	public List<Food> findByIngredientList_NameContains(String name);
	public List<Food> findByPriceLessThan(Double price);
	public Food findByNameEquals(String name);
}
