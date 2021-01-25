# Kotlin Spring boot backend

## how to run:
1. Start database:
```
docker compose up
```

2. build fat jar:
```
mvn clean install
```

3. run jar
```
java -jar ./target/kotlin-spring-boot-angular-0.0.1-SNAPSHOT.jar
```

4. test it:
   create employee
```
curl --location --request POST 'localhost:8080/api/employee' \
--header 'Content-Type: application/json' \
--data-raw '{
	"firstName": "john",
	"lastName": "doe",
	"email": "john@doe.com"
}'
```
get employee:
```
curl --location --request GET 'localhost:8080/api/employee'
curl --location --request GET 'localhost:8080/api/employee/1'
```
update employee:
```
curl --location --request PUT 'localhost:8080/api/employee' \
--header 'Content-Type: application/json' \
--data-raw '{
   "id": 1,
	"firstName": "luke",
	"lastName": "doe",
	"email": "john@doe.com"
}'
```
delete employee:
```
curl --location --request DELETE 'localhost:8080/api/employee/1'
```

