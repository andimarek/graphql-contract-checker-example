# example project for [graphql-contract-checker](https://github.com/andimarek/graphql-contract-checker)
 
It checks via

```bash
./gradlew checkContract
```

if the old contract is still valid. In this example it fails on purpose, because the old schema was:

```graphql
type Query {
    hello: String
}
```

and the new one is 


```graphql
type Query {
    hello: Int
}
```

The type of `hello` was changed from `String` to `Int` which is a incompatible change.


## Details

The graphql server is created  with [Apollo Lauchpad](https://launchpad.graphql.com).

The [main method](src/main/java/Main.java) executes the query `{hello}` against the server.

The old schema (as Introspection JSON) is saved in `src/test/resources`. 
The current query is available as [classpath resource](src/main/resources/request.graphql).

The [gradle task](build.gradle#L45) to check the contract reads the old Introspection JSON file, 
reads the used query and queries the current Schema from the server.

With these three inputs the `graphql-contract-checker` is called and it is asserted that the contract is still valid. 
