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

## Dockerfile

Un fichier Dockerfile a été créé permettant de construire l'image Docker de notre application

###Que fait le Dockerfile ? 

L'image utilisé comme base est maven:3.8.4-openjdk-11

Il éxécute ensuite les commandes suivante : 
- apt-get update
- mvn clean package

Enfin, il éxécute le fichier jar généré via la commande : 
- java -jar login-0.0.1-SNAPSHOT.jar

## Docker-compose

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


# Lancer l'application sur une Ec2 aws avec terraform et ansible
_________________________________

La clé d'accès et la clé secret
La clé d'accès et la clé secret sont des clé fournis par AWS

Accéder à votre dashboard AWS de votre compte. Vous trouverez l'access key et la secret key dans --> Mes informations d'identification de sécurité --> informations d'identification AWS IAM Vous devriez voir un bouton nommé Créer une clé d'accès, cliquez desssus pour créer une clé d'accès. Afficher la clé secret et sauvegarder là ! Si vous la perdez vous ne pourrez pas la récupérer il vous faudra re créer une autre clé dans ce cas.

Vous avez maintenant l'access key ( la clé d'accès étant l'ID de clé d'accès dans l'interface AWS ) et la secret key.

La clé SSH public/privé
Pour la clé ssh il faudra la généré vous même. Pour linux, ssh-keygen est déjà installé par défaut. Il vous suffit de faire la commande : ssh-keygen -t rsa -b 2048 et de répondre au choix qui seront affiché.

Vous pouvez laisser le chemin par défaut ou de spécifier un chemin specifique, à vous de voir. Pour la phrase vous pouvez laisser vide et valider.

Vous avez maintenant une clé ssh public et privé ! (vous les trouverez sous linux par défaut dans ~/.ssh/id_rsa ou dans le chemin que vous avez précisé).

## Executer Terraform
_________________________________

Récupérer le repository.
ouvrer dans un terminal ou une invite de commande le dossier terraform du repository
exécuter la commande terraform init
exécuter la commande terraform apply. La commande va vous demandez de fournir dans l'ordre : l'access key, la clé ssh PUBLIQUE, et la clé secret
Attendez que la commande est terminé
Si tous c'est bien passé vous devriez voir à la fin le message : vm_public_id = xx.xx.xx.xx copier cette adresse ! (pas de panique si vous avez déjà clear votre terminal vous pouvez voir l'adresse ip v4 de votre instance sur le dashboard AWS)


## Configurer ansible
_________________________________

ouvrez le fichier ansible/inventory.yml dans un éditeur de texte.
modifier la ligne 0.0.0.0 par l'adresse ip public de votre vm récupèré précédement
modifier la ligne ansible_ssh_private_key_file par le chemin de votre clé ssh privé
Exécuter ansible
ouvrer dans un terminal ou une invite de commande le dossier ansible du repository
exécuter la commande ansible-playbook -i inventory.yml playbook.yml
Attendez la fin de la commande
Accéder aux site
Pour accéder au site et vérifier que tout à bien fonctionner accéder via l'adresse ip public de votre vm (celle utiliser dans le fichier inventory.yml)

ATTENTION L'https n'est pas mis en place il faudra donc y accéder via http://L'ipPublicDeVotreVM

