package tree.family.data;

import lombok.*;

import java.text.DateFormat;
import java.util.Date;

/**
 * Data class of marriage
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Marriage {
    // Id of marriage
    @EqualsAndHashCode.Include
    private Integer id;

    // Date
    private Date date;

    // Place
    private String place;

    @Override
    public String toString() {
        String marriageString = "";

        marriageString += date != null ? DateFormat.getDateInstance(DateFormat.MEDIUM).format(date) : "";

        if (place != null && !place.isEmpty()) {
            marriageString += date != null ? " (" : "(";
            marriageString += place;
            marriageString += ")";
        }

        return marriageString;
    }
}
