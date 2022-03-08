package ca.sheridancollege.tanciong.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Food {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NonNull
	private String name;
	@NonNull
	private Boolean vegetarian;
	@NonNull
	private Double price;
	
	@Enumerated(EnumType.STRING)
	private FoodType foodType;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List <Ingredient> ingredientList = new ArrayList<Ingredient>();
	

}
