package com.ronjeanfrancois.budget.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Category name cannot be empty")
    private String categoryName;
    @Size(min= 4, max= 30, message = "Description should be between {min} and {max} characters.")
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private List<Expense> expenses;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name="budget_id")
    private Budget budget;
}
