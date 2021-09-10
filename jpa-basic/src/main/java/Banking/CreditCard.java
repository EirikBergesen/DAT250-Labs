package Banking;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int Number;
    private int Balance;
    private int Limit;
    @OneToOne
    private Pincode Pincode;
    @OneToOne
    private Bank Bank;
}
