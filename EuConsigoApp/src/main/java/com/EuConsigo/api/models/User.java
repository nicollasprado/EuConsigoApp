package com.EuConsigo.api.models;

import com.EuConsigo.api.models.enums.VisibilityType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

@Entity
@Table(name = User.TABLE_NAME)
@NoArgsConstructor
@Data
public class User {
    public static final String TABLE_NAME = "users";

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false, unique = true, insertable = false)
    private UUID id;

    @Column(name = "username", nullable = false)
    @NotBlank(message = "Username is mandatory.")
    @Pattern(regexp = "^[A-Za-z]+$")
    private String username;

    @Column(name = "password", nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank(message = "Password is mandatory")
    @Size(min = 8, max = 128)
    @Pattern(regexp = "(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%&*?]).+")
    private String password;

    @Column(name = "email", nullable = false)
    @NotBlank
    @Pattern(regexp = "(?=[A-Z]|[a-z]|[0-9]).+(?=.+@)")
    private String email;

    @Column(name = "creation_date", nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime creationDate;

    @Column(name = "visibility", nullable = false)
    private VisibilityType visibility;

    @JsonIgnore
    @OneToMany(mappedBy = "user_id")
    private ArrayList<Goal> goals;
    /*
    @JsonIgnore
    private ArrayList<User> connections;
    */


    public User(String username, String password, String email){
        this.username = username;
        this.password = password;
        this.email = email;
        this.visibility = VisibilityType.PUBLIC;
    }
}
