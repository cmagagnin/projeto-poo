package listadois;
import java.util.Scanner;;
public class Conversor {

    public static void main(String[] args) {
        Scanner opcao = new Scanner(System.in);
        System.out.println("Escolha a conversão desejada:");
        System.out.println("1. Conversão de números inteiros para romanos");
        System.out.println("2. Conversor de moedas");

        int escolha = opcao.nextInt();

        switch (escolha) {
            case 1:
                ConversorRomano conversorRomano = new ConversorRomano();
                System.out.print("Digite um número inteiro para converter em romano: ");
                int numero = opcao.nextInt();
                System.out.println("Número romano: " + conversorRomano.intParaRomano(numero));
                break;
                
            case 2:
                ConversorMoeda conversorMoeda = new ConversorMoeda();
                conversorMoeda.opcoesMoedas();
                
                System.out.print("Escolha a moeda de origem (Digite o número correspondente): ");
                int opcaoOrigem = opcao.nextInt();
                String moedaOrigem = conversorMoeda.obterMoeda(opcaoOrigem);
                
                System.out.print("Escolha a moeda de destino (Digite o número correspondente): ");
                int opcaoDestino = opcao.nextInt();
                String moedaDestino = conversorMoeda.obterMoeda(opcaoDestino);
                
                System.out.print("Digite o valor a ser convertido: ");
                double valor = opcao.nextDouble();
                
                double valorConvertido = conversorMoeda.converterMoeda(moedaOrigem, moedaDestino, valor);
                if (!moedaOrigem.equals("JPY")){
                    System.out.printf("%.2f %s é igual a %.2f %s%n.",valor, moedaOrigem, valorConvertido, moedaDestino);    
                }
                else {
                    System.out.printf("%.2f %s é igual a %.3f %s%n.",valor, moedaOrigem, valorConvertido, moedaDestino);
                }
                
                break;

            default:
                System.out.println("Opção inválida.");
        }

        opcao.close();
    }
}