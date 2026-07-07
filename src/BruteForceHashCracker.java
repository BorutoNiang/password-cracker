/**
 * Stratégie de cassage par force brute.
 * Génère toutes les combinaisons de lettres minuscules jusqu'à 4 caractères.
 */
public class BruteForceHashCracker implements HashCracker {

    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static final int MAX_LENGTH = 4;

    @Override
    public String crack(String hash) {
        long attempts = 0;
        long start = System.currentTimeMillis();

        for (int length = 1; length <= MAX_LENGTH; length++) {
            String result = generate(hash, new char[length], 0);
            attempts += countCombinations(length);
            if (result != null) {
                long elapsed = System.currentTimeMillis() - start;
                System.out.printf("Tentatives : ~%d | Temps : %d ms%n", attempts, elapsed);
                return result;
            }
        }

        long elapsed = System.currentTimeMillis() - start;
        System.out.printf("Tentatives : ~%d | Temps : %d ms%n", attempts, elapsed);
        return null;
    }

    private String generate(String hash, char[] current, int position) {
        if (position == current.length) {
            String candidate = new String(current);
            if (MD5Util.hash(candidate).equals(hash)) {
                return candidate;
            }
            return null;
        }
        for (char c : ALPHABET.toCharArray()) {
            current[position] = c;
            String result = generate(hash, current, position + 1);
            if (result != null) return result;
        }
        return null;
    }

    // Calcule le nombre de combinaisons pour une longueur donnée (26^length)
    private long countCombinations(int length) {
        long count = 1;
        for (int i = 0; i < length; i++) count *= ALPHABET.length();
        return count;
    }
}
