import java.security.MessageDigest;

// Calcule le hash MD5 d'un mot. Utilisé par les deux stratégies.
public class HashUtils {

    public static String md5(String mot) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = md.digest(mot.getBytes());

            StringBuilder hexa = new StringBuilder();
            for (byte b : bytes) {
                hexa.append(String.format("%02x", b));
            }
            return hexa.toString();

        } catch (Exception e) {
            return null;
        }
    }
}
