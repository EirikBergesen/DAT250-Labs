package Banking;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class Pincode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Pincode;
    private int Count;
}
