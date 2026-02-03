package com.example.HomeBankingApi.repositories;
import com.example.HomeBankingApi.models.Account;
import com.example.HomeBankingApi.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource
public interface AccountRepository extends JpaRepository<Account, Long>{
}
