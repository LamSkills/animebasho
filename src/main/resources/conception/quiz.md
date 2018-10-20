# Conception de la fonctionnalité du quiz

## Entités

* Quiz
* Question
* Proposition
* Réponse
* Utilisateur
* Score

## Liens entre entités

* 1 quiz est composé de questions
* 1 quiz porte sur un anime
* 1 question a une liste de propositions
* 1 question a une seule proposition correcte
* 1 proposition est utilisée par une seule question
* 1 proposition peut être correcte ou non
* 1 utilisateur joue à une liste de quiz
* 1 utilisateur saisit une liste de réponses par quiz
* 1 utilisateur saisit une seule réponse par question
* 1 utilisateur obtient un score par quiz
* 1 utilisateur a une liste de scores par quiz

## Entité Quiz

- quiz
    - id (PK)
    - label
    
- question
    - id (PK)
    - quiz_id (FK)
    - label
    
-proposition
    - id (PK)
    - question_id (FK)
    - label
    - is_correct