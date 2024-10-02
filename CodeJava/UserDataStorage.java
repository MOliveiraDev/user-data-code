import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Date;

public class UserDataStorage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Coleta de dados do usuário
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();
        
        System.out.print("Digite seu email: ");
        String email = scanner.nextLine();
        
        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();

        // Verificar se o nome ou email já existe
        if (isNameOrEmailTaken(nome, email)) {
            System.out.println("Este nome ou email já está em uso. Por favor, escolha outro.");
        } else {
            // Ao executar, irá criar um arquivo em user_data.txt para armazenar os dados, conforme o código pedir as instruções nescessárias 
            try (FileWriter writer = new FileWriter("user_data.txt", true)) {
                Date timer = new Date();
                writer.write("-------------------------\n");
                writer.write("Data de cadastro: " + timer.toString() + "\n");
                writer.write("Nome: " + nome + "\n");
                writer.write("Email: " + email + "\n");
                writer.write("Senha: " + senha + "\n");
                writer.write("-------------------------\n");
                System.out.println("Cadastro feito com sucesso!");
            } catch (IOException e) {
                System.out.println("Ocorreu um erro ao fazer o cadastro: " + e.getMessage());
            }
        }

        scanner.close();
    }

    // Este código faz com que ao verificar se o nome ou email já existe no arquivo, não será feito o cadastro
    private static boolean isNameOrEmailTaken(String nome, String email) {
        try (BufferedReader reader = new BufferedReader(new FileReader("user_data.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Verificar se a linha contém o nome ou email
                if (line.contains("Nome: " + nome) || line.contains("Email: " + email)) {
                    return true;  // Nome ou email já está em uso
                }
            }
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao ler os dados: " + e.getMessage());
        }
        return false;  // Nome ou email não encontrado
    }
}

