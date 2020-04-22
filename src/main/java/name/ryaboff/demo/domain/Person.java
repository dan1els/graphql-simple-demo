package name.ryaboff.demo.domain;

import com.google.common.collect.Sets;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Person {

    private final String firstname;
    private final String lastname;
    private Set<Cat> cats;

    public Person(String firstname, String lastname) {
        this(firstname, lastname, new HashSet<>());
    }

    public Person(String firstname, String lastname, Set<Cat> cats) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.cats = Set.copyOf(cats);
    }

    public String firstname() {
        return this.firstname;
    }

    public String lastname() {
        return this.lastname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return firstname.equals(person.firstname) &&
            lastname.equals(person.lastname) &&
            cats.equals(person.cats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, cats);
    }

    @Override
    public String toString() {
        return "Person{" +
            "firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            ", cats=" + cats +
            '}';
    }

    public Person addCat(Cat cat) {
        this.cats = Sets.union(this.cats, Set.of(cat));
        return this;
    }
}
