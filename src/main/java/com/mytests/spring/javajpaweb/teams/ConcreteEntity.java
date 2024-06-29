package com.mytests.spring.javajpaweb.teams;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity(name = "team")
@Table(schema = "foo")
public class ConcreteEntity extends MyBaseEntity {

    String description;
    int size;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "ConcreteEntity{" +
               "id=" + id +
               ", title='" + title + '\'' +
               ", description='" + description + '\'' +
               ", size=" + size +
               '}';
    }
}
