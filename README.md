# 2ibiChallenge - API

## Requirements
### Environment
- `Linux, Windows, Mac Os`
- 
### Java version
To run the API requires Java version 11

## Building
### Backend
- `cd 2ibiChallenge`
- `../mvnw clean install -DskipTests`

## Running and development
### Backend
- `../mvnw clean install -DskipTests`
- `java -jar target/ibi.challenge-0.0.1-SNAPSHOT.jar`
The application will be running at http://localhost:8080
and the database console will be available at http://localhost:8080/h2-console

An interactive API documentation will be available at [here](http://localhost:8080/swagger-ui.html).
  
**Note:** Add `Bearer` before the token to make authentication work and don't forget
to cover your code with Integration/Unit tests


## Running Tests
### Back-end
- `cd 2ibiChallenge`
- `./mvnw test`
