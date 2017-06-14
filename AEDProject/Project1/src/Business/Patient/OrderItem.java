package Business.Patient;

import Business.Pharmacy.Medicine;

/**
 *
 * @author CUTIE
 */

public class OrderItem {

    private Medicine medicine;
    private int quantity;
    private Double Price;

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double Price) {
        this.Price = Price;
    }
    
    @Override
    public String toString() {
        return medicine.getMedName();
    }
    
}
