// Contrat commun : toute stratégie de cassage doit savoir faire ceci.
public interface HashCracker {
    String crack(String hash);
}
