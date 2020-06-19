package ru.tinkoff.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.tinkoff.task.entity.Application;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

    // we can use @Query and Pageable and it will be platform independent but more difficult for reading
    @Query(value = "Select * FROM applications WHERE client_id = :clientId ORDER BY created DESC LIMIT 1",nativeQuery = true)
    Application getLastApplicationForClient(Long clientId);

}
