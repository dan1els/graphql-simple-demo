package name.ryaboff.demo.domain;

import com.google.common.collect.Sets;
import name.ryaboff.demo.dao.CatLike;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.google.common.collect.Sets.*;
import static java.util.Set.of;

@Component
public class Cats {

    private Set<Cat> cats;

    public Cats() {
        cats = of(
            new Cat("Tiger"),
            new Cat("Max"),
            new Cat("Lucky"),
            new Cat("Misty")
        );
    }

    public List<Cat> some(int count, int skip) {
        return cats.stream()
            .skip(skip)
            .limit(count)
            .collect(Collectors.toList());
    }

    public Cat sameAs(CatLike cat) {
        return cats.stream()
            .filter(p -> p.name().equals(cat.getName()))
            .findFirst()
            .orElseThrow(IllegalArgumentException::new);
    }

    public Cat byName(String namePrefix) {
        return cats.stream()
            .filter(cat -> cat.name().startsWith(namePrefix))
            .findFirst()
            .orElseThrow(IllegalStateException::new);
    }

    public void add(Cat cat) {
        this.cats = union(this.cats, Set.of(cat));
    }
}
