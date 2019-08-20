package com.sa.system.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Setter @Getter
@Data
@NoArgsConstructor
@SequenceGenerator(name = "invoice_seq", initialValue = 1)
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "invoice_seq")
    private Long id;

    @ManyToOne
    @NotNull
    private Brand brand;

    @ManyToOne
    @NotNull
    private ComputerType type;

    @ManyToOne
    private Customer customer;

    @NotNull
    @Size(min = 10)
    private String symptom;
    private Date invoiceDate;
    private Date sentDate;
    private Date receiveDate;

    @ManyToMany
    @JoinTable(name = "tool_invoice",
        joinColumns = @JoinColumn(name = "invoice_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "tool_id", referencedColumnName = "id"))
    @JsonBackReference
    private Collection<Tool> tool;

    @NotNull
    @Email
    private String email;

    @NotNull 
    @Pattern(regexp = "^[0-9]*$")
    private String phone;
}