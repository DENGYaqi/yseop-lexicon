package com.yseop.web.table;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RelPrimaryKey implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "source_id", insertable = false)
    private Integer source;

    @Column
    private String name;

    @Column(name = "target_id")
    private Integer target;

    @Column(name = "domain_id")
    private Integer domain;

    public RelPrimaryKey() {}

    public RelPrimaryKey(Integer sourceId, String name, Integer targetId, Integer domainId) {
        super();
        this.source = sourceId;
        this.name = name;
        this.target = targetId;
        this.domain = domainId;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((domain == null) ? 0 : domain.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((source == null) ? 0 : source.hashCode());
        result = prime * result + ((target == null) ? 0 : target.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RelPrimaryKey other = (RelPrimaryKey) obj;
        if (domain == null) {
            if (other.domain != null)
                return false;
        } else if (!domain.equals(other.domain))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (source == null) {
            if (other.source != null)
                return false;
        } else if (!source.equals(other.source))
            return false;
        if (target == null) {
            if (other.target != null)
                return false;
        } else if (!target.equals(other.target))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return source + "-" + name + "-" + target + "-" + domain;
    }

}
