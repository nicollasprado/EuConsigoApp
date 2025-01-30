package com.EuConsigo.api.models;

import com.EuConsigo.api.models.enums.VisibilityType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = User.TABLE_NAME)
@NoArgsConstructor
@Data
public class User {
    public static final String TABLE_NAME = "user";

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false, unique = true, insertable = false)
    private UUID id;

    @Column(name = "username", nullable = false)
    @NotBlank(message = "Username is mandatory.")
    private String username;

    @Column(name = "password", nullable = false)
    @NotBlank(message = "Password is mandatory")
    @Size(min = 8, max = 128)
    // Arrumando ainda:  @Pattern(regexp = "[^(?=.+[A-Za-z])(?=.+\\d)(?=.+[!@#$%&*?])]")
    private String password;

    @Column(name = "email", nullable = false)
    @NotBlank
    private String email;

    @Column(name = "creation_date", nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime creationDate;

    @Column(name = "visibility", nullable = false)
    private VisibilityType visibility;

    /*
    @JsonIgnore
    private ArrayList<Goal> goals;

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
