public class Somador {
    static int somaTotal = 0;

    public static int valorCarta(String carta) {
        switch (carta) {
            case "J":
            case "Q":
            case "K":
                int bruxas = 10;
                return bruxas;
            case "A":
                return 11;
            default:
                return Integer.parseInt(carta); //o valor da carta será o valor gerado
        }
    }
}