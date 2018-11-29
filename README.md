# demo-spring-microservices
Sample microservices with Spring Cloud (config,eureka,gateway,hystrix) and Docker compose

Run Terminal/Powershell (as administrator)
- `git clone https://github.com/npsarawut/demo-spring-microservices.git`
- `cd demo-spring-microservices`
- `mvn clean package -DskipTests`
- `docker-compose up --build`

Run on browser
- http://localhost:8060/greet/api/hi
- http://localhost:8060/greet/api/hello
