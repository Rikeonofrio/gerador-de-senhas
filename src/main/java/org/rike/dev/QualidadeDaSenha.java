package org.rike.dev;

public class QualidadeDaSenha {
    private String senhaAtual;
    private final int quantidadeCarecteres = 12;
    private int pontosDeSenha = 100;

    public int verificaSenha(String senhaAtual, int pontosDeSenha) {
        if (senhaAtual.length() <= 12) {
            pontosDeSenha = pontosDeSenha - 25;
        }
        System.out.println(pontosDeSenha);
        return pontosDeSenha;
    }

    public int comparacoesDeCaracteres(String senhaAtual, int pontosDeSenha) {
        int maiusculas = 0, minusculas = 0, numeros = 0;
        char[] caracteres = new char[senhaAtual.length()];
        for (int i = 0; i < senhaAtual.length(); i++) {
            char c = senhaAtual.charAt(i);
            if (Character.isUpperCase(c)) {
                maiusculas++;
            } else if (Character.isLowerCase(c)) {
                minusculas++;
            } else if (Character.isDigit(c)) {
                numeros++;
            }
        }
        if(minusculas > 6 || maiusculas >5 || numeros > 3){
            pontosDeSenha = pontosDeSenha - 25;
        }
        for (int i = 0; i < senhaAtual.length() - 1; i++) {
            if (senhaAtual.charAt(i) != senhaAtual.charAt(i+1)) {
                pontosDeSenha = pontosDeSenha - 10;
            }
        }
        System.out.println(pontosDeSenha);
        return pontosDeSenha;
    }
}
