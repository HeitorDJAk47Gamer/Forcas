import java.util.Scanner;

public class JogoDaForca {
    private String palavra;
    private char[] letrasDescobertas;
    private int chances;

    public JogoDaForca(String palavra) {
        this.palavra = palavra.toUpperCase();
        this.letrasDescobertas = new char[palavra.length()];
        this.chances = 6;
    }

    public void jogar() {
        Scanner scanner = new Scanner(System.in);
        boolean jogoTerminado = false;

        while (!jogoTerminado) {
            exibirPalavraAtual();
            System.out.println("Chances restantes: " + chances);
            System.out.print("Digite uma letra: ");
            char letra = scanner.nextLine().toUpperCase().charAt(0);

            if (!verificarLetra(letra)) {
                chances--;
                System.out.println("Letra incorreta!");
            }

            if (chances == 0) {
                exibirPalavraAtual();
                System.out.println("Você perdeu! A palavra correta era: " + palavra);
                jogoTerminado = true;
            } else if (palavraCompleta()) {
                exibirPalavraAtual();
                System.out.println("Parabéns, você venceu!");
                jogoTerminado = true;
            }

            System.out.println();
        }

        scanner.close();
    }

    private void exibirPalavraAtual() {
        for (int i = 0; i < palavra.length(); i++) {
            char letra = palavra.charAt(i);
            if (letra == ' ') {
                System.out.print("  ");
            } else if (letrasDescobertas[i] == letra) {
                System.out.print(letra + " ");
            } else {
                System.out.print("_ ");
            }
        }
        System.out.println();
    }

    private boolean verificarLetra(char letra) {
        boolean letraEncontrada = false;

        for (int i = 0; i < palavra.length(); i++) {
            if (palavra.charAt(i) == letra) {
                letrasDescobertas[i] = letra;
                letraEncontrada = true;
            }
        }

        return letraEncontrada;
    }

    private boolean palavraCompleta() {
        for (int i = 0; i < palavra.length(); i++) {
            if (letrasDescobertas[i] != palavra.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        JogoDaForca jogo = new JogoDaForca("PROGRAMACAO");
        jogo.jogar();
    }
}