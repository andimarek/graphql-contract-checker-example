### example project for [graphql-contract-checker](https://github.com/andimarek/graphql-contract-checker)
 
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
