package tree.family.data;

import lombok.*;

import java.text.DateFormat;
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
public class Person {
    // Counter for id
    private static Integer idCount = 0;

    // Id of the person
    @EqualsAndHashCode.Include
    private Integer id = idCount++;

    // Gender of the person
    private Gender gender;

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

    // Marriage
    private Person marriagePartner;
    private Date dateOfMarriage;

    @Override
    public String toString() {
        String personString = "";

        personString += firstName + " " + surname;
        personString += " (";
        personString += birthday != null ? DateFormat.getDateInstance(DateFormat.MEDIUM).format(birthday) : "";
        personString += " - ";
        personString += dyingDay != null ? DateFormat.getDateInstance(DateFormat.MEDIUM).format(dyingDay) : "";
        personString += ")";

        return personString;
    }

    /**
     * Enumeration for usage as gender
     */
    public enum Gender {
        NONE,
        MAN,
        WOMAN
    }
}
