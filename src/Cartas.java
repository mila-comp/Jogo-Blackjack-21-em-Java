import java.util.Random;

public class Cartas {
    public static String[] valores = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "A", "J", "Q", "K"};
    public static Random random = new Random();
    public static String ultimoValorGerado; // ← armazena a última carta

    public static String gerarCartaAleatoria() {
        int indice = random.nextInt(valores.length);
        return valores[indice];
    }
}

    
    
