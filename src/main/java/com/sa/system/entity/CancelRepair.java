package com.sa.system.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table
@Entity
@Data
@Setter @Getter
@NoArgsConstructor
@SequenceGenerator(name = "cancel_repair_seq")
public class CancelRepair {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cancel_repair_seq")
    private Long id;

    @NotNull
    private Date cancelDate;

    @OneToOne
    private Request request;

    @ManyToOne
    private CancelationCause cancelationCause;

    @ManyToOne
    private ProductReceiveType productReceiveType;

    @ManyToOne
    private Customer customer;
    
}