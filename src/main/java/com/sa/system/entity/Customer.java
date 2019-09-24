package com.sa.system.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Setter @Getter
@Data
@NoArgsConstructor
@SequenceGenerator(name = "customer_seq", initialValue = 1)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
    private Long id;

    @Email @Column(unique = true)
    // @Pattern(regexp = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$")
    private @NotNull String email;

    private @NotNull String firstname;
    private @NotNull String lastname;
    
    @Size(min = 8)
    private @NotNull String password;

    @Pattern(regexp = "[0-9]+")
    private @NotNull String phone;

    @ManyToOne
    @NotNull
    private CustomerType customerType;

    private @NotNull String address;

    @ManyToOne
    @NotNull
    private Gender gender;

    @OneToOne
    @NotNull
    private Province province;
}