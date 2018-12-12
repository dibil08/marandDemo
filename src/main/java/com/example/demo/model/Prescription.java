package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
@Entity
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotNull
    private int unit;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @NotNull
    private Timestamp start_time;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @NotNull
    private Timestamp end_time;

    @NotNull
    private float timing_hours_period;


    public Prescription() {
    }

    public Prescription(@NotBlank String name, @NotBlank int unit, @NotBlank Timestamp start_time, @NotBlank Timestamp end_time, @NotBlank int timing_hours_period) {
        this.name = name;
        this.unit = unit;
        this.start_time = start_time;
        this.end_time = end_time;
        this.timing_hours_period = timing_hours_period;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public Timestamp getStart_time() {
        return start_time;
    }

    public void setStart_time(Timestamp start_time) {
        this.start_time = start_time;
    }

    public Timestamp getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Timestamp end_time) {
        this.end_time = end_time;
    }

    public float getTiming_hours_period() {
        return timing_hours_period;
    }

    public void setTiming_hours_period(float timing_hours_period) {
        this.timing_hours_period = timing_hours_period;
    }

}

