import java.io.File;
import java.util.Scanner;

// Essaie chaque mot du fichier dictionnaire, un par un.
public class DictionaryHashCracker implements HashCracker {

    private static final String FICHIER_DICTIONNAIRE = "dictionnaire.txt";

    public String crack(String hash) {
        try {
            Scanner lecteur = new Scanner(new File(FICHIER_DICTIONNAIRE));

            while (lecteur.hasNextLine()) {
                String motCandidat = lecteur.nextLine().trim();

                if (motCandidat.isEmpty()) {
                    continue;
                }

                if (HashUtils.md5(motCandidat).equalsIgnoreCase(hash)) {
                    lecteur.close();
                    return motCandidat;
                }
            }

            lecteur.close();

        } catch (Exception e) {
            System.out.println("Erreur : dictionnaire introuvable (" + FICHIER_DICTIONNAIRE + ")");
        }

        return null;
    }
}
