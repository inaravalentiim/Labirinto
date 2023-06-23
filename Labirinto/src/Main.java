import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.print("Digite o nome do arquivo do labirinto: ");
	        String fileName = sc.nextLine();
	        Labirinto l = new Labirinto();
	        char[][] labirinto = l.carregaLabirinto(fileName);
	        boolean resultado = l.labirinto();
	        try {
	            BufferedWriter bw = new BufferedWriter(new FileWriter("saidaLabirinto.txt"));
	            if (resultado) {
	                bw.write("Existe um caminho para o labirinto");
	            } else {
	                bw.write("Não existe um caminho para o labirinto");
	            }
	            bw.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}
