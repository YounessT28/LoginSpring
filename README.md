# Spring MVC with SpringBoot
_____________________________________
Mise en oeuvre de Spring MVC avec Spring Boot

# Pages
_________________________________

L'appli regroupe 3 page simple :
- Page de connexion
- Page d'inscription
- Page de profil (affichant les éléments de connexion de la personne connecté)

![img](images/connexion.png)
![img](images/inscription.png)
![img](images/profil.png)

# Conteneurisation de l'application avec Docker
_________________________________

##Dockerfile

Un fichier Dockerfile a été créé permettant de construire l'image Docker de notre application

###Que fait le Dockerfile ? 

L'image utilisé comme base est maven:3.8.4-openjdk-11

Il éxécute ensuite les commandes suivante : 
- apt-get update
- mvn clean package

Enfin, il éxécute le fichier jar généré via la commande : 
- java -jar login-0.0.1-SNAPSHOT.jar

##Docker-compose

Ensuite, un fichier docker-compose.yml a été créé pour configurer le déploiement de deux services dans un container : 
- MariaDB
- Notre application

# Lancement de l'application
_________________________________

Prérequis : Avoir git et docker installé 

Dans un premier temps, clonez ce repo : git clone https://github.com/YounessT28/LoginSpring.git

Ouvrez ensuite un terminal bash dans le dossier du repo cloné et éxécutez les commande suivante : 
- docker-compose build
- docker-compose up

Patientez un peu et tapez sur votre navigateur : http://127.0.0.1/

La page de connexion s'affiche !

Retrouvez l'image qui a été créé sur Docker Hub : https://hub.docker.com/r/younesst/loginspring

