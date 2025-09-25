# Jogo-Blackjack-21-em-Java

Este projeto é uma implementação simples do jogo **BlackJack (21)** em Java, desenvolvida como atividade acadêmica.  
O objetivo é permitir que um jogador receba cartas aleatórias e acumule pontos, tentando chegar o mais próximo possível de 21 sem ultrapassá-lo.

---

## Funcionalidades

- Geração de cartas aleatórias (2 a 10, A, J, Q, K);
- Cálculo automático do valor das cartas (A=11, J/Q/K=10, demais são seu valor numérico);
- Acúmulo e exibição da soma total de pontos;
- Lógica básica de rodadas para simular o jogo.

---

## Estrutura do Projeto
src/
├─ Cartas.java # Responsável por gerar cartas aleatórias
├─ Somador.java # Responsável por somar os valores das cartas e armazenar o total
├─ Rodada2.java # Controla a lógica de rodadas do jogo
└─ Main.java # Classe principal; inicia o jogo

