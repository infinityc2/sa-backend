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
@Setter @Getter
@Data
@NoArgsConstructor
@SequenceGenerator(name = "computer_type_seq", initialValue = 1)
public class ComputerType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "computer_type_seq")
    private Long id;
    @NotNull
    private String type;
}