package name.ryaboff.demo.resolvers.mutations;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import name.ryaboff.demo.dao.CatLike;
import name.ryaboff.demo.dao.PersonLike;
import name.ryaboff.demo.domain.Cats;
import name.ryaboff.demo.domain.Person;
import name.ryaboff.demo.domain.Persons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonMutation implements GraphQLMutationResolver {

    private final Persons persons;
    private final Cats cats;

    public PersonMutation(@Autowired Persons persons, @Autowired Cats cats) {
        this.persons = persons;
        this.cats = cats;
    }

    public Person assignCat(PersonLike person, CatLike cat) {
        return persons
            .sameAs(person)
            .addCat(cats.sameAs(cat));
    }
}
