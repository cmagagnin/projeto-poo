package listadois;

public class ConversorMoeda {
    public void opcoesMoedas() {
        System.out.println("Escolha a moeda:");
        System.out.println("1. USD (Dólar Americano)");
        System.out.println("2. EUR (Euro)");
        System.out.println("3. JPY (Iene Japonês)");
        System.out.println("4. GBP (Libra Esterlina)");
        System.out.println("5. BRL (Real Brasileiro)");
    }
    public String obterMoeda(int opcao) {
        switch (opcao) {
            case 1: return "USD";
            case 2: return "EUR";
            case 3: return "JPY";
            case 4: return "GBP";
            case 5: return "BRL";
            default: return null;
        }
    }

    public double converterMoeda(String origem, String destino, double valor) {
        // USD para outras moedas
        double USD_USD = 1;
        double USD_BRL = 5.46;
        double USD_EUR = 0.90;
        double USD_JPY = 142.00;
        double USD_GBP = 0.76;
        // BRL para outras moedas
        double BRL_BRL = 1;
        double BRL_USD = 0.18;
        double BRL_EUR = 0.16;
        double BRL_JPY = 26;
        double BRL_GBP = 0.14;
        // JPY para outras moedas
        double JPY_JPY = 1;
        double JPY_USD = 0.007;
        double JPY_EUR = 0.0063;
        double JPY_BRL = 0.038;
        double JPY_GBP = 0.0053;
        // EUR para outras moedas
        double EUR_EUR = 1;
        double EUR_USD = 1.11;
        double EUR_JPY = 158;
        double EUR_BRL = 6.07;
        double EUR_GBP = 0.84;
        // GBP para outras moedas
        double GBP_GBP = 1;
        double GBP_USD = 1.32;
        double GBP_BRL = 7.22;
        double GBP_JPY = 188.00;
        double GBP_EUR = 1.19;
        //imprime as conversões de acorodo com a escolha das moedas
        if (origem.equals("USD") && destino.equals("USD")) return valor * USD_USD;
        if (origem.equals("USD") && destino.equals("BRL")) return valor * USD_BRL;
        if (origem.equals("USD") && destino.equals("EUR")) return valor * USD_EUR;
        if (origem.equals("USD") && destino.equals("JPY")) return valor * USD_JPY;
        if (origem.equals("USD") && destino.equals("GBP")) return valor * USD_GBP;
        if (origem.equals("BRL") && destino.equals("BRL")) return valor * BRL_BRL;
        if (origem.equals("BRL") && destino.equals("USD")) return valor * BRL_USD;
        if (origem.equals("BRL") && destino.equals("EUR")) return valor * BRL_EUR;
        if (origem.equals("BRL") && destino.equals("JPY")) return valor * BRL_JPY;
        if (origem.equals("BRL") && destino.equals("GBP")) return valor * BRL_GBP;
        if (origem.equals("JPY") && destino.equals("JPY")) return valor * JPY_JPY;
        if (origem.equals("JPY") && destino.equals("USD")) return valor * JPY_USD;
        if (origem.equals("JPY") && destino.equals("EUR")) return valor * JPY_EUR;
        if (origem.equals("JPY") && destino.equals("BRL")) return valor * JPY_BRL;
        if (origem.equals("JPY") && destino.equals("GBP")) return valor * JPY_GBP;
        if (origem.equals("EUR") && destino.equals("EUR")) return valor * EUR_EUR;
        if (origem.equals("EUR") && destino.equals("USD")) return valor * EUR_USD;
        if (origem.equals("EUR") && destino.equals("JPY")) return valor * EUR_JPY;
        if (origem.equals("EUR") && destino.equals("BRL")) return valor * EUR_BRL;
        if (origem.equals("EUR") && destino.equals("GBP")) return valor * EUR_GBP;
        if (origem.equals("GBP") && destino.equals("GBP")) return valor * GBP_GBP;
        if (origem.equals("GBP") && destino.equals("BRL")) return valor * GBP_BRL;
        if (origem.equals("GBP") && destino.equals("JPY")) return valor * GBP_JPY;
        if (origem.equals("GBP") && destino.equals("USD")) return valor * GBP_USD;
        if (origem.equals("GBP") && destino.equals("EUR")) return valor * GBP_EUR;
        return -1;
    }
}
