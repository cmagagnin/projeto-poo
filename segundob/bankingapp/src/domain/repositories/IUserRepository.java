package segundob.bankingapp.src.domain.repositories;

import segundob.bankingapp.src.domain.dto.UserAccountDTO;

public interface IUserRepository {
    UserAccountDTO createUser(UserAccountDTO dto);
    UserAccountDTO findUserBy(String document);
}