package com.golive.demo.hexagonal.adapters.outgoing.repository.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AccountJPARepository extends JpaRepository<AccountsEntity, Long> {
    void deleteByAccNo(String accNo);
    Optional<AccountsEntity> findByAccNo(String accNo);

    @Modifying
    @Query(value = "UPDATE Account ac SET ac.balance = ac.balance + :amt WHERE ac.accNo = :accNo")
    int addBalance(@Param("accNo") String accNo, @Param("amt") long amt);

    @Modifying
    @Query(value = "UPDATE Account ac SET ac.balance = ac.balance - :amt WHERE ac.accNo = :accNo")
    int deductBalance(@Param("accNo") String accNo, @Param("amt") long amt);
}
