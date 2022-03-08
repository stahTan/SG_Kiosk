package ca.sheridancollege.tanciong.controllers;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.tanciong.beans.FoodType;
import ca.sheridancollege.tanciong.repositories.FoodRepository;
import ca.sheridancollege.tanciong.repositories.SingaporeRepository;
import ca.sheridancollege.tanciong.repositories.UserRepository;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class HomeController {
	
	private UserRepository userRepository;
	private FoodRepository foodRepository;
	private SingaporeRepository singaporeRepository;
	
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("singaporeList", singaporeRepository.findAll());
		
		return "index";
	}
	
	@GetMapping("/secure/index")
	public String adminIndex(Model model) {
		model.addAttribute("orderList", userRepository.findByVisitDateEqualsOrderByVisitTimeAsc(LocalDate.now()));
		model.addAttribute("foodType", FoodType.values());
		return "secure/index";
	}
	
	@PostMapping("/login")
	public String secureIndex(Model model, @RequestParam String username, @RequestParam String password) {
		
		if(username.equals("Admin") && password.equals("1234")) {
			model.addAttribute("userList", userRepository.findAll());
			model.addAttribute("orderList", userRepository.findByVisitDateEqualsOrderByVisitTimeAsc(LocalDate.now()));
			model.addAttribute("foodType", FoodType.values());
			return "secure/index";
		}
		else {
			model.addAttribute("foodList", foodRepository.findAll());
			model.addAttribute("foodType", FoodType.values());
			model.addAttribute("orderList", userRepository.findByVisitDateEqualsOrderByVisitTimeAsc(LocalDate.now()));
			return "foodMenu";
		}		
	}
	
	@GetMapping("/foodMenu")
	public String foodMenu(Model model) {
		model.addAttribute("foodList", foodRepository.findAll());
		model.addAttribute("foodType", FoodType.values());
		model.addAttribute("orderList", userRepository.findByVisitDateEqualsOrderByVisitTimeAsc(LocalDate.now()));
		return "foodMenu";
	}
	
	@GetMapping("/login")
	public String secureIndex() {
		
		return "login";
			
	}
	
	
	
	
	

}
