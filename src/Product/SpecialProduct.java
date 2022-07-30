package Product;

public class SpecialProduct extends Product {
  String type;
  String color;

  public SpecialProduct(
    double productCost,
    double productPrice,
    double productQuantity,
    String productName,
    int productStoreId,
    String type,
    String color
  ) {
    super(
      productCost,
      productPrice,
      productQuantity,
      productName,
      productStoreId
    );
    this.type = type;
    this.color = color;
  }
}
