package CarmineGargiulo.FS0624_Unit5_Week1_Day4.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@DiscriminatorColumn(name = "product_type")
public abstract class MenuProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Column(name = "product_id")
    private long productId;
    protected String name;
    protected double price;
    protected int calories;
    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;

    public MenuProduct(String name, double price, int calories){
        this.name = name;
        this.price = price;
        this.calories = calories;
    }


}
