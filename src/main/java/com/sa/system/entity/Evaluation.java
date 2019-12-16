package com.sa.system.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table
@Entity
@Getter @Setter
@Data
@NoArgsConstructor
@SequenceGenerator(name = "evaluation_seq", initialValue = 1)
public class Evaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "evaluation_seq")
    private Long id;

    @NotNull
    private Date evaluationDate;

    @NotNull
    private String suggestion;

    @ManyToOne
    private Request request;

    @ManyToOne
    private Satisfaction satisfaction;

    @ManyToOne
    private Repairman repairman;
}