package ca.sheridancollege.tanciong.bootstrap;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ca.sheridancollege.tanciong.beans.Food;
import ca.sheridancollege.tanciong.beans.FoodType;
import ca.sheridancollege.tanciong.beans.Ingredient;
import ca.sheridancollege.tanciong.beans.LanguageType;
import ca.sheridancollege.tanciong.beans.Singapore;
import ca.sheridancollege.tanciong.beans.User;
import ca.sheridancollege.tanciong.repositories.FoodRepository;
import ca.sheridancollege.tanciong.repositories.IngredientRepository;
import ca.sheridancollege.tanciong.repositories.SingaporeRepository;
import ca.sheridancollege.tanciong.repositories.UserRepository;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class Bootstrap implements CommandLineRunner {
	private UserRepository userRepository;
	private FoodRepository foodRepository;
	private IngredientRepository ingredientRepository;
	private SingaporeRepository singaporeRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Singapore f1 = new Singapore("Singapore has four official languages: Mandarin, Malay, Tamil, and English, with English being the \"bridging\" language for different ethnic groups");
		Singapore f2 = new Singapore("Many Singaporeans use Singlish to communicate, which is a mix of English and other languages to form words or phrases unique to Singapore");
		Singapore f3 = new Singapore("Singapore is about 1/10th the area of Greater Toronto Area at 733 sq km, and has a population of 5.5 million - 1 million less than GTA.");
		Singapore f4 = new Singapore("It has the third greatest population density in the world.");
		Singapore f5 = new Singapore("Eating in the hawker centre is a prevalent culinary culture of Singaporean people.");
		Singapore f6 = new Singapore("Singapore is an independent city-state, not governed by any other body than itself.");
		Singapore f7 = new Singapore("It'd s city of man-made waterfalls.");
		Singapore f8 = new Singapore("Singapore has a tropical rainforest climate with no distinctive seasons.");
		Singapore f9 = new Singapore("It's home to the world's first night zoo, the Night Safari");
		Singapore f10 = new Singapore("Singaporean cuisine enjoy significant diversity from its different ethnic groups, influences deriving from such examples as Malays, Chinese, Indians, Indonesia, Peranakan and Western traditions. See more here.");
		
		singaporeRepository.save(f1);
		singaporeRepository.save(f2);
		singaporeRepository.save(f3);
		singaporeRepository.save(f4);
		singaporeRepository.save(f5);
		singaporeRepository.save(f6);
		singaporeRepository.save(f7);
		singaporeRepository.save(f8);
		singaporeRepository.save(f9);
		singaporeRepository.save(f10);
		
		
		Ingredient ing1 = Ingredient.builder().name("crab").build();
		Ingredient ing2 = Ingredient.builder().name("stingray").build();
		Ingredient ing3 = Ingredient.builder().name("chinese sausage").build();
		Ingredient ing4 = Ingredient.builder().name("fish cakes").build();
		Ingredient ing5 = Ingredient.builder().name("chicken").build();
		Ingredient ing6 = Ingredient.builder().name("shrimp").build();
		Ingredient ing7 = Ingredient.builder().name("rice noodles").build();
		Ingredient ing8 = Ingredient.builder().name("fish tofu").build();
		Ingredient ing9 = Ingredient.builder().name("mushrooms").build();
		Ingredient ing10 = Ingredient.builder().name("curry").build();
		Ingredient ing11 = Ingredient.builder().name("roti").build();
		Ingredient ing12 = Ingredient.builder().name("kaya spread").build();
		Ingredient ing13 = Ingredient.builder().name("pandan leaves").build();
		Ingredient ing14 = Ingredient.builder().name("coconut milk").build();
		Ingredient ing15 = Ingredient.builder().name("black glutinous rice").build();
		Ingredient ing16 = Ingredient.builder().name("fried rice").build();
		Ingredient ing17 = Ingredient.builder().name("green rice flour jelly").build();
		Ingredient ing18 = Ingredient.builder().name("coconut milk").build();
		Ingredient ing19 = Ingredient.builder().name("red adzuki beans").build();
		Ingredient ing20 = Ingredient.builder().name("egg").build();
		
		Food food1 = Food.builder()
				.name("Chilli crab")
				.vegetarian(false)
				.price(9.99)
				.foodType(FoodType.SEAFOOD)
				.ingredientList(new ArrayList<Ingredient>())
				.build();
		
		food1.getIngredientList().add(ing1);
		
		Food food2 = Food.builder()
				.name("Hainanese chicken rice")
				.vegetarian(false)
				.price(7.99)
				.foodType(FoodType.MEAT)
				.ingredientList(new ArrayList<Ingredient>())
				.build();
		
		food2.getIngredientList().add(ing5);
		
		Food food3 = Food.builder()
				.name("Char kway teow")
				.vegetarian(false)
				.price(7.99)
				.foodType(FoodType.NOODLES)
				.ingredientList(new ArrayList<Ingredient>())
				.build();
		
		food3.getIngredientList().add(ing3);
		food3.getIngredientList().add(ing4);
		food3.getIngredientList().add(ing7);
		
		Food food4 = Food.builder()
				.name("Barbecued stingray")
				.vegetarian(false)
				.price(10.99)
				.foodType(FoodType.SEAFOOD)
				.ingredientList(new ArrayList<Ingredient>())
				.build();
		
		food4.getIngredientList().add(ing2);
		
		Food food5 = Food.builder()
				.name("Roti prata")
				.vegetarian(true)
				.price(5.99)
				.foodType(FoodType.SNACK)
				.ingredientList(new ArrayList<Ingredient>())
				.build();
		
		food5.getIngredientList().add(ing9);
		food5.getIngredientList().add(ing10);
		food5.getIngredientList().add(ing11);
		
		Food food6 = Food.builder()
				.name("Kaya Toast")
				.vegetarian(true)
				.price(1.99)
				.foodType(FoodType.SNACK)
				.ingredientList(new ArrayList<Ingredient>())
				.build();
		
		food6.getIngredientList().add(ing12);
		
		Food food7 = Food.builder()
				.name("Pulut hitam")
				.vegetarian(true)
				.price(1.99)
				.foodType(FoodType.DESSERT)
				.ingredientList(new ArrayList<Ingredient>())
				.build();
		
		food7.getIngredientList().add(ing13);
		food7.getIngredientList().add(ing14);
		food7.getIngredientList().add(ing15);
		
		Food food8 = Food.builder()
				.name("Nasi lemak")
				.vegetarian(false)
				.price(8.99)
				.foodType(FoodType.RICE)
				.ingredientList(new ArrayList<Ingredient>())
				.build();
		food8.getIngredientList().add(ing6);
		food8.getIngredientList().add(ing20);
		
		Food food9 = Food.builder()
				.name("Nasi goreng")
				.vegetarian(false)
				.price(8.99)
				.foodType(FoodType.RICE)
				.ingredientList(new ArrayList<Ingredient>())
				.build();
		
		food9.getIngredientList().add(ing16);
		
		Food food10 = Food.builder()
				.name("Chendol")
				.vegetarian(true)
				.price(2.99)
				.foodType(FoodType.DESSERT)
				.ingredientList(new ArrayList<Ingredient>())
				.build();
		
		food10.getIngredientList().add(ing17);
		food10.getIngredientList().add(ing18);
		food10.getIngredientList().add(ing19);
		
		User user1 = User.builder().name("Janet")
				.isLocal(true)
				.visitDate(LocalDate.parse("2022-02-19"))
				.visitTime(LocalTime.of(20, 15))
				.languageType(LanguageType.SINGLISH).build();
		User user2 = User.builder().name("Nina")
				.isLocal(false)
				.visitDate(LocalDate.parse("2022-01-19"))
				.visitTime(LocalTime.of(13, 30))
				.languageType(LanguageType.MANDARIN).build();
		User user3 = User.builder().name("Stan")
				.isLocal(false)
				.visitDate(LocalDate.parse("2022-01-19"))
				.visitTime(LocalTime.of(15, 45))
				.languageType(LanguageType.ENGLISH).build();
		User user4 = User.builder().name("Cindie")
				.isLocal(true)
				.visitDate(LocalDate.now())
				.visitTime(LocalTime.of(20, 15))
				.languageType(LanguageType.TAMIL).build();
		User user5 = User.builder().name("Gideon")
				.isLocal(false)
				.visitDate(LocalDate.now())
				.visitTime(LocalTime.of(20, 20))
				.languageType(LanguageType.MALAY).build();
		user1.setFoodOrder(food2);
		user2.setFoodOrder(food3);
		user3.setFoodOrder(food7);
		user4.setFoodOrder(food8);
		user5.setFoodOrder(food9);
				
		foodRepository.save(food1);
		foodRepository.save(food2);
		foodRepository.save(food3);
		foodRepository.save(food4);
		foodRepository.save(food5);
		foodRepository.save(food6);
		foodRepository.save(food7);
		foodRepository.save(food8);
		foodRepository.save(food9);
		foodRepository.save(food10);
		
		userRepository.save(user1);
		userRepository.save(user2);
		userRepository.save(user3);
		userRepository.save(user4);
		userRepository.save(user5);
				
		ing1 = ingredientRepository.save(ing1);
		ing2 = ingredientRepository.save(ing2);
		ing3 = ingredientRepository.save(ing3);
		ing4 = ingredientRepository.save(ing4);
		ing5 = ingredientRepository.save(ing5);
		ing6 = ingredientRepository.save(ing6);
		ing7 = ingredientRepository.save(ing7);
		ing8 = ingredientRepository.save(ing8);
		ing9 = ingredientRepository.save(ing9);
		ing10 = ingredientRepository.save(ing10);
		ing11 = ingredientRepository.save(ing11);
		ing12 = ingredientRepository.save(ing12);
		ing13 = ingredientRepository.save(ing13);
		ing14 = ingredientRepository.save(ing14);
		ing15 = ingredientRepository.save(ing15);
		ing16 = ingredientRepository.save(ing16);
		ing17 = ingredientRepository.save(ing17);
		ing18 = ingredientRepository.save(ing18);
		ing19 = ingredientRepository.save(ing19);
		ing20 = ingredientRepository.save(ing20);
		
		
		/*
		userRepository.deleteById(user1.getId());
		userRepository.deleteById(user2.getId());
		userRepository.deleteById(user3.getId());
		userRepository.deleteById(user4.getId());
		userRepository.deleteById(user5.getId());
*/
		
		
	}

}
