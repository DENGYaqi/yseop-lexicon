package com.yseop.web.table;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "word")
public class Word implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "modal")
    private Integer modal;

    @Column(name = "neg")
    private Integer neg;

    @Column(name = "disabled")
    private Boolean disabled;

    @Column(name = "lemma")
    private String lemma;

    @Column(name = "cpos")
    private String cpos;

    @Column(name = "pos")
    private String pos;

    @Column(name = "lang")
    private String lang;

    @Column(name = "tag")
    private String tag;

    @Column(name = "origin")
    private String origin;

    @Column(name = "infl")
    private String infl;

    @OneToMany(mappedBy = "word", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Sense> senses = new ArrayList<Sense>();

    @OneToMany(mappedBy = "word", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<WordForm> wordforms = new ArrayList<WordForm>();

    @OneToMany(mappedBy = "word", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<LeffSem> leffSems = new ArrayList<LeffSem>();

    public Word() {}

    public Word(Integer id, Integer modal, Integer neg, Boolean disabled, String lemma, String cpos, String pos, String lang,
            String tag, String origin, String infl) {
        super();
        this.id = id;
        this.modal = modal;
        this.neg = neg;
        this.disabled = disabled;
        this.lemma = lemma;
        this.cpos = cpos;
        this.pos = pos;
        this.lang = lang;
        this.tag = tag;
        this.origin = origin;
        this.infl = infl;
        setSensesEmpty(this.id);
        setWordFormEmpty(this.id);
        setLeffSemEmpty(this.id);
    }

    public Word(Integer id, Integer modal, Integer neg, Boolean disabled, String lemma, String cpos, String pos, String lang,
            String tag, String origin, String infl, List<Sense> senses, List<WordForm> wf, List<LeffSem> lfs) {
        super();
        this.id = getId();
        this.modal = modal;
        this.neg = neg;
        this.disabled = disabled;
        this.lemma = lemma;
        this.cpos = cpos;
        this.pos = pos;
        this.lang = lang;
        this.tag = tag;
        this.origin = origin;
        this.infl = infl;
        setSenses(senses);
        setWordForm(wf);
        setLeffSems(lfs);
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(long l) {
        this.id = (int) l;
    }

    public Integer getModal() {
        return modal;
    }

    public void setModal(Integer modal) {
        this.modal = modal;
    }

    public Integer getNeg() {
        return neg;
    }

    public void setNeg(Integer neg) {
        this.neg = neg;
    }

    public String getLemma() {
        return lemma;
    }

    public void setLemma(String lemma) {
        this.lemma = lemma;
    }

    public String getCpos() {
        return cpos;
    }

    public void setCpos(String cpos) {
        this.cpos = cpos;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getInfl() {
        return infl;
    }

    public void setInfl(String infl) {
        this.infl = infl;
    }

    public List<Sense> getSenses() {
        return senses;
    }

    public void addSenseToListOfSenses(Sense sense) {
        this.senses.add(sense);
    }

    public void addLeffSemToListOfLeffSems(LeffSem leffSem) {
        this.leffSems.add(leffSem);
    }

    public void addWordFormToListOfWordForm(WordForm wordForm) {
        this.wordforms.add(wordForm);
    }

    public void setSenses(List<Sense> senses) {
        for (Sense s : senses) {
            s.setWord(this.id);
            this.senses.add(s);
        }
    }

    public void setSensesEmpty(Integer id) {
        Sense sense = new Sense(id);
        List<Sense> senses = new ArrayList<Sense>();
        senses.add(sense);
        this.senses = senses;
    }

    public void setWordFormEmpty(Integer word) {
        WordForm wf = new WordForm(word);
        List<WordForm> wfs = new ArrayList<WordForm>();
        wfs.add(wf);
        this.wordforms = wfs;
    }

    public void setLeffSemEmpty(Integer id) {
        LeffSem lfs = new LeffSem(id);
        List<LeffSem> lfss = new ArrayList<LeffSem>();
        lfss.add(lfs);
        this.leffSems = lfss;
    }

    public List<WordForm> getWordForm() {
        return wordforms;
    }

    public void setWordForm(List<WordForm> wordForm) {
        for (WordForm wfs : wordForm) {
            wfs.setId(this.id);
            this.wordforms.add(wfs);
        }
    }

    public List<LeffSem> getLeffSems() {
        return leffSems;
    }

    public void setLeffSems(List<LeffSem> leffSems) {
        for (LeffSem lfs : leffSems) {
            lfs.setWordId(this.id);
            this.leffSems.add(lfs);
        }
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cpos == null) ? 0 : cpos.hashCode());
        result = prime * result + ((disabled == null) ? 0 : disabled.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((infl == null) ? 0 : infl.hashCode());
        result = prime * result + ((lang == null) ? 0 : lang.hashCode());
        result = prime * result + ((leffSems == null) ? 0 : leffSems.hashCode());
        result = prime * result + ((lemma == null) ? 0 : lemma.hashCode());
        result = prime * result + ((modal == null) ? 0 : modal.hashCode());
        result = prime * result + ((neg == null) ? 0 : neg.hashCode());
        result = prime * result + ((origin == null) ? 0 : origin.hashCode());
        result = prime * result + ((pos == null) ? 0 : pos.hashCode());
        result = prime * result + ((senses == null) ? 0 : senses.hashCode());
        result = prime * result + ((tag == null) ? 0 : tag.hashCode());
        result = prime * result + ((wordforms == null) ? 0 : wordforms.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Word other = (Word) obj;
        if (cpos == null) {
            if (other.cpos != null) {
                return false;
            }
        } else if (!cpos.equals(other.cpos)) {
            return false;
        }
        if (disabled == null) {
            if (other.disabled != null) {
                return false;
            }
        } else if (!disabled.equals(other.disabled)) {
            return false;
        }
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (infl == null) {
            if (other.infl != null) {
                return false;
            }
        } else if (!infl.equals(other.infl)) {
            return false;
        }
        if (lang == null) {
            if (other.lang != null) {
                return false;
            }
        } else if (!lang.equals(other.lang)) {
            return false;
        }
        if (leffSems == null) {
            if (other.leffSems != null) {
                return false;
            }
        } else if (!leffSems.equals(other.leffSems)) {
            return false;
        }
        if (lemma == null) {
            if (other.lemma != null) {
                return false;
            }
        } else if (!lemma.equals(other.lemma)) {
            return false;
        }
        if (modal == null) {
            if (other.modal != null) {
                return false;
            }
        } else if (!modal.equals(other.modal)) {
            return false;
        }
        if (neg == null) {
            if (other.neg != null) {
                return false;
            }
        } else if (!neg.equals(other.neg)) {
            return false;
        }
        if (origin == null) {
            if (other.origin != null) {
                return false;
            }
        } else if (!origin.equals(other.origin)) {
            return false;
        }
        if (pos == null) {
            if (other.pos != null) {
                return false;
            }
        } else if (!pos.equals(other.pos)) {
            return false;
        }
        if (senses == null) {
            if (other.senses != null) {
                return false;
            }
        } else if (!senses.equals(other.senses)) {
            return false;
        }
        if (tag == null) {
            if (other.tag != null) {
                return false;
            }
        } else if (!tag.equals(other.tag)) {
            return false;
        }
        if (wordforms == null) {
            if (other.wordforms != null) {
                return false;
            }
        } else if (!wordforms.equals(other.wordforms)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Word [id=" + id + ", modal=" + modal + ", neg=" + neg + ", disabled=" + disabled + ", lemma=" + lemma + ", cpos=" + cpos + ", pos=" +
                pos + ", lang=" + lang + ", tag=" + tag + ", origin=" + origin + ", infl=" + infl + ", senses=" + senses + ", wordForm=" + wordforms +
                ", leffSems=" + leffSems + "]";
    }
}
