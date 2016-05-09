package server.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
import server.service.AccountService;

@Controller
public class WebController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/budget", method = RequestMethod.POST)
    public @ResponseBody Map createBudget(
            @RequestBody String signupRequestBody,
            HttpServletResponse httpResponse) throws IOException, JSONException {

        JSONObject bodyJSON = new JSONObject(signupRequestBody);
        String tempStoreName = bodyJSON.getString("budgetName");
        String tempPassword = bodyJSON.getString("budgetBalance");

        httpResponse.setStatus(HttpServletResponse.SC_OK);

        Map response = new HashMap<>();
        response.put("Status", "saved your budget named " + tempStoreName);


        return response;
    }

    @RequestMapping(value = "/account", method = RequestMethod.POST)
    public @ResponseBody Map createAccount(
            @RequestBody String accountSignupParams,
            HttpServletResponse httpResponse) throws IOException, JSONException {

        JSONObject jsonBody = new JSONObject(accountSignupParams);

        String accountEmail = jsonBody.getString("email");
        String accountPassword = jsonBody.getString("password");

        if (accountEmail == null || accountPassword == null) {
            accountEmail = "defaultName";
            accountPassword = "defaultPassword";
        }

        Map response = accountService.createAccount(accountEmail, accountPassword, httpResponse);

        return response;
    }

    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public @ResponseBody Map getAccount(
            @RequestParam (value = "username", required = true) String email) throws IOException, JSONException {

        Map response = accountService.getAccount(email);
        return response;
    }


    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public  @ResponseBody Map getAccounts () throws IOException, JSONException {

        Map response = accountService.getAllAccounts();
        return response;
    }
}
