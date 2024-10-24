package CarmineGargiulo.FS0624_Unit5_Week1_Day4.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "toppings")
@NoArgsConstructor
public class Topping extends MenuProduct{
    public Topping(String name, double price, int calories) {
        super(name, price, calories);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
