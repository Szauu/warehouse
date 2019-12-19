package akademia.model.dto;

import javafx.util.Builder;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties;

public class WarItemDto {


    private String brand;
    private String name;
    private int quantity;
    private String priceBuy;
    private String priceSell;
    private String note;


    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPriceBuy(String priceBuy) {
        this.priceBuy = priceBuy;
    }

    public void setPriceSell(String priceSell) {
        this.priceSell = priceSell;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public WarItemDto() {
    }

    private WarItemDto(Builder b) {
        this.brand = b.brand;
        this.name = b.name;
        this.quantity = b.quantity;
        this.priceBuy = b.priceBuy;
        this.priceSell = b.priceSell;
        this.note = b.note;
    }

    public String getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getPriceBuy() {
        return priceBuy;
    }

    public String getPriceSell() {
        return priceSell;
    }

    public String getNote() {
        return note;
    }

    public static class Builder {
        private String brand;
        private String name;
        private int quantity;
        private String priceBuy;
        private String priceSell;
        private String note;


        public Builder() {
        }

        public Builder brand(String brand) {
            this.brand = brand;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder priceBuy(String priceBuy) {
            this.priceBuy = priceBuy;
            return this;
        }

        public Builder priceSell(String priceSell) {
            this.priceSell = priceSell;
            return this;
        }

        public Builder note(String note) {
            this.note = note;
            return this;
        }

        public WarItemDto build() {
            return new WarItemDto(this);
        }
    }

}
