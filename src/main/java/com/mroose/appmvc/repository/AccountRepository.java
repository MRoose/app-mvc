package com.mroose.appmvc.repository;

import com.mroose.appmvc.model.Account;
import com.mroose.appmvc.model.AccountId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, AccountId> {

    Account findByUsername(String username);

    Long deleteByUsername(String username);
}