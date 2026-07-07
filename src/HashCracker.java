/**
 * Interface commune pour toutes les stratégies de cassage de hash.
 */
public interface HashCracker {
    /**
     * Tente de retrouver le mot de passe correspondant au hash MD5 donné.
     * @param hash le hash MD5 à casser
     * @return le mot de passe trouvé, ou null si aucun résultat
     */
    String crack(String hash);
}
