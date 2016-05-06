package web;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

@Controller
public class WebController {

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

       String accountName = jsonBody.getString("name");
       Map response = new HashMap<>();
       response.put("status", "accountCreated");
       response.put("accountName", accountName);
       httpResponse.setStatus(HttpServletResponse.SC_OK);

       return response;
   }

}
