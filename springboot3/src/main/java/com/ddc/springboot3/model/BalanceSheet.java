package com.ddc.springboot3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BalanceSheet {

    private Long totalAmount;
    private Double remainingPrincipal;
    private Double totalAmountForCurrentMonth;
    private Double totalInterestForCurrentMonth;
    private List<BalanceSheetModel> balanceSheetModelList;

}
