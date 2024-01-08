# papaours-referentiel-formation-back

## Contexte fonctionnel

## Contexte technique

Son écosystème technique est le suivant :

- Kotlin (Java 17)
- Spring / Spring Boot (ainsi que ces dépendances)
- Mongo

## Comment démarrer l'application

### Les prérequis

#### Environnement de développement

- Un IDE (Nous conseillons Intellij pour la gestion des profils Spring)
- JDK 17
- Docker et docker-compose

### Démarrer l'application via Docker

Depuis le répertoire courant :

#### Générer le .jar

```(bash)
./gradlew clean bootJar

BUILD SUCCESSFUL in 5s
5 actionable tasks: 5 executed
```


#### Instancier un conteneur mongo

- Récupérer une image mongo depuis le docker hub :

```
docker pull mongo
```

- Instancier un conteneur mongo depuis l'image récupérée :

```
docker run -d -p 27017:27017 --name mongo ton_image_mongo
```

#### Se connecter à mongo

Via l'utilisation de [MongoDB Compass](https://www.mongodb.com/try/download/compass), se connecter à la db via l'URI :

```
mongodb://localhost:27017
```

### Démarrer l'application via Intellij

#### Générer le .jar

```(bash)
./gradlew clean bootJar

BUILD SUCCESSFUL in 5s
5 actionable tasks: 5 executed
```

#### Démarrer l'application

Intellij autodétecte la nature du projet importé.

Une fois le `.jar` généré, il suffit de démarrer l'application directement via l'IDE .

## Consulter la documentation

Pour consulter la doc: [ici](http://localhost:8080/api/swagger-ui/index.html)

![documentation](images/swagger-example.png)

## Monitorer l'application

Pour monitorer l'application, nous utilisons la librairie `spring actuator` qui permet d'exposer des endpoints de suivi
de santé de l'application tel que l'endpoint `/health` qui permet de savoir si l'application est démarré.

Les endpoints de monitoring sont disponibles depuis le port exposé 13520

exemple:

```
GET http://localhost:13520/actuator/health

code http 200 OK

{
    "status": "UP"
}
```