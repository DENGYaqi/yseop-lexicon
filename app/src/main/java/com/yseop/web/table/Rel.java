package com.yseop.web.table;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name = "rel")
public class Rel implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private RelPrimaryKey primaryKey;

    @Column(insertable = false, updatable = false)
    private String name;

    @Column(name = "source_id", insertable = false, updatable = false)
    private Integer source;

    @Column(name = "target_id", insertable = false, updatable = false)
    private Integer target;

    @Column(name = "domain_id", insertable = false, updatable = false)
    private Integer domain;

    @Column(name = "description")
    private String description;

    @Column(name = "disabled")
    private Boolean disabled;

    @Column(name = "origin")
    private String origin;

    public Rel() {}

    public Rel(RelPrimaryKey primaryKey, String description, Boolean disabled, String origin) {
        this.primaryKey = primaryKey;
        this.description = description;
        this.disabled = disabled;
        this.origin = origin;
    }

    public RelPrimaryKey getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(RelPrimaryKey primaryKey) {
        this.primaryKey = primaryKey;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Integer getTarget() {
        return target;
    }

    public void setTarget(Integer target) {
        this.target = target;
    }

    public Integer getDomain() {
        return domain;
    }

    public void setDomain(Integer domain) {
        this.domain = domain;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    @Override
    public String toString() {
        return "Rel [primaryKey=" + primaryKey + ", description=" + description + ", disabled=" + disabled + ", origin=" + origin + "]";
    }

}
