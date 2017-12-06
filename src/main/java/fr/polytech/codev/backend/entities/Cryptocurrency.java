package fr.polytech.codev.backend.entities;

import lombok.Data;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cryptocurrencies")
public class Cryptocurrency implements fr.polytech.codev.backend.entities.Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank(message = "The name can't be blank!")
    @Size(message = "The name can't exceed 250 characters!", max = 250)
    @Column(name = "name")
    private String name;

    @NotBlank(message = "The symbol can't be blank!")
    @Size(message = "The symbol can't exceed 250 characters!", max = 250)
    @Column(name = "symbol")
    private String symbol;

    @NotBlank(message = "The image url can't be blank!")
    @Size(message = "The image url can't exceed 250 characters!", max = 250)
    @Column(name = "image_url")
    private String imageUrl;

    @NotBlank(message = "The base url can't be blank!")
    @Size(message = "The base url can't exceed 250 characters!", max = 250)
    @Column(name = "base_url")
    private String baseUrl;

    @NotBlank(message = "The resource url can't be blank!")
    @Size(message = "The resource url can't exceed 250 characters!", max = 250)
    @Column(name = "resource_url")
    private String resourceUrl;

    @NotNull(message = "The creation date can't be null!")
    @PastOrPresent(message = "The creation date can't be in the future!")
    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @NotNull(message = "The last update can't be null!")
    @PastOrPresent(message = "The last update can't be in the future!")
    @Column(name = "last_update")
    private LocalDateTime lastUpdate;
}