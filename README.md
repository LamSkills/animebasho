# AnimeBasho ! _(projet personnel)_

## Etapes à suivre pour lancer le projet

* cloner le projet depuis GitHub

```sh
git clone https://github.com/LamSkills/animebasho.git
```

* lancer le projet
    - en ligne de commandes
    ```sh
    mvn spring-boot:run
    ```

    - en créant une configuration depuis un IDE
    
## Conception de l'application

Un document abordant la conception de la fonctionnalité est présent dans le projet : 
animebasho/src/main/resources/conception/quiz.md
    
## Application

### Base de données en mémoire H2

Aller à l'URL http://localhost:8080/h2

### Swagger de l'API

Aller à l'URL http://localhost:8080/swagger-ui.html

Dessus, les services disponibles sont consultables.

## Ce qu'on peut faire

* consulter un quiz déjà créé lors du lancement de l'application
* sauvegarder une partie jouée
* récupérer la partie précédemment sauvegardée et consulter son score