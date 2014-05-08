package dk.cphbusiness.bank.repository;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:BankResource [bank]<br>
 * USAGE:
 * <pre>
 *        try (BankRepositoryClient client = new BankRepositoryClient()) {
 *          Object response = client.XXX(...);
 *          // do whatever with response
 *          }
 * </pre>
 *
 * @author anders
 */
public class BankRepositoryClient implements AutoCloseable {
  private WebTarget webTarget;
  private Client client;
  private static final String BASE_URI = "http://datdb.cphbusiness.dk:8080/BankRepository/ws";

  public BankRepositoryClient() { this(BASE_URI); }

  public BankRepositoryClient(String uri) {
    client = javax.ws.rs.client.ClientBuilder.newClient();
    webTarget = client.target(uri).path("bank");
    }
  
  public void save(Object requestEntity) throws ClientErrorException {
    webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

  public void drop(String reg) throws ClientErrorException {
    webTarget.path(java.text.MessageFormat.format("{0}", new Object[]{reg})).request().delete();
    }

  public <T> T list(Class<T> responseType) throws ClientErrorException {
    WebTarget resource = webTarget;
    return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

  public <T> T find(Class<T> responseType, String reg) throws ClientErrorException {
    WebTarget resource = webTarget;
    resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{reg}));
    return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

  public void close() {
    client.close();
    }
  
  }
