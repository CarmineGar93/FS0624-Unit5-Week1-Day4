package CarmineGargiulo.FS0624_Unit5_Week1_Day4;

import CarmineGargiulo.FS0624_Unit5_Week1_Day4.entities.*;
import CarmineGargiulo.FS0624_Unit5_Week1_Day4.services.MenuProductsService;
import CarmineGargiulo.FS0624_Unit5_Week1_Day4.services.PizzasService;
import CarmineGargiulo.FS0624_Unit5_Week1_Day4.services.ToppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Order(1)
public class InizializzaDbRunner implements CommandLineRunner {
    @Autowired
    private MenuProductsService menuProductsService;
    @Autowired
    private PizzasService pizzasService;
    @Autowired
    private ToppingService toppingService;
    @Autowired
    private List<MenuProduct> menuProducts;
    @Autowired
    private Menu menu;
    @Override
    public void run(String... args) throws Exception {
        if(menuProductsService.count() == 0){
            menuProductsService.saveManyProduct(menuProducts);
        }
        if(pizzasService.count() == 0){
            Topping cheese = toppingService.findToppingsByName("Cheese");
            Topping tomato = toppingService.findToppingsByName("Tomato");
            Topping sausage = toppingService.findToppingsByName("Sausage");
            Topping mushrooms = toppingService.findToppingsByName("Mushrooms");
            Topping spicySalame = toppingService.findToppingsByName("Spicy salame");
            Topping eggplant = toppingService.findToppingsByName("eggplant");
            Pizza pizzaMargherita = new Pizza("Pizza Margherita",4.99, 1000, Arrays.asList(cheese, tomato));
            Pizza pizzaDiavola = new Pizza("Pizza Diavola",4.99, 1000, Arrays.asList(cheese, tomato));
            pizzaDiavola.addTopping(spicySalame);
            Pizza pizzaSausageEggplant = new Pizza("Pizza sausage and eggplant",4.99, 1000, Arrays.asList(cheese, tomato));
            pizzaSausageEggplant.addTopping(sausage);
            pizzaSausageEggplant.addTopping(eggplant);
            Pizza pizzaSausageMushrooms = new Pizza("Pizza sausage and mushrooms",4.99, 1000, Arrays.asList(cheese, tomato));
            pizzaSausageMushrooms.addTopping(sausage);
            pizzaSausageMushrooms.addTopping(mushrooms);
            pizzasService.saveManyPizzas(Arrays.asList(pizzaMargherita, pizzaDiavola, pizzaSausageEggplant, pizzaSausageMushrooms));


        }
    }
}
