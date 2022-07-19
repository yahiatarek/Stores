package Store;

import Product.Product;
import Sale_transactions.Supplier;

public class Store {
  int storeId;
  int storePhoneNo;
  String storeAddress;
  String storeName;
  Product storeProduct;
  Supplier supplier;

  public Store(
    int storeId,
    int storePhoneNo,
    String storeAddress,
    String storeName
  ) {
    this.storeId = storeId;
    this.storePhoneNo = storePhoneNo;
    this.storeAddress = storeAddress;
    this.storeName = storeName;
  }
}
