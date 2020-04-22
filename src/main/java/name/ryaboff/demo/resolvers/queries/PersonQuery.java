package name.ryaboff.demo.resolvers.queries;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import name.ryaboff.demo.domain.Person;
import name.ryaboff.demo.domain.Persons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Optional.ofNullable;

@Component
public class PersonQuery implements GraphQLQueryResolver {

    private final Persons persons;

    public PersonQuery(@Autowired Persons persons) {
        this.persons = persons;
    }

    public List<Person> persons(int count, int offset) {
        return persons.some(count, offset);
    }

    public Person personByName(String firstname, String lastname) {
        return persons.byName(ofNullable(firstname).orElse(""), ofNullable(lastname).orElse(""));
    }
}
