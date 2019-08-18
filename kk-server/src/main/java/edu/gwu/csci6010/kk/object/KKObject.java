package edu.gwu.csci6010.kk.object;

import javax.persistence.*;

@Entity
@Table(name="kkobjects")
public class KKObject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String value;

    public KKObject(String name, String value){
        this.name = name;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return String.format("<%s,%s>", this.name, this.value);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

