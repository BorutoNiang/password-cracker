// Centralise la création des crackers : le programme principal
// ne doit jamais faire "new DictionaryHashCracker()" ou "new BruteForceHashCracker()" lui-même.
public class HashCrackerFactory {

    public static HashCracker create(String methode) {

        if (methode.equals("DICO")) {
            return new DictionaryHashCracker();
        }

        if (methode.equals("BRUTE")) {
            return new BruteForceHashCracker();
        }

        throw new IllegalArgumentException("Méthode inconnue : " + methode + " (BRUTE ou DICO attendu)");
    }
}
