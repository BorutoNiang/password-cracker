// Essaie toutes les combinaisons de lettres a-z, de 1 à 4 caractères.
public class BruteForceHashCracker implements HashCracker {

    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public String crack(String hash) {

        // Longueur 1
        for (int a = 0; a < ALPHABET.length(); a++) {
            String motCandidat = "" + ALPHABET.charAt(a);
            if (HashUtils.md5(motCandidat).equalsIgnoreCase(hash)) {
                return motCandidat;
            }
        }

        // Longueur 2
        for (int a = 0; a < ALPHABET.length(); a++) {
            for (int b = 0; b < ALPHABET.length(); b++) {
                String motCandidat = "" + ALPHABET.charAt(a) + ALPHABET.charAt(b);
                if (HashUtils.md5(motCandidat).equalsIgnoreCase(hash)) {
                    return motCandidat;
                }
            }
        }

        // Longueur 3
        for (int a = 0; a < ALPHABET.length(); a++) {
            for (int b = 0; b < ALPHABET.length(); b++) {
                for (int c = 0; c < ALPHABET.length(); c++) {
                    String motCandidat = "" + ALPHABET.charAt(a) + ALPHABET.charAt(b) + ALPHABET.charAt(c);
                    if (HashUtils.md5(motCandidat).equalsIgnoreCase(hash)) {
                        return motCandidat;
                    }
                }
            }
        }

        // Longueur 4
        for (int a = 0; a < ALPHABET.length(); a++) {
            for (int b = 0; b < ALPHABET.length(); b++) {
                for (int c = 0; c < ALPHABET.length(); c++) {
                    for (int d = 0; d < ALPHABET.length(); d++) {
                        String motCandidat = "" + ALPHABET.charAt(a) + ALPHABET.charAt(b)
                                + ALPHABET.charAt(c) + ALPHABET.charAt(d);
                        if (HashUtils.md5(motCandidat).equalsIgnoreCase(hash)) {
                            return motCandidat;
                        }
                    }
                }
            }
        }

        return null; // rien trouvé jusqu'à 4 caractères
    }
}
