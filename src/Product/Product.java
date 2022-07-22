package Product;

public class Product {
  private int productID;
  public double productCost;
  public double productPrice;
  public double productQuantity;
  public String productName;
  public int productStoreId;

  public Product(
    double productCost,
    double productPrice,
    Double productQuantity,
    String productName,
    int productStoreId
  ) {
    this.productCost = productCost;
    this.productPrice = productPrice;
    this.productQuantity = productQuantity;
    this.productName = productName;
    this.productStoreId = productStoreId;
  }
}
