package tree.family.data;

import lombok.*;

import java.text.DateFormat;
import java.util.Date;

/**
 * Data class of a single person
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Person {
    // Id of the person
    @EqualsAndHashCode.Include
    private Integer id;

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

    /**
     * Set id of the person and the corresponding gender.
     * Gender is calculated of the id.
     *
     * @param id: Id of the person (even id is a man, odd id is a woman and
     *            otherwise gender of none)
     */
    public void setId(Integer id) {
        this.id = id;
        if (id == 1) {
            gender = Gender.NONE;
        } else if (id % 2 == 0) {
            gender = Gender.MAN;
        } else if (id % 2 == 1) {
            gender = Gender.WOMAN;
        } else {
            gender = Gender.NONE;
        }
    }

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
