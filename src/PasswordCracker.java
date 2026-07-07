/**
 * Application principale du PasswordCracker.
 * Usage : passwordCracker -m BRUTE -h <hash>
 *         passwordCracker -m DICO  -h <hash>
 */
public class PasswordCracker {

    public static void main(String[] args) {
        String method = null;
        String hash = null;

        // Parsing des arguments
        for (int i = 0; i < args.length - 1; i++) {
            if ("-m".equals(args[i])) method = args[i + 1];
            if ("-h".equals(args[i])) hash   = args[i + 1];
        }

        if (method == null || hash == null) {
            System.err.println("Usage : passwordCracker -m <BRUTE|DICO> -h <hash_md5>");
            System.exit(1);
        }

        try {
            HashCracker cracker = HashCrackerFactory.create(method);
            String result = cracker.crack(hash);

            if (result != null) {
                System.out.println("Password found: " + result);
            } else {
                System.out.println("Password not found");
            }
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }
}
