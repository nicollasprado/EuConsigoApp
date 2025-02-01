package com.EuConsigo.api.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = Task.TABLE_NAME)
@NoArgsConstructor
@Data
public class Task {
    public static final String TABLE_NAME = "tasks";

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "task_id", nullable = false, insertable = false, updatable = false, unique = true)
    @NotNull
    private UUID taskId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "goal_id", nullable = false, updatable = false)
    @NotNull
    private Goal goalId;

    @Column(name = "tittle", nullable = false)
    @NotBlank
    private String tittle;

    @Column(name = "completed", nullable = false)
    @NotNull
    private Boolean completed;


    public Task(Goal goalId, String tittle, Boolean completed) {
        this.goalId = goalId;
        this.tittle = tittle;
        this.completed = completed;
    }
}
