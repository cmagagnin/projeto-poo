import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CriarCSV {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> cabecalhos = new ArrayList<>();
        List<List<String>> dados = new ArrayList<>();

        // Solicita ao usuário que informe o nome das colunas
        System.out.println("Informe o nome de pelo menos três colunas (digite 'fim' para terminar):");
        while (true) {
            String coluna = scanner.nextLine();
            if (coluna.equalsIgnoreCase("fim")) {
                if (cabecalhos.size() >= 3) {
                    break;
                } else {
                    System.out.println("Você deve informar no mínimo três colunas. Continue informando:");
                    continue;
                }
            }
            cabecalhos.add(coluna);
        }

        // Inicializa a estrutura de dados com listas para cada coluna
        for (int i = 0; i < cabecalhos.size(); i++) {
            dados.add(new ArrayList<>());
        }

        // Solicita ao usuário os dados para cada coluna, linha por linha
        System.out.println("Informe os dados para cada linha. Digite 'fim' para parar de adicionar dados.");
        boolean continuarInserindo = true;
        while (continuarInserindo) {
            for (int i = 0; i < cabecalhos.size(); i++) {
                System.out.println("Informe o dado para a coluna '" + cabecalhos.get(i) + "': ");
                String entrada = scanner.nextLine();
                if (entrada.equalsIgnoreCase("fim")) {
                    continuarInserindo = false;
                    break;
                }
                dados.get(i).add(entrada);
            }
        }

        // Define o caminho e o nome do arquivo CSV
        String nomeArquivo = "dados.csv";

        // Cria o arquivo CSV com os dados fornecidos pelo usuário
        try (FileWriter escritor = new FileWriter(nomeArquivo)) {
            // Escreve o cabeçalho no arquivo CSV
            for (int i = 0; i < cabecalhos.size(); i++) {
                escritor.append(cabecalhos.get(i));
                if (i < cabecalhos.size() - 1) {
                    escritor.append(";");
                }
            }
            escritor.append("\n");

            // Determina o número máximo de linhas de dados
            int numLinhas = dados.get(0).size();

            // Escreve os dados no arquivo CSV linha por linha
            for (int i = 0; i < numLinhas; i++) {
                for (int j = 0; j < cabecalhos.size(); j++) {
                    escritor.append(dados.get(j).get(i));
                    if (j < cabecalhos.size() - 1) {
                        escritor.append(";");
                    }
                }
                escritor.append("\n");
            }

            System.out.println("Arquivo CSV criado com sucesso: " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao criar o arquivo CSV: " + e.getMessage());
        }

        scanner.close();
    }
}
