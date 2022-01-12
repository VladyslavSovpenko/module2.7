package ua.model;

import ua.dao.Identity;

public class Companies implements Identity {
private Long id;
private String name;
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
