package com.fag.infra.swing;

import javax.swing.JOptionPane;

import com.fag.domain.dto.BankslipDTO;
import com.fag.domain.dto.LoginDTO;
import com.fag.domain.dto.UserAccountDTO;
import com.fag.domain.repositories.IUserInterface;

public class SwingUserGUI implements IUserInterface{
    
    @Override
    public Integer showInitialScreenMenu() {
        String menu = "----MagBank----\n"
        .concat("[1] Login\n")
        .concat("[2] Cadastro\n")
        .concat("[3] Sair");
        
        String escolha = JOptionPane.showInputDialog(
            null,
            menu,
            "Menu inicial MagBank",
            JOptionPane.INFORMATION_MESSAGE);

            return Integer.parseInt(escolha);

    }

    @Override
    public LoginDTO getLoginData() {
        
        LoginDTO loginDTO = new LoginDTO();

        String document = JOptionPane.showInputDialog(null, "Insira o documento", "Insira o documento", JOptionPane.DEFAULT_OPTION);
        loginDTO.setDocument(document);
        
        String password = JOptionPane.showInputDialog(null, "Insira senha", "Insira senha", JOptionPane.DEFAULT_OPTION);
        loginDTO.setPassword(password);

        return loginDTO;
    }

    @Override
    public UserAccountDTO getCreateUserData() {
        
        UserAccountDTO userAccountDTO = new UserAccountDTO();
        
        String document = JOptionPane.showInputDialog(null, "Insira o documento", "Insira o documento", JOptionPane.DEFAULT_OPTION);
        userAccountDTO.setDocument(document);

        String email = JOptionPane.showInputDialog(null, "Insira o email", "Insira o email", JOptionPane.DEFAULT_OPTION);
        userAccountDTO.setEmail(email);

        String name = JOptionPane.showInputDialog(null, "Insira o nome", "Insira o nome", JOptionPane.DEFAULT_OPTION);
        userAccountDTO.setName(name);

        String password = JOptionPane.showInputDialog(null, "Insira senha", "Insira senha", JOptionPane.DEFAULT_OPTION);
        userAccountDTO.setPassword(password);

        return userAccountDTO;
    }

    @Override
    public Integer showHomeMenu(String name) {
        String menu = "Bem vindo "+ name + "!\n"
        .concat("[1] Consulta boleto\n")
        .concat("[2] Pagamento boleto\n")
        .concat("[3] Gerar QR Code PIX\n")
        .concat("[4] Logout");

        String escolha = JOptionPane.showInputDialog(
            null,
            menu,
            "Menu inicial MagBank",
            JOptionPane.INFORMATION_MESSAGE);

            return Integer.parseInt(escolha);
    }

    @Override
    public void showErrorMsg(String msg) {
        JOptionPane.showMessageDialog(
            null,
            "Erro: " + msg, 
            "ERRO!",
            JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void showExitMessage() {
        JOptionPane.showMessageDialog(
            null, 
            "Obrigado por usar nosso aplicativo", 
            "werty", 
            JOptionPane.CLOSED_OPTION);
    }

    @Override
    public String getBarcode() {
        String barcode = JOptionPane.showInputDialog(
                null,
                "Insira o código de barras a ser consultado",
                "Código de barras",
                JOptionPane.INFORMATION_MESSAGE);

        return barcode;
    }

    @Override
    public BankslipDTO getPaymentBankslipInfo() {
        BankslipDTO bankslipDTO = new BankslipDTO();

        String barcode = JOptionPane.showInputDialog(
                null,
                "Insira o código de barras a ser pago",
                "Código de barras",
                JOptionPane.INFORMATION_MESSAGE);
        String transactionId = JOptionPane.showInputDialog(
                null,
                "Insira o identificador de pagamento",
                "Identificador",
                JOptionPane.INFORMATION_MESSAGE);

                String valor = JOptionPane.showInputDialog(
                    null,
                    "Insira o Valor do boleto",
                    "Valor",
                    JOptionPane.INFORMATION_MESSAGE);

        bankslipDTO.setBarcode(barcode);
        bankslipDTO.setTransactionId(transactionId);
        bankslipDTO.setValor(Double.parseDouble(valor));

        return bankslipDTO;
    }

    @Override
    public void showBankslipData(String data) {
        JOptionPane.showMessageDialog(
                null,
                data,
                "Dados boleto",
                JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public Double getPixData() {
        String amount = JOptionPane.showInputDialog(
                null,
                "Insira o valor do PIX",
                "Valor transação",
                JOptionPane.INFORMATION_MESSAGE);

        return Double.parseDouble(amount);
    }

    @Override
    public void showPixData(String data) {
        JOptionPane.showMessageDialog(
                null,
                data,
                "Dados PIX",
                JOptionPane.INFORMATION_MESSAGE);
    }
    
}
