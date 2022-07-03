package com.project.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Coder {

    @Id
    private int id;
    private String name;
    private String progLanguage;

    public int getId() { return id; }
    public String getName() { return name; }
    public String getProgLanguage() { return progLanguage; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setProgLanguage(String progLanguage) { this.progLanguage = progLanguage; }

    @Override
    public String toString() {
        return "Coder: [" +
                "ID = " + id +
                ", Name = '" + name + '\'' +
                ", Programming Language = '" + progLanguage + '\'' +
                ']';
    }

}
