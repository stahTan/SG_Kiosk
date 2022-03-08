package ca.sheridancollege.tanciong.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.sheridancollege.tanciong.beans.User;

public interface UserRepository extends JpaRepository<User, Long> {
	public List<User> findByVisitDateEqualsOrderByVisitTimeAsc(LocalDate date);
	public List<User> findByVisitDateBetween(LocalDate startDate, LocalDate endDate);
	public List<User> findByIsLocalFalse();
	public List<User> findByIsLocalTrue();
	
	public List<User> findAllByOrderByVisitDateDescVisitTimeDesc();

}
