package CarmineGargiulo.FS0624_Unit5_Week1_Day4.services;

import CarmineGargiulo.FS0624_Unit5_Week1_Day4.entities.MenuProduct;
import CarmineGargiulo.FS0624_Unit5_Week1_Day4.entities.Pizza;
import CarmineGargiulo.FS0624_Unit5_Week1_Day4.repositories.PizzasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzasService {
    @Autowired
    private PizzasRepository pizzasRepository;

    public void savePizza(Pizza pizza){
        pizzasRepository.save(pizza);
        System.out.println("Product " + pizza.getName() + " has been saved correctly");
    }

    public void saveManyPizzas(List<Pizza> pizzaList){
        for (Pizza pizza : pizzaList){
            this.savePizza(pizza);
        }
    }

    public long count(){
        return pizzasRepository.count();
    }
}
