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
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "invoice_seq")
    private Long id;

    @ManyToOne
    private @NotNull Brand brand;

    @ManyToOne
    private @NotNull ComputerType type;

    @ManyToOne
    private @NotNull Customer customer;

    
    @Size(min = 10)
    private @NotNull String symptom;
    private @NotNull Date requestDate;
    private @NotNull Date sentDate;
    private @NotNull String requestCode;

    @ManyToMany
    @JoinTable(name = "tool_request",
        joinColumns = @JoinColumn(name = "request_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "tool_id", referencedColumnName = "id"))
    @JsonBackReference
    private Collection<Tool> tool;

    // regular expression
    // [A-Za-z0-9._]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}
    // ^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$
    // @Pattern(regexp = "[A-Za-z0-9._]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}")
    @Email
    private @NotNull String email;

    @Pattern(regexp = "^[0-9]*$")
    private @NotNull String phone;
}