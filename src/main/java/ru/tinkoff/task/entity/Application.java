package ru.tinkoff.task.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.tinkoff.task.enums.Product;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@Table(name = "applications")
@NoArgsConstructor
@AllArgsConstructor
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long clientId;

    @Enumerated(EnumType.STRING)
    private Product productName;

    private LocalDateTime created;
}
