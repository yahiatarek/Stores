package Sale_transactions;

public class Client {
  public int clientId;
  public int clientPhoneNo;
  public String clientCity;
  public String clientName;

  public Client(
    int clientPhoneNo,
    String clientCity,
    String clientName,
    int clientId
  ) {
    this.clientCity = clientCity;
    this.clientName = clientName;
    this.clientPhoneNo = clientPhoneNo;
    this.clientId = clientId;
  }
}
