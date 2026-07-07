import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Stratégie de cassage par dictionnaire.
 * Charge un fichier de mots et compare leur hash MD5 au hash cible.
 */
public class DictionaryHashCracker implements HashCracker {

    private static final String DICT_PATH = "dictionary.txt";

    @Override
    public String crack(String hash) {
        long attempts = 0;
        long start = System.currentTimeMillis();

        try (BufferedReader reader = new BufferedReader(new FileReader(DICT_PATH))) {
            String word;
            while ((word = reader.readLine()) != null) {
                word = word.trim();
                if (word.isEmpty()) continue;
                attempts++;
                if (MD5Util.hash(word).equals(hash)) {
                    long elapsed = System.currentTimeMillis() - start;
                    System.out.printf("Tentatives : %d | Temps : %d ms%n", attempts, elapsed);
                    return word;
                }
            }
        } catch (IOException e) {
            System.err.println("Erreur lecture dictionnaire : " + e.getMessage());
        }

        long elapsed = System.currentTimeMillis() - start;
        System.out.printf("Tentatives : %d | Temps : %d ms%n", attempts, elapsed);
        return null;
    }
}
