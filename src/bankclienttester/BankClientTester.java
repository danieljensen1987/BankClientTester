package bankclienttester;

import dk.cphbusiness.bank.repository.BankRepositoryClient;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class BankClientTester {

  public static void main(String[] args) throws JSONException {
    BankRepositoryClient bankClient = new BankRepositoryClient();
    String banks = bankClient.list(String.class);
    System.out.println(">>> "+banks);
    String myBank = "{\"reg\": \"4791\", \"name\": \"CPHBank\", \"url\": \"http://www.cphbank.dk\"}";
    bankClient.save(myBank);
    banks = bankClient.list(String.class);
    System.out.println(">>> "+banks);
    ///
    String bank = bankClient.find(String.class, "4711");
    JSONObject jsonBank = new JSONObject(bank);
    System.out.println(">> "+jsonBank.getString("url"));
    
    
  }
  
}
