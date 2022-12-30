package com.ddc.springboot3.controller;

import com.ddc.springboot3.entity.BalanceSheetEntity;
import com.ddc.springboot3.model.BalanceSheet;
import com.ddc.springboot3.model.BalanceSheetModel;
import com.ddc.springboot3.repository.BalanceSheetRepository;
import com.ddc.springboot3.util.CalendarUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BalanceSheetController {

    @Autowired
    private BalanceSheetRepository balanceSheetRepository;
    @GetMapping(value = "/getAllBalanceSheet")
    public BalanceSheet getAllBalanceSheet() {
        BalanceSheet balanceSheet = new BalanceSheet();
        List<BalanceSheetEntity> balanceSheetEntityList = balanceSheetRepository.findAll();
        List<BalanceSheetModel> balanceSheetModelList = new ArrayList<>();
        Long totalAmount = 0l;
        Double totalAmountForCurrentMonth = 0.0;
        Double totalInterestForCurrentMonth = 0.0;
        Double remainingPrincipal = 0.0;
        for(BalanceSheetEntity balanceSheetEntity : balanceSheetEntityList) {
            BalanceSheetModel balanceSheetModel = new BalanceSheetModel();
            balanceSheetModel.setProductId(balanceSheetEntity.getProductId());
            balanceSheetModel.setProductName(balanceSheetEntity.getProductName());
            balanceSheetModel.setBankName(balanceSheetEntity.getBankName());
            balanceSheetModel.setTotalAmount(balanceSheetEntity.getTotalAmount());
            balanceSheetModel.setStageNumber(balanceSheetEntity.getStageNumber());
            balanceSheetModel.setAnnualInterestRate(balanceSheetEntity.getAnnualInterestRate());
            balanceSheetModel.setStartDate(balanceSheetEntity.getStartDate());
            balanceSheetModel.setMonthlyPrincipal(balanceSheetEntity.getMonthlyPrincipal());
            balanceSheetModel.setMonthlyInterest(balanceSheetEntity.getMonthlyInterest());
            balanceSheetModel.setAccountBillDate(balanceSheetEntity.getAccountBillDate());
            balanceSheetModel.setLastPaymentDate(balanceSheetEntity.getLastPaymentDate());
            balanceSheetModel.setCurrentStageNumber(CalendarUtil.getCurrentStageNumber(balanceSheetEntity.getStartDate()));
            Long remainingStageNumber = balanceSheetEntity.getStageNumber() - balanceSheetModel.getCurrentStageNumber();
            totalAmount += balanceSheetEntity.getTotalAmount();
            totalAmountForCurrentMonth += Double.parseDouble(balanceSheetEntity.getMonthlyPrincipal());
            totalInterestForCurrentMonth += Double.parseDouble(balanceSheetEntity.getMonthlyInterest());
            remainingPrincipal +=  Double.parseDouble(balanceSheetEntity.getMonthlyPrincipal()) * remainingStageNumber;
            balanceSheetModelList.add(balanceSheetModel);
        }
        balanceSheet.setTotalAmount(totalAmount);
        balanceSheet.setRemainingPrincipal(remainingPrincipal);
        balanceSheet.setTotalAmountForCurrentMonth(totalAmountForCurrentMonth);
        balanceSheet.setTotalInterestForCurrentMonth(totalInterestForCurrentMonth);
        balanceSheet.setBalanceSheetModelList(balanceSheetModelList);

        return balanceSheet;
    }
}
