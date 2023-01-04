# spring-reactive
A sample repo to explore spring web flux with native image

## pre-requisites
1. Docker
2. Docker Compose
3. JDK17

### Steps For Native
1. To create a native image run the command ` .\mvnw.cmd  clean compile spring-boot:build-image -Pnative` on windows or `mvnw  clean compile spring-boot:build-image -Pnative` for linux
2. Once the native image build is completed , run `docker-compose up`
### Steps For JVM
1. Run `docker-compose up -d sb-reactive-db`
2. Run `.\mvnw.cmd spring-boot:run` for windows or `mvnw spring-boot:run` for linux
