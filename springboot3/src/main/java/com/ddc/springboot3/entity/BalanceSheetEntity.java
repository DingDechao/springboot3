package com.ddc.springboot3.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "BALANCE_SHEET")
public class BalanceSheetEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "PRODUCT_ID")
    private Long productId;
    @Column(name = "PRODUCT_NAME")
    private String productName;
    @Column(name = "BANK_NAME")
    private String bankName;
    @Column(name = "TOTAL_AMOUNT")
    private Long totalAmount;
    @Column(name = "STAGE_NUMBER")
    private Long stageNumber;
    @Column(name = "ANNUAL_INTEREST_RATE")
    private String annualInterestRate;
    @Column(name = "START_DATE")
    private String startDate;
    @Column(name = "MONTHLY_PRINCIPAL")
    private String monthlyPrincipal;
    @Column(name = "MONTHLY_INTEREST")
    private String monthlyInterest;
    @Column(name = "ACCOUNT_BILL_DATE")
    private String accountBillDate;
    @Column(name = "LAST_PAYMENT_DATE")
    private String lastPaymentDate;

}
