package fr.polytech.codev.backend.entities;

import fr.polytech.codev.backend.entities.pks.AssetPk;
import lombok.Data;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "assets")
@IdClass(AssetPk.class)
public class Asset implements fr.polytech.codev.backend.entities.Entity {

    @JsonbTransient
    @Id
    @ManyToOne
    @JoinColumn(name = "wallet")
    private Wallet wallet;

    @Id
    @ManyToOne
    @JoinColumn(name = "cryptocurrency")
    private Cryptocurrency cryptocurrency;

    @NotNull(message = "The amount can't be null!")
    @PositiveOrZero(message = "The amount can't be negative!")
    @Column(name = "amount")
    private BigDecimal amount;

    @NotNull(message = "The purchase price can't be null!")
    @PositiveOrZero(message = "The purchase price can't be negative!")
    @Column(name = "purchase_price")
    private BigDecimal purchasePrice;
}