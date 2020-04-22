package name.ryaboff.demo.resolvers.mutations;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import name.ryaboff.demo.domain.Cat;
import name.ryaboff.demo.domain.Cats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CatMutation implements GraphQLMutationResolver {

    private final Cats cats;

    public CatMutation(@Autowired Cats cats) {
        this.cats = cats;
    }

    public Cat newCat(String name) {
        cats.add(new Cat(name));
        return cats.byName(name);
    }

}
