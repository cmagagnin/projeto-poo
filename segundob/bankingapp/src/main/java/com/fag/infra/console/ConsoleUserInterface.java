package com.fag.infra.console;

import java.util.Scanner;

import com.fag.domain.dto.BankslipDTO;
import com.fag.domain.dto.LoginDTO;
import com.fag.domain.dto.UserAccountDTO;
import com.fag.domain.repositories.IUserInterface;

public class ConsoleUserInterface implements IUserInterface {
    private Scanner entrada = new Scanner(System.in);
    @Override
    public Integer showInitialScreenMenu() {
        System.out.println("----MagBank----");
        System.out.println("[1] Login");
        System.out.println("[2] Cadastro");
        System.out.println("[3] Sair");
        Integer opcao = entrada.nextInt();
        return opcao;
    }
    @Override
    public LoginDTO getLoginData() {

        LoginDTO data = new LoginDTO();
        entrada.nextLine();

        System.out.println("Informe seu documento: ");
        String document = entrada.nextLine();
        data.setDocument(document);

        System.out.println("Informe a senha: ");
        String password = entrada.nextLine();
        data.setPassword(password);

        //entrada.nextLine();
        return data;
    }
    
    @Override
    public UserAccountDTO getCreateUserData() {
        
        UserAccountDTO data = new UserAccountDTO();
        
        System.out.println("Informe documento: ");
        String document = entrada.nextLine();
        System.out.println("Informe email: ");
        String email = entrada.nextLine();
        System.out.println("Informe seu nome: ");
        String name = entrada.nextLine();
        System.out.println("Informe sua senha: ");
        String password = entrada.nextLine();

        data.setDocument(document);
        data.setEmail(email);
        data.setName(name);
        data.setPassword(password);

        return data;
    }
    @Override
    public Integer showHomeMenu(String name) {
        System.out.println("Bem vindo " + name + "!");
        System.out.println("[1] Consulta boleto");
        System.out.println("[2] Pagamento boleto");
        System.out.println("[3] Gerar QR Code PIX");
        System.out.println("[4] Logout");
        
        Integer opcao = entrada.nextInt();

        entrada.nextLine();

        return opcao;
    }
    @Override
    public void showErrorMsg(String msg) {
        System.out.println("ERRO: " + msg);
    }
    @Override
    public void showExitMessage() {
        System.out.println("Obrigado por usar nosso aplicativo!");

    }
    @Override
    public String getBarcode() {
        System.out.println("Insira o código de barras:");
        String barcode = entrada.nextLine();

        return barcode;
    }
    @Override
    public BankslipDTO getPaymentBankslipInfo() {
        BankslipDTO bankslipDTO = new BankslipDTO();

        System.out.println("Insira o código de barras:");
        String barcode = entrada.nextLine();

        System.out.println("Insira o identificador de pagamento:");
        String id = entrada.nextLine();

        System.out.println("Insira o valor:");
        String valor = entrada.nextLine();

        bankslipDTO.setBarcode(barcode);
        bankslipDTO.setTransactionId(id);
        bankslipDTO.setValor(Double.parseDouble(valor));

        return bankslipDTO;
    }
    @Override
    public void showBankslipData(String data) {
        System.out.println("Dados do boleto: " + data);
    }
    
    @Override
    public Double getPixData() {
        System.out.println("Insira valor do PIX:");
        Double amount = entrada.nextDouble();

        return amount;
    }
    @Override
    public void showPixData(String data) {
        System.out.println("Dados do PIX: " + data);
    }   
    
}
