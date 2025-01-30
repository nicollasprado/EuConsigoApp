package com.EuConsigo.api.models;

import jakarta.persistence.*;

@Entity
@Table(name = Goal.TABLE_NAME)
public class Goal {
    public static final String TABLE_NAME = "goal";

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "goal_id", nullable = false, insertable = false, unique = true, updatable = false)
}
