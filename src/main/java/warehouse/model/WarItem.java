package warehouse.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class WarItem {

    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private String brand;
    @NotNull
    private String name;
    private int quantity;
    @NotNull
    private String priceBuy;
    @NotNull
    private String priceSell;


    private String note;

    public WarItem() {
    }

    public WarItem(@NotNull String brand, @NotNull String name, int quantity, @NotNull String priceBuy, @NotNull String priceSell, String note) {
        this.brand = brand;
        this.name = name;
        this.quantity = quantity;
        this.priceBuy = priceBuy;
        this.priceSell = priceSell;
        this.note = note;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPriceBuy() {
        return priceBuy;
    }

    public void setPriceBuy(String priceBuy) {
        this.priceBuy = priceBuy;
    }

    public String getPriceSell() {
        return priceSell;
    }

    public void setPriceSell(String priceSell) {
        this.priceSell = priceSell;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "WarItem{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", priceBuy='" + priceBuy + '\'' +
                ", priceSell='" + priceSell + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
