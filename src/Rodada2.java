import java.util.*;

public class Rodada2 {
    static List<String> cartasJogador = new ArrayList<>();
    static List<String> cartasDealer = new ArrayList<>();
    static boolean jogadorEstourou = false;
    static boolean jogadorParou = false;
    static boolean fimDaRodada = false;

    public static int calcularSoma(List<String> cartas) {
        int soma = 0;
        int ases = 0;

        for (String carta : cartas) {
            int valor = Somador.valorCarta(carta);
            soma += valor;
            if (carta.equals("A")) ases++;
        }

        // Corrige valores dos Ases (11 -> 1) se estourar
        while (soma > 21 && ases > 0) {
            soma -= 10;
            ases--;
        }

        return soma;
    }

    public static void iniciarRodada() {
        cartasJogador.clear();
        cartasDealer.clear();
        jogadorEstourou = false;
        jogadorParou = false;
        fimDaRodada = false;

        cartasJogador.add(Cartas.gerarCartaAleatoria());
        cartasJogador.add(Cartas.gerarCartaAleatoria());

        cartasDealer.add(Cartas.gerarCartaAleatoria());
        cartasDealer.add(Cartas.gerarCartaAleatoria());

        System.out.println("--------------- Nova Rodada ---------------");
        System.out.println("Sua mão: " + cartasJogador + " (Soma: " + calcularSoma(cartasJogador) + ")");
        System.out.println("Mão do Dealer: [ " + cartasDealer.get(0) + " ][ ? ]");
    }

    public static void jogarMais() {
        String novaCarta = Cartas.gerarCartaAleatoria();
        cartasJogador.add(novaCarta);
        int soma = calcularSoma(cartasJogador);

        System.out.println("\nFoi recebido: [ " + novaCarta + " ]");
        System.out.println("\nSua mão: " + cartasJogador + " (Soma: " + soma + ")");

        if (soma == 21) {
            System.out.println("\nBlackjack!!\n");
            jogadorParou = true;
        } else if (soma > 21) {
            System.out.println("\nEstourou!!\n");
            jogadorEstourou = true;
            jogadorParou = true;
        }
    }

    public static void vezDoDealer() {
        System.out.println("------------- Vez do Dealer -------------");
        System.out.println("Dealer revela sua carta oculta...");
        System.out.println("Mão do Dealer: " + cartasDealer + " (Soma: " + calcularSoma(cartasDealer) + ")");

        while (calcularSoma(cartasDealer) < 17) {
            String novaCarta = Cartas.gerarCartaAleatoria();
            cartasDealer.add(novaCarta);
            System.out.println("\nDealer comprou: [ " + novaCarta + " ] (Nova soma: " + calcularSoma(cartasDealer) + ")");
        }

        System.out.println("\nDealer não pode mais comprar e finaliza a jogada com: " + cartasDealer + " (Soma: " + calcularSoma(cartasDealer) + ")");
    }

    public static void verificarResultadoFinal() {
        int somaJogador = calcularSoma(cartasJogador);
        int somaDealer = calcularSoma(cartasDealer);

        if (somaJogador > 21) {
            System.out.println("\nVocê estourou!! Dealer venceu, mais sorte na próxima...");
        } else if (somaDealer > 21) {
            System.out.println("\nDealer estourou!! Você venceu!!!");
        } else if (somaJogador > somaDealer) {
            System.out.println("\nVocê venceu!!");
        } else if (somaJogador < somaDealer) {
            System.out.println("\nDealer venceu!!");
        } else {
            System.out.println("\nEmpate!!!");
        }

        fimDaRodada = true;


    }

}
