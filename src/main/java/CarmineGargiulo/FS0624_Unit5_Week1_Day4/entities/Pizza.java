package CarmineGargiulo.FS0624_Unit5_Week1_Day4.entities;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Entity
@Table(name = "pizzas")
@NoArgsConstructor
public class Pizza extends MenuProduct{
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(joinColumns = @JoinColumn(name = "pizza_id"), inverseJoinColumns = @JoinColumn(name = "topping_id"), name = "pizzas_toppings")
    private List<Topping> toppingList;

    public Pizza(String name, double price, int calories, List<Topping> toppingList) {
        super(name, price, calories);
        this.toppingList = new ArrayList<>(toppingList);
    }

    public void addTopping(Topping topping){
        this.toppingList.add(topping);
        this.price += topping.price;
        this.calories += topping.calories;
    }

    @Override
    public String toString() {
        return  name + toppingList +
                ", price: " + price;
    }
}
