package ca.sheridancollege.tanciong.controllers;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.tanciong.beans.Food;
import ca.sheridancollege.tanciong.beans.FoodType;
import ca.sheridancollege.tanciong.beans.LanguageType;
import ca.sheridancollege.tanciong.beans.User;
import ca.sheridancollege.tanciong.repositories.FoodRepository;
import ca.sheridancollege.tanciong.repositories.UserRepository;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class UserController {
	
	private UserRepository userRepository;
	private FoodRepository foodRepository;
	
	@GetMapping("/addUser")
	public String addUser(Model model) {
		model.addAttribute("languageType", LanguageType.values());
		model.addAttribute("user", new User());
		//model.addAttribute("userList", userRepository.findAll());
		model.addAttribute("foodList", foodRepository.findAll());
		return "addUser";
	}

	@PostMapping("/addUser")
	public String addUser(Model model, @ModelAttribute User user, @RequestParam Long id) {
		Food food = foodRepository.findById(id).get();
		user.setVisitDate(LocalDate.now());
		user.setVisitTime(LocalTime.now());
		user.setFoodOrder(food);
		userRepository.save(user);
		model.addAttribute("foodList", foodRepository.findAll());
		model.addAttribute("orderList", userRepository.findByVisitDateEqualsOrderByVisitTimeAsc(LocalDate.now()));
		
		return "foodMenu";
	}
	
	
	@GetMapping("/userInfo")
	public String userInfo(Model model) {
		//model.addAttribute("user", new User());
		model.addAttribute("userList", userRepository.findAllByOrderByVisitDateDescVisitTimeDesc());
		model.addAttribute("languageType", LanguageType.values());
		
		return "secure/userInfo";
	}
	
	@GetMapping("user_findByVisitDateBetween")
	public String user_findByVisitDateBetween(Model model, @RequestParam String startDate, 
			@RequestParam String endDate) {
		model.addAttribute("orderList", 
				userRepository.findByVisitDateBetween(LocalDate.parse(startDate), LocalDate.parse(endDate)));
		model.addAttribute("foodType", FoodType.values());
		return "secure/index";
	}
}
