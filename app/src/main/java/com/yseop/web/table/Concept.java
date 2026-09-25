package com.yseop.web.table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "concept")
public class Concept implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "score")
    private Integer score;

    @Column(name = "disabled")
    private Integer disabled;

    @Column(name = "name")
    private String name;

    @Column(name = "def")
    private String def;

    @Column(name = "usages")
    private String usages;

    @Column(name = "origin")
    private String origin;

    @Column(name = "semclass")
    private String semclass;

    public Concept() {
        boolean flag = false;
        setDisabled(flag);
    }

    public Concept(Integer score, Boolean disabled, String name, String def, String usages, String origin,
            String semclass) {
        this.score = score;
        setDisabled(disabled);
        this.name = name;
        this.def = def;
        this.usages = usages;
        this.origin = origin;
        this.semclass = semclass;
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

    public Boolean getDisabled() {
        if (this.disabled == 1) {
            return true;
        } else {
            return false;
        }
    }

    public void setDisabled(Boolean disabled) {
        if (disabled) {
            this.disabled = 1;
        } else {
            this.disabled = 0;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDef() {
        return def;
    }

    public void setDef(String def) {
        this.def = def;
    }

    public String getUsages() {
        return usages;
    }

    public void setUsages(String usages) {
        this.usages = usages;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getSemclass() {
        return semclass;
    }

    public void setSemclass(String semclass) {
        this.semclass = semclass;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Concept {");
        sb.append(" id = ").append(id.toString());
        sb.append(" score = ").append(score.toString());
        sb.append(" disabled = ").append(disabled);
        sb.append(" name = ").append(name);
        sb.append(System.getProperty("line.separator"));
        sb.append(" def = ").append(def);
        sb.append(System.getProperty("line.separator"));
        sb.append(" usages = ").append(usages);
        sb.append(System.getProperty("line.separator"));
        sb.append(" origin = ").append(origin);
        sb.append('}');
        return sb.toString();
    }
}
