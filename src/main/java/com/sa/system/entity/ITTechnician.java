package com.sa.system.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Data
@Setter @Getter
@NoArgsConstructor
@SequenceGenerator(name = "it_technician_seq", initialValue = 1)
public class ITTechnician {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "it_technician_seq")
    private Long id;

    private @NotNull String technician;
}