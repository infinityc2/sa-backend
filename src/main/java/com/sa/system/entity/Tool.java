package com.sa.system.entity;

import java.util.Set;

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

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Setter @Getter
@Data
@NoArgsConstructor
@SequenceGenerator(name = "tool_seq", initialValue = 1)
public class Tool {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tool_seq")
    private Long id;
    private String name;

    @ManyToOne
    private ToolType type;
    private Long price;

    @ManyToMany
    @JoinTable(name = "tool_invoice",
        joinColumns = @JoinColumn(name = "tool_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "invoice_id", referencedColumnName = "id"))
    private Set<Invoice> invoice;
}