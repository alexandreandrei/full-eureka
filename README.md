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

#### Lancement du proxy Zuul

Cet exemple illustre la mise en place d'un appel à un service de la registry Eureka via un gateway Zuul.

Note :
- Tutorial Spring Zuul : https://spring.io/guides/gs/routing-and-filtering/.

Le serveur démarre sur le port **8082**. On accède au service `tasks` par l'adresse : http://localhost:8082/tasks/tasks.

### Dockerization de tasks-service

Lancer la commande `eureka-service/build-docker.sh`.

Notes :
- lancer la daemon Docker: `sudo service docker start`
- il peut être nécessaire de lancer les commandes docker en `sudo`

Quelques commandes utiles :

- constuire une image à partir d'un fichier Dockerfile `docker build -t <name:tag> <dir>`

- lister les images `docker images`

- lancer une image `docker run <name>`

- voir les containers en cours de fonctionnement `docker ps`

- mettre fin à un container en cours de fonctionnement `docker ps <container-id>`

**Avertissement :** on ajoute l'option `--net=host` à l'execution de la commande `docker run`. Cette option permet de partager les ports entre l'hôte et le container, mais permet au container d'accéder à l'ensemble des connexions de l'hôte (potentils [problèmes de sécurité](https://docs.docker.com/engine/reference/run/)).
