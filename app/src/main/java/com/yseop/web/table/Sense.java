package com.yseop.web.table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "sense")
public class Sense implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "score")
    private Integer score;

    @Column(name = "concept_id")
    private Integer concept;

    @Column(name = "word_id")
    private Integer word;

    @Column(name = "domain_id")
    private Integer domain;

    @Column(name = "origin")
    private String origin;

    public Sense() {}

    public Sense(Integer wordId) {
        this.id = (int) 1L;
        this.score = 0;
        this.concept = 0;
        this.word = wordId;
        this.domain = 0;
        this.origin = "null";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getDomain() {
        return domain;
    }

    public void setDomain(Integer domain) {
        this.domain = domain;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Integer getWord() {
        return word;
    }

    public void setWord(Integer word) {
        this.word = word;
    }

    public Integer getConcept() {
        return concept;
    }

    public void setConcept(Integer concept) {
        this.concept = concept;
    }

    @Override
    public String toString() {
        return "Sense [id=" + id + ", score=" + score + ", concept=" + concept + ", word=" + word + ", domain=" + domain + ", origin=" + origin + "]";
    }

}
