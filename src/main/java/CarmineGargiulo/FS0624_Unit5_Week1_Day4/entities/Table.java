package CarmineGargiulo.FS0624_Unit5_Week1_Day4.entities;

import CarmineGargiulo.FS0624_Unit5_Week1_Day4.enums.TableState;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@jakarta.persistence.Table(name = "tables")
public class Table {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long tableNr;
    @Column(name = "max_capacity")
    private int maxCapacity;
    @Column(name = "table_state")
    @Enumerated(EnumType.STRING)
    private TableState tableState = TableState.FREE;

    public Table(int nrCopertiMax){
        this.maxCapacity = nrCopertiMax;
    }
}
