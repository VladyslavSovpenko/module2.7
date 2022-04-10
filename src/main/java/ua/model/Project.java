package ua.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "projects")
@NamedQueries({
        @NamedQuery(name = "getAllProject", query = "from Project")
})
public class Project {
    @Id
    @GeneratedValue(generator = "projects_id_seq")
    private Long id;
    private String name;
    private String language;
    private Long cost;
    @Column(name = "date_added")
    private Date date;

    @ManyToMany(mappedBy = "projectList")
    private List<Developer> developerList;

    public List<Developer> getDeveloperList() {
        return developerList;
    }

    public void setDeveloperList(List<Developer> developerList) {
        this.developerList = developerList;
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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", language='" + language + '\'' +
                ", cost=" + cost +
                ", date=" + date +
                '}';
    }
}
