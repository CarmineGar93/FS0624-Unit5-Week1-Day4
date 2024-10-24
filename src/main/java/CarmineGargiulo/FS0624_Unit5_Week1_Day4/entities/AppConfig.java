package CarmineGargiulo.FS0624_Unit5_Week1_Day4.entities;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Configuration
@PropertySource("application.properties")
public class AppConfig {
    @Bean
    public Topping getTomato(){
        return new Topping("Tomato",0.5, 30);
    }

    @Bean
    public int getCopertoFee(@Value("${menu.coperto}") int coperto){
        return coperto;
    }

    @Bean
    public Topping getCheese(){
        return new Topping("Cheese",0.5, 80);
    }

    @Bean
    public Topping getSausage(){
        return new Topping("Sausage",1, 100);
    }

    @Bean
    public Topping getMushrooms(){
        return new Topping("Mushrooms",1, 40);
    }

    @Bean
    public Topping getSalame(){
        return new Topping("Spicy salame",0.5, 70);
    }

    @Bean
    public Topping getMelanzane(){
        return new Topping("Eggplant",0.5, 20);
    }

  /*  @Bean
    public List<Topping> getToppingBase(){
        List<Topping> base = new ArrayList<>();
        base.add(getCheese());
        base.add(getTomato());
        return base;
    }

    @Bean(name = "Pizza Margherita")
    @Scope("prototype")
    public Pizza getPizzaMargherita(){
        return new Pizza("Pizza Margherita",4.99, 1000, getToppingBase());
    }

    @Bean(name = "Pizza sausage and mushrooms")
    @Scope("prototype")
    public Pizza getPizzaSalsicciaFunghi(){
        Pizza pizza = getPizzaMargherita();
        pizza.addTopping(getMushrooms());
        pizza.addTopping(getSausage());
        pizza.setName("Pizza sausage and mushrooms");
        return pizza;
    }

    @Bean(name = "Pizza diavola")
    @Scope("prototype")
    public Pizza getPizzaDiavola(){
        Pizza pizza = getPizzaMargherita();
        pizza.addTopping(getSalame());
        pizza.setName("Pizza diavola");
        return pizza;
    }

    @Bean(name = "Pizza sausage and eggplant")
    @Scope("prototype")
    public Pizza getPizzaMelanzaneSalsiccia(){
        Pizza pizza = getPizzaMargherita();
        pizza.addTopping(getMelanzane());
        pizza.addTopping(getSausage());
        pizza.setName("Pizza sausage and eggplant");
        return pizza;
    }*/

    @Bean
    public Drink getCocaCola(){
        return new Drink("Coca cola",2, 150, 0.5);
    }

    @Bean
    public Drink getWater(){
        return new Drink("Water",1, 0, 1);
    }

    @Bean
    public Drink getFanta(){
        return new Drink("Fanta",1.5, 120, 0.33);
    }

    @Bean
    public Drink getBeer(){
        return new Drink("Beer",3, 250, 0.66);
    }

   @Bean
    public Scanner getScanner(){
        Scanner scanner = new Scanner(System.in);
        return scanner;
   }

   @Bean(name = "table1")
    public Table getTable1(){
        Table table = new Table(8);
        return table;
   }

    @Bean(name = "table2")
    public Table getTable2(){
        Table table = new Table(8);
        return table;
    }

    @Bean(name = "table3")
    public Table getTable3(){
        Table table = new Table(4);
        return table;
    }

    @Bean(name = "table4")
    public Table getTable4(){
        Table table = new Table(4);
        return table;
    }

    @Bean(name = "table5")
    public Table getTable5(){
        Table table = new Table(2);
        return table;
    }

    @Bean(name = "table6")
    public Table getTable6(){
        Table table = new Table(2);
        return table;
    }

}
