package ca.sheridancollege.tanciong.beans;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

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
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NonNull
	private String name;
	private Boolean isLocal;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate visitDate;
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	private LocalTime visitTime;
	@OneToOne
	@JoinColumn
	@JoinTable(name="User_Food",
	joinColumns = @JoinColumn(name="USER_ID"),
	inverseJoinColumns = @JoinColumn(name="FOOD_ID"))
	Food foodOrder;
	
	
	@Enumerated(EnumType.STRING)
	private LanguageType languageType;

	
	
}
