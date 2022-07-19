package Product;

public class Product {
  public int productID;
  public double productCost;
  public double productPrice;
  public String productQuantity;
  public String productName;
  public int productStoreId;

  public Product(
    int productId,
    double productCost,
    double productPrice,
    String productQuantity,
    String productName,
    int productStoreId
  ) {
    this.productID = productId;
    this.productCost = productCost;
    this.productPrice = productPrice;
    this.productQuantity = productQuantity;
    this.productName = productName;
    this.productStoreId = productStoreId;
  }
}
