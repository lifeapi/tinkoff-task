package ru.tinkoff.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tinkoff.task.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
