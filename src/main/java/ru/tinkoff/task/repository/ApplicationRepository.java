package ru.tinkoff.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.tinkoff.task.entity.Application;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

    @Query(value = "FROM Application WHERE clientId = :clientId AND created = (SELECT MAX (created) FROM Application WHERE clientId = :clientId)")
    Application getLastApplicationForClient(Long clientId);

}
