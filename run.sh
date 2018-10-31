docker build -t atividade/banco ./postgres
docker run -p 5434:5432  --name banco  -d atividade/banco 
mvn clean package
docker build -t atividade/app .
docker run -p 8082:8080 --name app --link banco:host-banco -d -v $(pwd)/apps:/usr/local/tomcat/testes atividade/app 