Author : *MUAKA NSILULU Joel & Diakite Aboubakar Siriki*
----------------------------------------------------------------

Projet : *COMPETITIONS SPORTIVES V2*
-------------------------------------

*Retour sur la V1*
--------------------

Dans la premiere version du projet, il était impossible de lancer deux compétitions différentes avec les mêmes compétiteurs car certains compétiteurs débutaient une compétition avec plus de points que d'autres. Alors pour gérer ce problème, il nous a été proposé de remettre à 0 les points de tous les compétiteurs avant le début d'une compétition. Et ce problème a été géré grâce à une fonction `initPoint` qui (ré)initialise les points d'un compétiteur.

*Présentation du projet V2*
-----------------------------

Le projet `COMPETITIONS SPORTIVES V2` est une version améliorée de la version 1, dans laquelle il n'y avait que le championnat et le tournois comme compétitions. Dans cette version, au-delà de ces deux types de compétitions, s'ajoute le Master, qui lui est un combiné des plusieurs championnats appelés ici phase des poules et d'un tournois final à élimination directe.

Le passage intermédiaire de la phase des poules à la phase finale est animé par une selection des finalistes dont la methode est définie au commencement de la compétition (Master). Quelle que soit  la méthode de sélection utilisée, le nombre de compétiteurs accédant à la phase finale doit être une puissance de 2. Dans cette version, nous proposons 3 méthodes de selection à savoir; la méthode de selection des premiers de toutes les poules, celle de selection des deux premiers de chaque poule puis celle qui selectionne les deux premiers de chaque poule ainsi que les deux meilleurs troisièmes de toutes les poules confondues.

Le vainqueur du Master est le compétiteur finissant vainqueur de la phase finale.  Ce n’est donc pas nécessairementle compétiteur qui a le plus de victoires qui remporte le tournoi, puisque un compétiteur peut terminer premier desa poule en ayant moins de points que le premier d’une autre poule.

*Pour commencer*
------------------

On ouvre un terminal et on se place dans le dossier où l'on veut copier le projet puis on exécute la commande :

		git clone https://gitlab-etu.fil.univ-lille1.fr/muakansilulu/muaka_nsilulu_joel-diakite_siriki_aboubakar-coo.git


Le dossier tp1 est considéré maintenant comme étant la racine du projet.

*Génération de la documentation*
-------------------------------

Pour générer la documentation du *package competition*, on se place dans la racine du projet, on crée le dossier docs en executant la commande suivante:
		mkdir docs
Puis on se place dans le dossier src et on exécute:
		javadoc competition -d ../docs


*Consultation de la documentation*
-----------------------------------


Pour consulter la documentation, on se place dans le dossier docs et on ouvre le fichier index.html dans un navigateur.

*Compiler les sources du projet*
----------------------------------

Pour compiler toutes les sources du projets et placer les fichiers .class dans le dossier classes, on se place dans le dossier src et on exécute la commande suivante:

		javac competition/*.java competition/methode/*.java util/MapUtil.java io/*.java -d ../classes
Ensuite pour les compiler dans le dossier courant, on exécute :
		javac competition/*.java competition/methode/*.java util/MapUtil.java io/*.java



*Compiler les tests*
----------------------


On se place dans la racine du projet avec l'existance du dossier classes puis on exécute à tour de rôle les deux commandes (pour compiler les tests respectivement dans le dossier classes et le dossier tests) :

		javac -d classes/ -cp test-1.7.jar:class -sourcepath src:test test/competition/*.java
		javac -cp test-1.7.jar:class -sourcepath src:test test/competition/*.java


*Exécution des tests*
-----------------------

Pour exécuter les tests, après les avoir compiler, on se place dans la racine du projet puis on exécute :
Puis,placez-vous à la racine du projet dans uin terminal.
Exécuter la commande suivante:

Pour Competitor :

		java -jar test-1.7.jar competition.CompetitorTest

Pour Match :

                java -jar test-1.7.jar competition.MatchTest

Pour Tournament :

		java -jar test-1.7.jar competition.TournamentTest

Pour League :

		java -jar test-1.7.jar competition.LeagueTest

Pour Master :

		java -jar test-1.7.jar competition.MasterTest

Pour la méthode SelectFirst :

		java -jar test-1.7.jar competition.SelectFirstTest

Pour la méthode SelectFirstTwo

		java -jar test-1.7.jar competition.SelectFirstTwoTest

Pour la méthode SelectFirstTwoAndBestThirds

		java -jar test-1.7.jar competition.SelectFirstTwoAndBestThirdsTest



*Exécution du programme sans le jar exécutable*
------------------------------------------------

Pour exécuter le programme sans le fichier jar, après avoir compiler toutes les sources du projet, on se place dans src, et on exécute :

Pour League :

		java competition.LeagueMain

Pour Tournament :

		java competition.TournamentMain

Pour Master :

		java competition.MasterMain

*Génération du fichier .jar*
-----------------------------
Pour générer le fichier .jar, on se place dans le dossier classes puis on exécute :

Pour League :

		jar cvfm ../League.jar ../manifest competition util io

Pour Tournament :

		jar cvfm ../Tournament.jar ../manifest1 competition util io

Pour Master :

		jar cvfm ../Master.jar ../manifest2 competition util io


*Exécution du programme avec le jar exécutable*
------------------------------------------------
Pour exécuter le programme avec le jar exécutable, on se place dans la racine du projet et on exécute :

Pour League :

		java -jar League.jar

Pour Tournament :

		java -jar Tournament.jar
		
Pour Master :

		java -jar Master.jar


