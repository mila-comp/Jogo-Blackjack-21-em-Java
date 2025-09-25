import java.util.Scanner;

public class Main {
    public static void main(String args[]){

        Scanner teclado = new Scanner(System.in);

        Rodada2.iniciarRodada();
        while(!Rodada2.fimDaRodada){
            System.out.println("O que deseja fazer? (1- Hit, 2- Stand):");
            int opcao = teclado.nextInt();

            if (opcao == 1) {
                Rodada2.jogarMais();
                if (Rodada2.jogadorEstourou) {
                    Rodada2.vezDoDealer();
                    Rodada2.verificarResultadoFinal();
                }
            } else if (opcao == 2) {
                Rodada2.jogadorParou = true;
                Rodada2.vezDoDealer();
                Rodada2.verificarResultadoFinal();
            }

        }

    }
}
