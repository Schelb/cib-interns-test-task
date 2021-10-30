package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Socks {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String color;
    private String cottonPart;
    private String quantityPairs;

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCottonPart() {
        return cottonPart;
    }

    public void setCottonPart(String cottonPart) {
        this.cottonPart = cottonPart;
    }

    public String getQuantityPairs() {return quantityPairs;}

    public void setQuantityPairs(String quantityPairs) {this.quantityPairs = quantityPairs;}

    public Socks(String color, String cottonPart , String quantityPairs){
        this.color= color;
        this.cottonPart= cottonPart;
        this.quantityPairs=quantityPairs;
    }
}
