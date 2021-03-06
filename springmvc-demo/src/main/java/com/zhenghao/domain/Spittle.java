package com.zhenghao.domain;

import lombok.Getter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
public class Spittle implements Serializable {

    @Id
    private Long id;
    private String message;
    private Date time;
    private Double latitude;
    private Double longitude;
    private Spitter spitter;

    public Spittle() {
    }

    public Spittle(String message, Date time) {
        this(message, time, null, null);
    }

    public Spittle(String message, Date time, Double latitude, Double longitude) {
        this.id = null;
        this.message = message;
        this.time = time;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Spittle(Long id, String message, Date time, Double latitude, Double longitude, Spitter spitter) {
        this.id = id;
        this.message = message;
        this.time = time;
        this.latitude = latitude;
        this.longitude = longitude;
        this.spitter = spitter;
    }

    public Spittle(Long id, String message, Date time) {
        this.id = id;
        this.message = message;
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        //使用Apache Commons
        return EqualsBuilder.reflectionEquals(this, o, "id", "name");
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, "id", "name");
    }
}
