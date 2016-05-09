package server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.data.Account;
import server.data.AccountRepository;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;


@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepo;

    public Map createAccount(String email, String password,
                             HttpServletResponse httpResponse) throws IOException {
        Map response = new HashMap<>();

        if (accountRepo.findByEmail(email) == null) {
            Account newAccount = new Account(email, password);
            Account savedAccount = accountRepo.save(newAccount);

            if (savedAccount == null) {
                httpResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "UNKNOWN ERROR");
                response.put("Status", "Account creation failed");
            } else {
                httpResponse.setStatus(HttpServletResponse.SC_CREATED);
                response.put("Status", "Account created successfully");
            }
        } else {
            httpResponse.sendError(HttpServletResponse.SC_CONFLICT, "Account with that email already exists");
            response.put("Status", "Account creation failed, please retry with different email");
        }

        return response;
    }

    public Map getAccount(String email) throws IOException {
        Map response = new HashMap<>();
        Account searchedAccount = accountRepo.findByEmail(email);

        if (searchedAccount == null) {
            response.put("Status", "Account not found");
        } else {
            response.put("Status", "Account found in database");
            response.put("Account", searchedAccount);
        }

        return response;
    }

    public Map getAllAccounts() {

        Map response = new HashMap<>();

        Iterable<Account> accounts = accountRepo.findAll();
        List<Account> listAccounts = new ArrayList<>();

        for (Account account : accounts) {
            listAccounts.add(account);
        }

        response.put("Accounts", listAccounts);
        response.put("Status", "Accounts returned");
        return response;
    }
}
