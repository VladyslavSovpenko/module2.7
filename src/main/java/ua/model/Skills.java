package ua.model;


import javax.persistence.*;

@Entity
@Table(name = "skills")
@NamedQueries({
        @NamedQuery(name = "getAllSkill", query = "from Skills")
})
public class Skills {
    @Id
    @GeneratedValue(generator = "skills_id_seq")
    private Long id;
    private String language;
    @Column(name ="skill_rate")
    private String skillRate;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getSkillRate() {
        return skillRate;
    }

    public void setSkillRate(String skillRate) {
        this.skillRate = skillRate;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", language='" + language + '\'' +
                ", skillRate='" + skillRate + '\'' +
                '}';
    }
}
