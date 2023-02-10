package com.ronjeanfrancois.budget.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "categories")
public class Category {
    @Id
    @Column(name="categoryId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;
    @NotBlank
    private String description;

    @OneToMany(mappedBy = "category")
    private List<Expense> expenses;

    @OneToOne(mappedBy = "category", fetch = FetchType.LAZY)
    private Budget budget;
}
