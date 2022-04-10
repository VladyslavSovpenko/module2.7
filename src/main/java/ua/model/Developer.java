package ua.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "developers")
@NamedQueries({
        @NamedQuery(name = "getAllDeveloper", query = "from Developer"),
})
public class Developer {
    private String name;
    @Id
    @GeneratedValue(generator = "developers_id_seq")
    private Long id;
    private String sex;
    private Long salary;
    private Long age;
    private String password;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "dev_to_project",
            joinColumns = { @JoinColumn(name = "id_dev") },
            inverseJoinColumns = { @JoinColumn(name = "id_projects") }
    )
    private List<Project> projectList;


    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", sex='" + sex + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }
}
