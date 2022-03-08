package ca.sheridancollege.tanciong.controllers;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.tanciong.beans.Food;
import ca.sheridancollege.tanciong.beans.FoodType;
import ca.sheridancollege.tanciong.beans.Ingredient;
import ca.sheridancollege.tanciong.beans.LanguageType;
import ca.sheridancollege.tanciong.beans.User;
import ca.sheridancollege.tanciong.repositories.FoodRepository;
import ca.sheridancollege.tanciong.repositories.IngredientRepository;
import ca.sheridancollege.tanciong.repositories.UserRepository;
import lombok.AllArgsConstructor;

//Home
@Controller
@AllArgsConstructor
public class FoodController {
	
	private FoodRepository foodRepository;
	private IngredientRepository ingredientRepository;
	private UserRepository userRepository;
	
	
	@GetMapping("/addFood")
	public String addFood(Model model) {
		model.addAttribute("food", new Food());
		model.addAttribute("foodList", foodRepository.findAll());
		model.addAttribute("foodType", FoodType.values());
		return "secure/addFood";
	}
	
	@PostMapping("/addFood")
	public String addFood(Model model, @ModelAttribute Food food) {
		food.setId(null);
		foodRepository.save(food);
		model.addAttribute("food", new Food());
		model.addAttribute("foodList", foodRepository.findAll());
		model.addAttribute("foodType", FoodType.values());
		return "secure/addFood";
	}
	
	@GetMapping("/deleteFoodById/{id}")
	public String deleteAppointmentById(Model model, @PathVariable Long id) {
		foodRepository.deleteById(id);
		model.addAttribute("food", new Food());
		model.addAttribute("foodList", foodRepository.findAll());
		model.addAttribute("foodType", FoodType.values());
		return "secure/addFood";
	}
	@GetMapping("/editFoodById/{id}")
	public String editAppointmentById(Model model, @PathVariable Long id) {
		Food food = foodRepository.findById(id).get();
		model.addAttribute("food", food);
		foodRepository.deleteById(id);
		model.addAttribute("foodType", FoodType.values());
		model.addAttribute("foodList", foodRepository.findAll());
		return "secure/addFood";
	}
/*	
	@GetMapping("/addOrder")
	public String addOrder(Model model) {
		model.addAttribute("food", new Food());
		model.addAttribute("foodList", foodRepository.findAll());
		model.addAttribute("foodType", FoodType.values());
		
		return "addOrder";
	}
	
	@PostMapping("/addOrder")
	public String addOrder(Model model, @ModelAttribute Food food) {
		
		Food savedOrder = foodRepository.save(food);
		User user = new User();
		user.setFoodOrder(savedOrder);
		model.addAttribute("user", user);
		model.addAttribute("foodList", foodRepository.findAll());
		model.addAttribute("languageType", LanguageType.values());
		return "addUser";
	}
	*/
	@GetMapping("/addIngredient")
	public String addIngredient(Model model) {
		model.addAttribute("foodList", foodRepository.findAll());
		model.addAttribute("ingredient", new Ingredient());
		
		return "secure/addIngredient";
	}
	
	@PostMapping("/addIngredient")
	public String addIngredient(Model model, @RequestParam Long id, @RequestParam String name) {
		Food food = foodRepository.findById(id).get();
		Ingredient ingredient = new Ingredient();
		ingredient.setName(name);
		ingredient = ingredientRepository.save(ingredient);
		food.getIngredientList().add(ingredient);
		foodRepository.save(food);
		
		model.addAttribute("foodType", FoodType.values());
		model.addAttribute("orderList", userRepository.findByVisitDateEqualsOrderByVisitTimeAsc(LocalDate.now()));
		model.addAttribute("ingredientList", ingredientRepository.findAll());
		model.addAttribute("foodList", foodRepository.findAll());
		
		return "secure/index";
	}
	
	@GetMapping("food_findByVegetarianTrue")
	public String food_findByVegetarianTrue(Model model) {
		model.addAttribute("foodList", foodRepository.findByVegetarianTrue());
		model.addAttribute("foodType", FoodType.values());
		return "foodMenu";
	}
	
	
	@GetMapping("food_findByFoodType")
	public String food_findByFoodType(Model model, @RequestParam FoodType foodType) {
		model.addAttribute("foodList", foodRepository.findByFoodType(foodType));
		model.addAttribute("foodType", FoodType.values());
		return "foodMenu";
	}
	
	
	@GetMapping("food_findByPriceLessThan")
	public String food_findByPriceLessThan(Model model, @RequestParam Double price) {
		model.addAttribute("foodList", foodRepository.findByPriceLessThan(price));
		model.addAttribute("foodType", FoodType.values());
		return "foodMenu";
	}



}
