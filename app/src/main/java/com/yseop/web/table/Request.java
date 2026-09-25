package com.yseop.web.table;

// Class for receive the input of user.
public class Request {

    private Integer id;

    private String lemma;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLemma() {
        return lemma;
    }

    public void setLemma(String lemma) {
        this.lemma = lemma;
    }

}