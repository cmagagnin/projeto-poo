package com.fag.services;

import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.UUID;

//import javax.swing.JOptionPane;

import com.fag.domain.dto.BankslipDTO;
import com.fag.domain.dto.LoginDTO;
import com.fag.domain.dto.UserAccountDTO;
import com.fag.domain.repositories.IBassRepository;
import com.fag.domain.repositories.IUserInterface;
import com.fag.domain.repositories.IUserRepository;

public class BankingService {

    private IUserInterface gui;
    private Integer accountNumber = 2;
    private IBassRepository bassRepository;
    private IUserRepository userDB;
    

    public BankingService(IUserInterface gui, IUserRepository userDB, IBassRepository bassRepository){
        this.gui = gui;
        this.userDB = userDB;
        this.bassRepository = bassRepository;
    }

    public Integer showMenu(){
        return gui.showInitialScreenMenu();
    }

    public LoginDTO getLoginDTO(){
        return gui.getLoginData();
    }

    public UserAccountDTO getUserAccountDTO() {
        UserAccountDTO data = gui.getCreateUserData();
        String uuid = UUID.randomUUID().toString();
        
        data.setId(uuid);
        data.setAccountNumber(accountNumber.toString());
        data.setCreateAt(LocalDateTime.now());

        accountNumber ++;

        return data;

    }

    public void exitMessage() {
       gui.showExitMessage();
    }

    public void errorMessage(String msg) {
        gui.showErrorMsg(msg);
    }

    public Integer login(UserAccountDTO user) throws URISyntaxException, Exception {
        
        while (true) {
            Integer opcao = gui.showHomeMenu(user.getName());

        
        switch (opcao) {
            case 1:
                String barcode = gui.getBarcode();
                String searchResponse = bassRepository.consultarBoleto(barcode);
                gui.showBankslipData(searchResponse);
                System.out.println("teste bizonho");
                break;
        
            case 2:
                BankslipDTO bankslipDTO = gui.getPaymentBankslipInfo();
                String payResponse = bassRepository.pagarBoleto(bankslipDTO);
                gui.showBankslipData(payResponse);
                break;
        
            case 3:
                Double amount = gui.getPixData();
                String pixResponse = bassRepository.gerarQrCode(amount);
                gui.showBankslipData(pixResponse);
                break;
            
            case 4:
                
            return gui.showInitialScreenMenu();
              }
    }
    }
    public UserAccountDTO createUser(UserAccountDTO user) {
        return userDB.createUser(user);
    }

    public UserAccountDTO findUser(LoginDTO loginDTO) {
        UserAccountDTO user = userDB.findUserBy(loginDTO.getDocument());

        if (user == null) {
            gui.showErrorMsg("Usuario nao encontrado");

            return null;

        }
        if (!user.getPassword().equals(loginDTO.getPassword())) {
            gui.showErrorMsg("Credencial invalida");

            return null;
        }
        return user;

    }

}
