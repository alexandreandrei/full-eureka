### Démonstration de la stack **Netflix**

#### Lancement de la registry Eureka
```
mvn clean install && java -jar target/eureka-server-1.0-SNAPSHOT.jar
```

La console Eureka est disponible à l'adresse : http://localhost:8761.

#### Lancement du service Eureka
```
mvn clean install && java -jar target/eureka-service-1.0-SNAPSHOT.jar
```

Le service démarre sur le port **8080**, et est accessible sur http://localhost:8080/tasks.

#### Lancement du client Feign
```
mvn clean install && java -jar target/eureka-client-1.0-SNAPSHOT.jar
```

Le service démarre sur le port **8081**, et est accessible sur http://localhost:8081/tasks.

Notes :
- La valeur du `FeignClient` correspond à la valeur `spring.application.name` du service.
- La `value` et la `method` des o0méthodes du `FeignClient` correspondent à ce qui est déclaré dans le `Controller` du service.
