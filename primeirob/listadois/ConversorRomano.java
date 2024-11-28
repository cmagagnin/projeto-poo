package listadois;

public class ConversorRomano {
    public String intParaRomano(int num) {
        if (num < 1 || num > 3999) {
            return "Número fora do intervalo (1-3999)";
        }
        
        String[] milhares = {"", "M", "MM", "MMM"}; // Array de mmilhares, 
        String[] centenas = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"}; // Array de cetenas
        String[] dezenas = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"}; // Array de de dezenas
        String[] unidades = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"}; // Array de unidades,
        
        return milhares[num / 1000] + // Divisão de num pra ver se é divisivel por 1000, Ex: 1001 imprime o indice 1 do array milhares "M" se fosse menor que 1000 iria utilizar o indice 0, que não contem nenhum caractere
               centenas[(num % 1000) / 100] + // mesma lógica de milhares, Ex 300, acessa o indice 3 do array centenas "CCC" 
               dezenas[(num % 100) / 10] + // mesma lógica de centenas e milhares
               unidades[num % 10]; // mesma lógica de centenas e milhares
        }
}
