package CarmineGargiulo.FS0624_Unit5_Week1_Day4.services;

import CarmineGargiulo.FS0624_Unit5_Week1_Day4.entities.Topping;
import CarmineGargiulo.FS0624_Unit5_Week1_Day4.repositories.ToppingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToppingService {
    @Autowired
    private ToppingsRepository toppingsRepository;

    public List<Topping> findAllToppings(){
        return toppingsRepository.findAll();
    }

    public Topping findToppingsByName(String name){
        return toppingsRepository.findByNameIgnoreCase(name).getFirst();
    }
}
