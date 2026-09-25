package com.yseop.web.table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "wordform")
public class WordForm implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "word_id")
    private Integer word;

    @Column(name = "disabled")
    private Boolean disabled;

    @Column(name = "form")
    private String form;

    @Column(name = "morph")
    private String morph;

    @Column(name = "lefff_pos")
    private String lefffpos;

    public WordForm(Boolean disabled, String form, String morph, String lefffpos) {
        this.id = (int) 1L;
        this.disabled = disabled;
        this.form = form;
        this.morph = morph;
        this.lefffpos = lefffpos;
    }

    public WordForm(Integer wordId) {
        this.id = (int) 1L;
        this.disabled = false;
        this.form = "null";
        this.morph = "null";
        this.lefffpos = "null";
        this.word = wordId;
    }

    public WordForm() {}

    public Integer getWordId() {
        return this.word;
    }

    public void setWordId(Integer word) {
        this.word = word;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getMorph() {
        return this.morph;
    }

    public void setMorph(String morph) {
        this.morph = morph;
    }

    public String getLefffpos() {
        return lefffpos;
    }

    public void setLefffpos(String lefffpos) {
        this.lefffpos = lefffpos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWord() {
        return word;
    }

    public void setWord(Integer word) {
        this.word = word;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    @Override
    public String toString() {
        return "WordForm [id=" + id + ", " + "word Id = " + word + "disabled =" + disabled + ", form=" + form + ", morph=" + morph + ", lefffpos=" +
                lefffpos + "]";
    }

}
