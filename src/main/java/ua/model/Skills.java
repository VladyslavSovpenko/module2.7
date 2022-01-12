package ua.model;

import ua.dao.Identity;

public class Skills implements Identity {
    private Long id;
    private String language;
    private String skillRate;

    @Override
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
