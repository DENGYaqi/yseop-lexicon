package com.yseop.web.table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "leff_sem")
public class LeffSem implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "word_id")
    private Integer word;

    @Column(name = "form")
    private String form;

    @Column(name = "pred")
    private String pred;

    @Column(name = "frame")
    private String frame;

    @Column(name = "tag")
    private String tag;

    @Column(name = "syntax")
    private String syntax;

    public LeffSem() {}

    public LeffSem(Integer wordId) {
        this.id = (int) 1L;
        this.form = "null";
        this.pred = "null";
        this.frame = "null";
        this.tag = "null";
        this.syntax = "null";
        this.word = wordId;
    }

    public LeffSem(String form, String pred, String frame, String tag, String syntax) {
        this.form = form;
        this.pred = pred;
        this.frame = frame;
        this.tag = tag;
        this.syntax = syntax;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getPred() {
        return pred;
    }

    public void setPred(String pred) {
        this.pred = pred;
    }

    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getSyntax() {
        return syntax;
    }

    public void setSyntax(String syntax) {
        this.syntax = syntax;
    }

    @Override
    public String toString() {
        return "LeffSem [id=" + id + ", word=" + word + ", form=" + form + ", pred=" + pred + ", frame=" + frame + ", tag=" + tag + ", syntax=" +
                syntax + "]";
    }

}
