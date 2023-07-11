package com.zippy.api.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class Card {
    @NotNull
    private String cardNumber;
    @NotNull
    private LocalDateTime expirationDate;
    @NotNull
    private String name;

}
