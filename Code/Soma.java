public class Soma {
    public static void main(String[] args) 
    {
       var soma = 10 + 10;

        System.out.println(soma + " Isto é a soma de 10 + 10");
        Calcular(15, 15 ); //Argumentos 


    }

    static void Calcular(int x, int y)
    {
        //Static void > Declaração padrão.
        //Sum > Nome da função (pode ser qualquer outro nome).
        //() >Parenteses usamos para definir o que chegará naquela função, no caso se chama parâmetros.

        System.out.println(x + y + " Isto é a soma de 15 + 15");
    }

}
    