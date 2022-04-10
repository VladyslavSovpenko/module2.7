package ua.model;

import javax.persistence.*;

@Entity
@Table(name = "companies")
@NamedQueries({
        @NamedQuery(name = "getAllCompanies", query = "from Companies")
})

public class Companies {
    @Id
    @GeneratedValue(generator = "companies_id_seq")
    private Long id;
    private String name;
    @Column(name = "number_of_projects")
    private Long number;

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
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


    @Override
    public String toString() {
        return "Companies{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numberOfProjects=" + number +
                '}';
    }
}
