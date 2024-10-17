package segundob.bankingapp.src.domain.repositories;

import segundob.bankingapp.src.domain.dto.LoginDTO;
import segundob.bankingapp.src.domain.dto.UserAccountDTO;

public interface IUserInterface {
    Integer showInitialShowMenu();
    Integer showHomeMenu(String userName);
    LoginDTO getLoginData();
    UserAccountDTO getCreatedUserData();
    void showErrorMsg(String msg);
    void showExitMessage();
    
}