package se.snorbu.hazelcastdemo.web.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import se.snorbu.hazelcastdemo.domain.model.Person;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonForm {
    private String firstName;
    private String lastName;

    public static PersonForm of(Person person) {
        return new PersonForm(
                person.getFirstName(),
                person.getLastName()
        );
    }
}
