package tree.family.data;

import lombok.*;

import java.util.Date;
import java.util.List;

/**
 * Data class of a single person
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Person {
    // Id of the person
    @EqualsAndHashCode.Include
    private Integer id;

    // Name
    private String firstName;
    private String middleName;
    private String surname;

    // Birth
    private Date birthday;
    private String birthplace;

    // Death
    private Date dyingDay;
    private String placeOfDeath;

    // Relatives
    private Person mother;
    private Person father;
    private List<Person> children;

    // Marriage
    private Person marriagePartner;
    private Date dateOfMarriage;
}
