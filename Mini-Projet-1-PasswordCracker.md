Mini-Projet 1 -- PasswordCracker v1 Mise en œuvre du patron Simple
Factory 1. Contexte Dans le domaine de la cybersécurité, les mots de
passe ne sont généralement pas stockés en clair dans les bases de
données. Ils sont transformés à l'aide de fonctions de hachage
cryptographiques. Lors d'un audit de sécurité, il peut être nécessaire
de vérifier la robustesse des mots de passe utilisés en tentant de
retrouver un mot de passe à partir de son empreinte (hash). L'objectif
de ce mini-projet est de développer une première version d'un outil
nommé PasswordCracker permettant de retrouver un mot de passe à partir
de son hash MD5. Cette première version devra être conçue en utilisant
le patron de création Simple Factory. 2. Objectifs pédagogiques À
l'issue de ce mini-projet, vous devrez être capables de : Concevoir une
architecture orientée objet modulaire ; Utiliser le polymorphisme ;
Mettre en œuvre le patron Simple Factory ; Développer une application en
ligne de commande ; Comprendre les avantages et les limites d'une
fabrique simple. 3. Présentation du logiciel Le programme développé
s'appelle passwordCracker. Il reçoit : une méthode de cassage BRUTE pour
une attaque par brute force DICO pour celle par dictionnaire un hash MD5
Exemples : passwordCracker -m BRUTE -h e7247759c1633c0f9f1485f3690294a9
tp1.md 2026-06-13 1 / 6

passwordCracker -m DICO -h e7247759c1633c0f9f1485f3690294a9 Résultat
attendu : Password found: test ou Password not found Toute information
pertinente pourra également être affichées (temps d'exécution, nombre de
tentatives, etc.) 4. Fonctionnalités attendues 4.1 Cassage par
dictionnaire Le programme charge un dictionnaire contenant une liste de
mots. Exemple : bonjour secret admin password azerty Pour chaque mot
: 1. Calculer son hash MD5 ; 2. Comparer au hash recherché ; 3.
Retourner le mot correspondant. 4.2 Cassage par force brute Le programme
génère automatiquement toutes les combinaisons possibles. Alphabet :
tp1.md 2026-06-13 2 / 6

abcdefghijklmnopqrstuvwxyz Longueur maximale : 4 caractères Exemples : a
b ... aa ab ... test Chaque combinaison doit être testée jusqu'à trouver
une correspondance. 5. Architecture imposée 5.1 Interface commune Toutes
les stratégies doivent implémenter l'interface suivante : public
interface HashCracker { String crack(String hash); } La méthode retourne
: le mot de passe trouvé ; null si aucun résultat n'est obtenu. 5.2
Stratégies concrètes DictionaryHashCracker Recherche dans un
dictionnaire. tp1.md 2026-06-13 3 / 6

BruteForceHashCracker Recherche exhaustive. 5.3 Fabrique simple Les
objets doivent être créés à travers une fabrique unique. public class
HashCrackerFactory { public static HashCracker create(String method) {
... } } Exemple : HashCracker cracker =
HashCrackerFactory.create("DICO"); 6. Diagramme UML attendu HashCracker
crack(hash:String):String DictionaryHashCracker BruteForceHashCracker
HashCrackerFactory create(method:String):HashCracker 7. Contraintes Les
règles suivantes doivent être respectées : Le programme doit être écrit
en Java. Les classes concrètes ne doivent pas être instanciées
directement dans le programme principal. La création des objets doit
être centralisée dans la fabrique. Les duplications de code doivent être
évitées. tp1.md 2026-06-13 4 / 6

8.  Travail demandé Partie 1 : Analyse & Conception Produire : un
    diagramme UML ; une description des responsabilités des classes.
    Partie 2 : Développement Implémenter : les stratégies ; la fabrique
    ; l'application console. Partie 3 : Validation Tester les
    différentes stratégies sur plusieurs exemples.
9.  Livrables Le code du projet devra être hébergé dans un dépot
    publique sur GitHub. Le fichier README du dépôt devra contenir le
    rapport technique contenant les sections suivantes :
10. Introduction ;
11. Présentation du problème ;
12. Architecture ;
13. Diagramme UML ;
14. Usage du patron Simple Factory ;
15. Résultats obtenus ;
16. Difficultés rencontrées ;
17. Conclusion. La section Résultats obtenus devra également inclure,
    directement ou sous forme de lien, la vidéo de présentation de
    l'exécution de l'outil. Cette dernière devra durer au maximum dix
    minutes.
18. Questions de réflexion
19. Quels avantages apporte la fabrique simple ?
20. Quels sont ses inconvénients ?
21. Que faut-il modifier lorsqu'une nouvelle stratégie est ajoutée ?
22. La fabrique respecte-t-elle le principe Open/Closed ? tp1.md
    2026-06-13 5 / 6

Préparation du mini-projet suivant Dans ce mini-projet, l'ajout d'une
nouvelle stratégie nécessite la modification de la classe
HashCrackerFactory. Cette limitation sera étudiée et corrigée dans le
mini-projet suivant. tp1.md 2026-06-13 6 / 6
