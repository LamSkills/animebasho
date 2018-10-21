# Conception de la fonctionnalité du quiz

## Entités

* Quiz
* Question
* Proposition
* Réponse
* Utilisateur
* Partie

## Liens entre entités

* 1 quiz est composé de questions
* 1 quiz porte sur un anime
* 1 question a une liste de propositions
* 1 question a une seule proposition correcte
* 1 proposition est utilisée par une seule question
* 1 proposition peut être correcte ou non
* 1 utilisateur joue à une partie de quiz
* 1 utilisateur saisit une liste de réponses par partie de quiz
* 1 utilisateur saisit une seule réponse par question
* 1 utilisateur obtient un score par partie de quiz jouée
* 1 partie contient une liste de réponses de l'utilisateur

## Modèle Conceptuel de Données

- quiz
    - id (PK)
    - label
    
- question
    - id (PK)
    - quiz_id (FK)
    - label
    
- proposition
    - id (PK)
    - question_id (FK)
    - label
    - is_correct
    
- utilisateur
    - id (PK)
    - nom
    - prenom
    - email
    - password
    
- partie
    - id (PK)
    - quiz_id (FK)
    - utilisateur_id (FK)
    - score
    
- reponse
    - partie_id (PK + FK)
    - proposition_id (PK + FK)
    
## REST API

### CRUD Quiz

* GET : retourne un quiz avec ses questions et propositions
* POST : crée un quiz avec ses questions et propositions
* PUT : modifie le nom du quiz
* DELETE : supprime le quiz avec ses questions et propositions en cascade
