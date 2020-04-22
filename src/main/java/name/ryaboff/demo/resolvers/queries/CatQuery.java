package name.ryaboff.demo.resolvers.queries;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import name.ryaboff.demo.domain.Cat;
import name.ryaboff.demo.domain.Cats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Optional.ofNullable;

@Component
public class CatQuery implements GraphQLQueryResolver {

    private final Cats cats;

    public CatQuery(@Autowired Cats cats) {
        this.cats = cats;
    }

    public List<Cat> cats(int count, int offset) {
        return cats.some(count, offset);
    }

    public Cat catByName(String name) {
        return cats.byName(ofNullable(name).orElse(""));
    }
}
