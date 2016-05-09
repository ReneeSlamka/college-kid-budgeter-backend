package server.data;

import org.springframework.data.repository.CrudRepository;
import server.data.Account;

public interface AccountRepository extends CrudRepository<Account, Long> {

    Account findByEmail(String email);
}
