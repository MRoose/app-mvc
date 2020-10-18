package com.mroose.appmvc.service;

import com.mroose.appmvc.model.Account;
import com.mroose.appmvc.model.Summary;
import com.mroose.appmvc.repository.AccountRepository;
import com.mroose.appmvc.repository.SummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class MethodsForControllers {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    SummaryRepository summaryRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public Account getAccountByUsername(String username) {
        return accountRepository.findByUsername(username);
    }

    public List<Account> getAccountList() {
        return accountRepository.findAll();
    }

    public void saveAccount(Account account) {
        account.setPassword(bCryptPasswordEncoder.encode(account.getPassword()));
        accountRepository.save(account);
    }

    public boolean deleteAccountByUsername(String username) {
        if (accountRepository.findByUsername(username) != null) {
            return false;
        }
        Long deleteCount = accountRepository.deleteByUsername(username);
        return deleteCount.intValue() == 1;
    }

//////////////////////////////////////////////////////////////////////////////////////////////

    public Summary getSummaryByUsername(String username) {
        return summaryRepository.findByUsername(username);
    }

    public List<Summary> getSummaryList() {
        return summaryRepository.findAll();
    }

    public void saveSummary(Summary summary) {
        summaryRepository.save(summary);
    }

    public boolean deleteSummaryByUsername(String username) {
        Long deleteCount = summaryRepository.deleteByUsername(username);
        return deleteCount.intValue() == 1;
    }

    public void deleteAccount(String username) {
        accountRepository.deleteByUsername(username);
        summaryRepository.deleteByUsername(username);
    }
}
