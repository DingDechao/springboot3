package com.ddc.springboot3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class BalanceSheetModel {

    private Long productId;
    private String productName;
    private String bankName;
    private Long totalAmount;
    private Long stageNumber;
    private String annualInterestRate;
    private String startDate;
    private String monthlyPrincipal;
    private String monthlyInterest;
    private String accountBillDate;
    private String lastPaymentDate;

    private int currentStageNumber;

}

