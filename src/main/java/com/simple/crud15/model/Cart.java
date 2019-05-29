package com.simple.crud15.model;


import javax.persistence.*;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name="CART")
public class Cart {

    //...

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy="cart",fetch = FetchType.EAGER
    )
    private Set<Items> items;

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Items> getItems() {
        return items;
    }

    public void setItems(Set<Items> items) {
        if (items == null)
        { this.items = null;}
        else {
            this.items=items.stream().map( item-> { item.setCart(this); ;return item; }).collect(Collectors.toSet());
        }


    }

    public Long getId() {
        return id;
    }
    // getters and setters


    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", items=" + items +
                '}';
    }
}

