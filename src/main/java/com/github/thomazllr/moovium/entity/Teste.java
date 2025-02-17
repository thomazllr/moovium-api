package com.github.thomazllr.moovium.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
class Teste {


    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public Teste() {}

    public Teste(String name) {
        this.name = name;
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
        return "Teste{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}