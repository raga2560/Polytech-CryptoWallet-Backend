package fr.polytech.codev.backend.entities;

import lombok.Data;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tokens")
public class Token implements fr.polytech.codev.backend.entities.Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank(message = "The value can't be blank!")
    @Size(message = "The value can't exceed 36 characters!", max = 36)
    @Column(name = "value")
    private String value;

    @NotNull(message = "The begin date can't be null!")
    @PastOrPresent(message = "The begin date can't be in the future!")
    @Column(name = "begin_date")
    private LocalDateTime beginDate;

    @NotNull(message = "The end date can't be null!")
    @FutureOrPresent(message = "The end date can't be in the past!")
    @Column(name = "end_date")
    private LocalDateTime endDate;

    @NotNull(message = "The creation date can't be null!")
    @PastOrPresent(message = "The creation date can't be in the future!")
    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @NotNull(message = "The last update can't be null!")
    @PastOrPresent(message = "The last update can't be in the future!")
    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

    @JsonbTransient
    @NotNull(message = "The user can't be null!")
    @ManyToOne
    @JoinColumn(name = "user")
    private User user;
}