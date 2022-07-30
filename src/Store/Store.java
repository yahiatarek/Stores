package Store;

import Product.Product;
import Sale_transactions.Supplier;
import Store.Store;

public class Store {
  private int storeId;
  public int storePhoneNo;
  public String storeAddress;
  public String storeName;
  public Product storeProduct;
  public Supplier supplier;

  public Store(int storePhoneNo, String storeAddress, String storeName) {
    this.storePhoneNo = storePhoneNo;
    this.storeAddress = storeAddress;
    this.storeName = storeName;
  }
}
