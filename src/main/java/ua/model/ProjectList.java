package ua.model;

import java.util.Date;

public class ProjectList {
    private String name;
    private Integer count;
    private Date dateAdded;

    @Override
    public String toString() {
        return "\n" +
                "dateAdded= " + dateAdded +
                ", name= '" + name + '\'' +
                ", count= " + count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }


}
