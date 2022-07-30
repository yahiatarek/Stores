package database;

import Product.SpecialProduct;

public class SpecialProductDb {
  private static SpecialProduct[] specialProductsArray = new SpecialProduct[100];
  private static int productCount = 0;

  public static void getSpecialProducts() {
    for (int i = 0; i < specialProductsArray.length; i++) {
      if (specialProductsArray[i] != null) {
        System.out.println(specialProductsArray[i].productName);
      }
    }
  }

  public static void addToSpecialProducts(SpecialProduct product) {
    specialProductsArray[productCount] = product;
    productCount++;
  }
}
