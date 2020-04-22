package name.ryaboff.demo.domain;

import name.ryaboff.demo.dao.PersonLike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Set.of;

@Component
public class Persons {

    private final Set<Person> persons;

    public Persons(@Autowired Cats cats) {
        persons = of(
            new Person("John", "Smith"),
            new Person("Joe", "Doe", of(cats.byName("Misty"))),
            new Person("Lara", "Mist", of(cats.byName("Tiger"), cats.byName("Max")))
        );
    }

    public List<Person> some(int count, int offset) {
        return persons.stream()
            .skip(offset)
            .limit(count)
            .collect(Collectors.toList());
    }

    public Person byName(String firstnameStarts, String lastnameStarts) {
        return persons.stream()
            .filter(person -> person.firstname().startsWith(firstnameStarts))
            .filter(person -> person.lastname().startsWith(lastnameStarts))
            .findFirst()
            .orElseThrow(IllegalStateException::new);
    }

    public Person sameAs(PersonLike person) {
        return persons.stream()
            .filter(p -> p.firstname().equals(person.getFirstname()))
            .filter(p -> p.lastname().equals(person.getLastname()))
            .findFirst()
            .orElseThrow(IllegalArgumentException::new);
    }
}
