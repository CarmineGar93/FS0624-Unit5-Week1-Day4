package CarmineGargiulo.FS0624_Unit5_Week1_Day4.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "drinks")
@NoArgsConstructor
public class Drink extends MenuProduct{
    private double qty;
    public Drink(String name, double price, int calories, double qty) {
        super(name, price, calories);
        this.qty = qty;
    }

    @Override
    public String toString() {
        return name +
                " (" + qty +
                "l), price: " + price;
    }
}
