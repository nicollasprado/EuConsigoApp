package com.EuConsigo.api.models;

import com.EuConsigo.api.models.enums.VisibilityType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

@Entity
@Table(name = Goal.TABLE_NAME)
@NoArgsConstructor
@Data
public class Goal {
    public static final String TABLE_NAME = "goals";

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "goal_id", nullable = false, insertable = false, unique = true, updatable = false)
    @NotNull
    private UUID goalId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    @NotNull
    private User userId;

    @Column(name = "tittle", nullable = false)
    @NotBlank
    private String tittle;

    @Column(name = "description")
    private String description;

    @Column(name = "achieved", nullable = false)
    @NotNull
    private Boolean achieved;

    @Column(name = "visibility", nullable = false)
    @NotNull
    @JsonValue
    private VisibilityType visibility;

    @Column(name = "deadline_date")
    private LocalDateTime deadlineDate;

    @JsonIgnore
    @OneToMany(mappedBy = "goalId", cascade = CascadeType.REMOVE)
    private ArrayList<Task> tasks;


    public Goal(User userId, String tittle, String description, VisibilityType visibility, Boolean achieved, LocalDateTime deadlineDate) {
        this.userId = userId;
        this.tittle = tittle;
        this.description = description;
        this.visibility = visibility;
        this.achieved = achieved;
        this.deadlineDate = deadlineDate;
    }
}
