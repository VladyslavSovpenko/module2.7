package ua.model;

import javax.persistence.*;

@Entity
@Table(name = "customers")
@NamedQueries({
        @NamedQuery(name = "getAllCustomers", query = "from Customers")
})
public class Customers {
    @Id
    @GeneratedValue(generator = "customers_id_seq")
    private Long id;
    private String name;
    private String country;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
