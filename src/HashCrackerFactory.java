/**
 * Fabrique simple pour créer les stratégies de cassage de hash.
 */
public class HashCrackerFactory {

    /**
     * Crée et retourne un HashCracker selon la méthode demandée.
     * @param method "BRUTE" ou "DICO"
     * @return l'instance correspondante
     */
    public static HashCracker create(String method) {
        switch (method.toUpperCase()) {
            case "BRUTE":
                return new BruteForceHashCracker();
            case "DICO":
                return new DictionaryHashCracker();
            default:
                throw new IllegalArgumentException("Méthode inconnue : " + method + ". Utilisez BRUTE ou DICO.");
        }
    }
}
