# graphql-simple-demo
Simple GraphQL and Spring boot demo

Build and run:
```
mvn clean install spring-boot:run
```
GraphiQL endpoint:

http://localhost:8080/graphiql


query example:
```
query {
  catByName(name: "Max") {
    name
  }
}

query {
  persons(count: 3) {
    firstname, lastname
  }
}
```

mutation example:
```
mutation {
    newCat(name: "Loony") {
        name
    }
}

mutation {
    assignCat(
        person: {
            firstname: "Joe", lastname: "Doe"
        }, 
        cat: {
            name: "Loony"
        }) 
    {
        firstname, lastname, cats{name}
    }
}
```