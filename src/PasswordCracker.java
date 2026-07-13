/**
 * Usage :
 *   java PasswordCracker -m BRUTE -h <hash>
 *   java PasswordCracker -m DICO  -h <hash>
 */
public class PasswordCracker {

    public static void main(String[] args) {

        String methode = null;
        String hash = null;

        for (int i = 0; i < args.length - 1; i++) {
            if (args[i].equals("-m")) {
                methode = args[i + 1];
            }
            if (args[i].equals("-h")) {
                hash = args[i + 1];
            }
        }

        if (methode == null || hash == null) {
            System.out.println("Usage : java PasswordCracker -m <BRUTE|DICO> -h <hash_md5>");
            return;
        }

        try {
            HashCracker cracker = HashCrackerFactory.create(methode);

            long debut = System.currentTimeMillis();
            String motDePasse = cracker.crack(hash);
            long duree = System.currentTimeMillis() - debut;

            if (motDePasse != null) {
                System.out.println("Password found: " + motDePasse);
            } else {
                System.out.println("Password not found");
            }
            System.out.println("Temps d'execution : " + duree + " ms");

        } catch (IllegalArgumentException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}
