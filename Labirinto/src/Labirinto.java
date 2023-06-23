import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Labirinto {
	 private char[][] labirinto;
	    private int linhas;
	    private int colunas;
	    
	    public char[][] carregaLabirinto(String fileName) {
	        try {
	            BufferedReader br = new BufferedReader(new FileReader(fileName));
	            linhas = Integer.parseInt(br.readLine());
	            colunas = Integer.parseInt(br.readLine());
	            labirinto = new char[linhas][colunas];
	            for (int i = 0; i < linhas; i++) {
	                String linha = br.readLine();
	                for (int j = 0; j < colunas; j++) {
	                    labirinto[i][j] = linha.charAt(j);
	                }
	            }
	            br.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return labirinto;
	    }
	    
	    public boolean labirinto() {
	        return labirinto(0, 0);
	    }
	    
	    private boolean labirinto(int i, int j) {
	        if (i < 0 || j < 0 || i >= linhas || j >= colunas) {
	            return false;
	        }
	        if (labirinto[i][j] == 'D') {
	            return true;
	        }
	        if (labirinto[i][j] == 'X') {
	            return false;
	        }
	        labirinto[i][j] = 'X';
	        if (labirinto(i + 1, j) || labirinto(i, j + 1) || labirinto(i - 1, j) || labirinto(i, j - 1)) {
	            return true;
	        }
	        return false;
	    }
}
