package CarmineGargiulo.FS0624_Unit5_Week1_Day4.entities;

import CarmineGargiulo.FS0624_Unit5_Week1_Day4.enums.OrderState;
import CarmineGargiulo.FS0624_Unit5_Week1_Day4.enums.TableState;
import CarmineGargiulo.FS0624_Unit5_Week1_Day4.exceptions.OccupiedOrUnmatchableTableException;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@jakarta.persistence.Table(name = "orders")
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Column(name = "order_id")
    private long orderId;
    @Setter(AccessLevel.NONE)
    @ManyToOne
    @JoinColumn(name = "table_id")
    private Table table;
    @Setter(AccessLevel.NONE)
    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "order_id"), inverseJoinColumns = @JoinColumn(name = "product_id"), name = "orders_products")
    private List<MenuProduct> productList;
    @Column(name = "order_state")
    @Enumerated(EnumType.STRING)
    private OrderState orderState = OrderState.ONGOING;
    @Setter(AccessLevel.NONE)
    @Column(name = "order_time")
    private LocalTime orderTime = LocalTime.now();
    @Column(name = "cover_charges_nr")
    private int coverChargeNr;
    @Column(name = "tot_amount")
    private double totAmount;

    public Order(Table table, int coverChargeNr, int coperto){
        if(table.getMaxCapacity() < coverChargeNr || table.getTableState().equals(TableState.OCCUPIED)) throw new OccupiedOrUnmatchableTableException();
        this.table = table;
        this.table.setTableState(TableState.OCCUPIED);
        this.productList = new ArrayList<>();
        this.coverChargeNr = coverChargeNr;
        this.totAmount = coverChargeNr * coperto;
    }

    public void addElementsToOrder(List<MenuProduct> productsToAdd){
        this.productList.addAll(productsToAdd);
        setTotAmount(totAmount + productsToAdd.stream().mapToDouble(MenuProduct::getPrice).sum());
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", table=" + table.getTableNr() +
                ", orderList=" + productList +
                ", orderState=" + orderState +
                ", orderTime=" + orderTime +
                ", totAmount=" + totAmount +
                '}';
    }
}
