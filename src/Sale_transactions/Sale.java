package Sale_transactions;

import java.time.LocalDateTime;

public class Sale {
  private int saleId;
  public LocalDateTime saleDate;
  public int saleProductQuantity;

  public Sale(LocalDateTime saleDate, int saleProductQuantity) {
    this.saleDate = saleDate;
    this.saleProductQuantity = saleProductQuantity;
  }
}
