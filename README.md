[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-718a45dd9cf7e7f842a935f5ebbe5719a5e09af4491e668f4dbf3b35d5cca122.svg)](https://classroom.github.com/online_ide?assignment_repo_id=7150248&assignment_repo_type=AssignmentRepo)
# Programme Dev. Objets S2 - Schtroumpfs

## Introduction

Veillez à avoir bien configuré Maven et Java

## Cloner

```
git clone https://github.com/IUT-Blagnac/r2-03-td4-maven-SlawerH.git
```
(Ou un autre repository, ou même Gitpod)

## Clean

Si besoin de repartir de zéro (suppression du dossier target)
```
mvn clean
```

## Compiler

Compilation des fichiers `*.java` dans `src/main/java` dans `target/classes/` (et plus)

```
mvn compile
```

## Package

Transformation en `.jar`.

```
mvn package
```

## Exécution

Pour exécuter le fichier `jar` créé

```
java -jar target/tp_qualite-1.0.jar
```

## Javadoc

Réaliser la commande suivante pour générer la javadoc (dans `target/site/apidocs/`)

[Plus d'informations](https://stackoverflow.com/questions/9971219/generate-javadoc-html-using-maven)
```
mvn javadoc:javadoc
```
