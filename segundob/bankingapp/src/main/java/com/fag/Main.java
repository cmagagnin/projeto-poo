package com.fag;

import java.net.URISyntaxException;

import com.fag.domain.dto.LoginDTO;
import com.fag.domain.dto.UserAccountDTO;
import com.fag.domain.repositories.IBassRepository;
import com.fag.domain.repositories.IUserInterface;
import com.fag.infra.swing.SwingUserGUI;
import com.fag.infra.testdb.UserTestDB;
import com.fag.services.BankingService;
import com.fag.infra.celcoin.CelcoinBassRepository;
import com.fag.infra.pg.PgSupabase;
import com.fag.infra.console.ConsoleUserInterface;
import com.fag.infra.pg.PostgresConnection;

public class Main {
    public static void main(String[] args) throws URISyntaxException, Exception {
        ConsoleUserInterface cli = new ConsoleUserInterface();
        SwingUserGUI gui = new SwingUserGUI();
        UserTestDB userDB = new UserTestDB();
        CelcoinBassRepository celcoin = new CelcoinBassRepository();
        PgSupabase pg = new PgSupabase();
        //PostgresConnection.getInstance();  // Apenas para testar a conexão com o SUPABASE
        
        BankingService bankingService = new BankingService (gui, pg, celcoin);
        Integer opcao = bankingService.showMenu();
       
        switch (opcao) {
            case 1:
            LoginDTO loginDTO = bankingService.getLoginDTO();
            UserAccountDTO user = bankingService.findUser(loginDTO);
            if(user !=  null){
                bankingService.login(user);
            }
            case 2:
                UserAccountDTO userAccountDTO = bankingService.getUserAccountDTO();
                System.out.println(userAccountDTO.toString());
                bankingService.createUser(userAccountDTO);
                bankingService.login(userAccountDTO);
                break;
            case 3:
                bankingService.exitMessage();
                break;
            default:
                bankingService.errorMessage("Opção inválida");
                break;
        }
}
}