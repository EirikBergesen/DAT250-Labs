package Banking;

import lombok.Data;
import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Street;
    private int Number;
    @ManyToMany
    private ArrayList<Person> Persons;
}
