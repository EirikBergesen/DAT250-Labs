package Banking;

import lombok.Data;
import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Data
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Name;
    @OneToMany
    private ArrayList<CreditCard> CreditCards;
}
