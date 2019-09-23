package com.sa.system.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Data
@Getter @Setter
@NoArgsConstructor
@SequenceGenerator(name = "repairman_seq", initialValue = 1)
public class Repairman {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "repairman_seq")
    private Long id;

    private @NotNull String firstName;

    private @NotNull String lastName;

    @Pattern(regexp = "^[0-9]*$")
    private @NotNull String phone;

    @ManyToOne
    private Gender gender;

    @ManyToOne
    private Expertise expertise;

    @ManyToOne
    private Position position;
}