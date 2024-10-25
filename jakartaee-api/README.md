# Jakarta EE REST/JAX-RS API Project Template

This project uses a Maven Web project with standard Jakarta EE and JAX-RS API 2.0.

## Getting Started

## Test REST API

### Create a new object

```sh
curl -X POST http://localhost:8080/jakartaee-api/users/ -H 'Content-Type: application/json' --data '{}'
```

### Fetch an existing object

```sh
curl -X GET http://localhost:8080/jakartaee-api/users/1
```

### Update an existing object

```sh
curl -X PUT http://localhost:8080/jakartaee-api/users/1 -H 'Content-Type: application/json' --data '{}'
```

### Delete an existing object

```sh
curl -X DELETE http://localhost:8080/jakartaee-users/crud/1
```
