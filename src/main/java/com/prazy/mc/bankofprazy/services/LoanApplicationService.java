package com.prazy.mc.bankofprazy.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.dynamodbv2.document.Item;
import com.prazy.mc.bankofprazy.DAO.LoanDAO;
import com.prazy.mc.bankofprazy.DAO.UserDAO;
import com.prazy.mc.bankofprazy.beans.ApplyLoanResponse;
import com.prazy.mc.bankofprazy.beans.Loan;
import com.prazy.mc.bankofprazy.beans.LoanRequest;
import com.prazy.mc.bankofprazy.beans.User;
import com.prazy.mc.bankofprazy.models.LoanRequestDTO;
import com.prazy.mc.bankofprazy.models.UserDTO;

@Service
public class LoanApplicationService {
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	LoanDAO loanDAO;
	
	public ApplyLoanResponse applyForALoan(LoanRequest loanRequest) {
		
		ApplyLoanResponse applyLoanResponse = new ApplyLoanResponse();
		applyLoanResponse.setMessage("Loan Applied Successfully! You will receive an email with further details!");
		
		//Item userItem = userDAO.getUser(loanRequest.getMobileNumber());
		//System.out.println("User fetched : "+userItem.toJSONPretty());
		
		LoanRequestDTO loanDTO = new LoanRequestDTO();
		loanDTO.setMobileNumber(loanRequest.getMobileNumber());
		loanDTO.setLoanAmount(loanRequest.getLoanAmount());
		loanDTO.setLoanType(loanRequest.getLoanType());
		loanDTO.setTermInYears(loanRequest.getTermInYears());
		loanDAO.saveLoanRequest(loanDTO);
		
		applyLoanResponse.setUser(new User());
		applyLoanResponse.getUser().setMobileNumber(loanRequest.getMobileNumber());
		return applyLoanResponse;
	}
	
	
	public List<Loan> getLoanOptionsAndDetails(){
		
		Loan homeLoan = new Loan();
		
		homeLoan.setLoanType("HOME LOAN");
		homeLoan.setRateOfInterest("9.25 %");
		String[] homeLoanTerms = {"5 years", "10 years", "15 years", "20 years", "25 years", "30 years"};
		homeLoan.setTerms(Arrays.asList(homeLoanTerms));
		homeLoan.setMinimumApplicableLoanAmount("5,00,000 INR");
		
		Loan vehicleLoan = new Loan();
		
		vehicleLoan.setLoanType("CAR LOAN");
		vehicleLoan.setRateOfInterest("12.5 %");
		String[] vehicleLoanTerms = {"5 years", "10 years", "15 years"};
		vehicleLoan.setTerms(Arrays.asList(vehicleLoanTerms));
		vehicleLoan.setMinimumApplicableLoanAmount("1,25,000 INR");
		
		List<Loan> loanOptionsAndDetails = new ArrayList<Loan>(0);
		loanOptionsAndDetails.add(homeLoan);
		loanOptionsAndDetails.add(vehicleLoan);

		return loanOptionsAndDetails;
	}

}
