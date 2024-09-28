import java.io.FileWriter;
import java.io.IOException;

public class ClearUserData {
    public static void main(String[] args) {
        try (FileWriter writer = new FileWriter("user_data.txt")) {
            // Escrever uma string vazia para limpar o arquivo
            writer.write("");
            System.out.println("Todos os dados foram apagados com sucesso!");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao limpar os dados: " + e.getMessage());
        }
    }
}

