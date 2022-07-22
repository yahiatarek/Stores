package Sale_transactions;

public class Supplier {
  private int supplierId;
  public int supplierPhoneNo;
  public String supplierAddress;
  public String supplierName;

  public Supplier(
    int supplierPhoneNo,
    String supplierAddress,
    String supplierName
  ) {
    this.supplierPhoneNo = supplierPhoneNo;
    this.supplierAddress = supplierAddress;
    this.supplierName = supplierName;
  }
}
