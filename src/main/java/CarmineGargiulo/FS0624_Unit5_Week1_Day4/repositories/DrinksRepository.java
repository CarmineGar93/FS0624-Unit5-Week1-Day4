package CarmineGargiulo.FS0624_Unit5_Week1_Day4.repositories;

import CarmineGargiulo.FS0624_Unit5_Week1_Day4.entities.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinksRepository extends JpaRepository<Drink, Long> {
}
