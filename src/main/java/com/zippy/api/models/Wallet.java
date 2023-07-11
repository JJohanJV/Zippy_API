package com.zippy.api.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
public class Wallet {
    @NotNull
    private BigDecimal balance;
    private List<Transaction> transactions;
}
