package CarmineGargiulo.FS0624_Unit5_Week1_Day4.repositories;

import CarmineGargiulo.FS0624_Unit5_Week1_Day4.entities.Topping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToppingsRepository extends JpaRepository<Topping, Long> {
    List<Topping> findByNameIgnoreCase(String name);
}
