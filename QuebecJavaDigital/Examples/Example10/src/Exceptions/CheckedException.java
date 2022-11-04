package Exceptions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.swing.JOptionPane;

public class CheckedException {
    public static void main(String[] args) {
        String nomeArquivo = "romances-blake-crouch.txt";
        try {
            imprimirArquivoConsole(nomeArquivo);
        } catch (IOException e) {
            //e.printStackTrace();
            if (e instanceof FileNotFoundException)
                JOptionPane.showMessageDialog(null, "Revise o nome do arquivo que você deseja imprimir.\n" + e.getMessage());
            if (e instanceof IOException)
                JOptionPane.showMessageDialog(null, "Ocorreu algum outro erro de E/S.\n" + e.getMessage());
        } finally {
            System.out.println("Chegou no FINALLY!");
        }

        System.out.println("Apesar da exception ou não, o programa continua...");
    }

    public static void imprimirArquivoConsole(String nomeArquivo) throws IOException {
        File file = new File(nomeArquivo);
        
        BufferedReader br = new BufferedReader(new FileReader(file.getName()));
        String line = br.readLine();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        do {
            bw.write(line);
            bw.newLine();
            line = br.readLine();
        } while (line != null);
        bw.flush();
        br.close();
    }
}
