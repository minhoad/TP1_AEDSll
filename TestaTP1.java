import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestaTP1 {
	public static void main (String[] args) throws Exception {
		ArvorePatricia arvore_praticia_texto1 = new ArvorePatricia (128);
		ArvorePatricia arvore_praticia_texto2 = new ArvorePatricia (128);
		String delim = "delim.txt";
		String texto = "in.txt";
		String texto2 = "in2.txt";
		
		ExtraiPalavra palavras = new ExtraiPalavra (delim, texto);
		ExtraiPalavra palavras2 = new ExtraiPalavra (delim, texto2);
		String palavra = null; 
		String palavra2 = null; 
		
		// Adicionando as palavras na árvore patricia
		while ((palavra = palavras.proximaPalavra()) != null) {
			if(palavra.length()<16) {
				while(palavra.length()<16) {
					palavra = palavra +" ";
				}
			}
			arvore_praticia_texto1.insere(palavra);
		}

		while ((palavra2 = palavras2.proximaPalavra()) != null) {
			if(palavra2.length()<16) {
				while(palavra2.length()<16) {
					palavra2 = palavra2 +" ";
				}
			}
			arvore_praticia_texto2.insere(palavra2);
		}
		////////////////////////////////////////////////
		
		palavras.fecharArquivos();   
		palavras2.fecharArquivos();  

		//palavras pré definidas
		String[] palavrasTexto1 = {"trabalho","computacao","governo","educacao",
			"tecnologia","formacao","desenvolvimento","que","informatica","em","crise"};
		String[] palavrasTexto2 = {"sociedade","software","ideia","pessoa",
			"Informatica","etica","muito","ciencia","computacao","que","area","moral"}; 
		

		System.out.println("Palavras texto 1:\n");
		for(int i = 0; i < palavrasTexto1.length; i++) {
			String palavraBuscar = palavrasTexto1[i];
			
			// Palavras constituídas por menos de 16 caracteres devem ser preenchidas com um número apropriado de brancos
			if(palavraBuscar.length() < 16) {                                                      
				while(palavraBuscar.length() < 16) {
					palavraBuscar = palavraBuscar + " ";
				}
			}
		
			arvore_praticia_texto1.pesquisa(palavraBuscar);                                                           
			
			ExtraiPalavra posicoes = new ExtraiPalavra (delim, texto);
			String posicao = null;
			
			posicoes.setnLinhas(0);

			List <Integer> ocorreuLinha = new ArrayList<>();
			List <Integer> ocorreuColuna = new ArrayList<>();
			int linha = 0;
			int coluna = 1;
			int ocorrencia = 0;
			
			// Lê o arquivo procurando as ocorrencias e linhas e colunas da ocorrência capturada
			while ((posicao = posicoes.proximaPalavra()) != null) {
				if(posicao.toLowerCase().equals(palavrasTexto1[i].toLowerCase())) { // GARANTE QUE SE A PALAVRA COMEÇAR COM MAIUSCULO AINDA ENCONTRE
					ocorreuLinha.add(posicoes.getnLinhas());
					ocorreuColuna.add(coluna);
					ocorrencia++;
				}
				if(posicoes.getnLinhas() !=  linha) {
					linha = posicoes.getnLinhas();
					coluna = 1; 
				}
				else
					coluna++;
			}

			System.out.println("Numero de ocorrencias: " + ocorrencia); 
			System.out.println("ocorrencias (linha : coluna)");
			for(int count = 0; count < ocorreuLinha.size(); count++) {
					System.out.print(ocorreuLinha.get(count)+":"+ocorreuColuna.get(count));
					if(count != ocorreuLinha.size() - 1) {
						System.out.print(", ");
					}
			}
			System.out.println();
			System.out.println();
		}
		
		System.out.println("Palavras texto 2:\n");

		for(int i = 0; i < palavrasTexto2.length; i++) {
			String palavraBuscar = palavrasTexto2[i];
			
			// Palavras constituídas por menos de 16 caracteres devem ser preenchidas com um número apropriado de brancos
			if(palavraBuscar.length() < 16) {                                                      
				while(palavraBuscar.length() < 16) {
					palavraBuscar = palavraBuscar + " ";
				}
			}
		
			arvore_praticia_texto2.pesquisa(palavraBuscar);                                                            
			
			ExtraiPalavra posicoes = new ExtraiPalavra (delim, texto2);
			String posicao = null;
			
			posicoes.setnLinhas(0);
			
			List <Integer> ocorreuLinha = new ArrayList<>();
			List <Integer> ocorreuColuna = new ArrayList<>();
			int linha = 0;
			int coluna = 1;
			int ocorrencia = 0;
			
			// Lê o arquivo procurando as ocorrencias e linhas e colunas da ocorrência capturada
			while ((posicao = posicoes.proximaPalavra()) != null) {
				if(posicao.toLowerCase().equals(palavrasTexto2[i].toLowerCase())) {// GARANTE QUE SE A PALAVRA COMEÇAR COM MAIUSCULO AINDA ENCONTRE
					ocorreuLinha.add(posicoes.getnLinhas());
					ocorreuColuna.add(coluna);
					ocorrencia++;
				}
				if(posicoes.getnLinhas() !=  linha) {
					linha = posicoes.getnLinhas();
					coluna = 1;
				}
				else
					coluna++;
			}

			System.out.println("Num de ocorrencias: " + ocorrencia);
			System.out.println("ocorrencias (linha : coluna)");

			for(int count = 0; count < ocorreuLinha.size(); count++) {
				System.out.print(ocorreuLinha.get(count)+":"+ocorreuColuna.get(count));
				if(count != ocorreuLinha.size() - 1) {
					System.out.print(", ");
				}
			}
			System.out.println();
			System.out.println();
		}
		palavras.fecharArquivos();
		palavras2.fecharArquivos();    
	}
}