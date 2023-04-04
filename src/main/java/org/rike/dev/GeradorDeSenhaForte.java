package org.rike.dev;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;


public class GeradorDeSenhaForte {
    private String senhaAtual;
    private String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+";
    public String geraSenha(String senhaAtual){
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] senha = senhaAtual.getBytes();
            byte[] hash = md.digest(senha);
            String hashHex = new BigInteger(1, hash).toString(16);
            System.out.println("senha segura em hash agora é " + hashHex);
            //senhaAtual = hashHex;

            StringBuilder senhaForte = new StringBuilder();

            for(byte b : hash) {
                int index = Math.abs(b) % caracteres.length();
                senhaForte.append(caracteres.charAt(index));
            }
            Random random = new Random();
            while (senhaForte.length() < 16) {
                int index = random.nextInt(caracteres.length());
                senhaForte.append(caracteres.charAt(index));
            }
            senhaAtual = senhaForte.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        System.out.println(senhaAtual);
        return senhaAtual;
    }


}
