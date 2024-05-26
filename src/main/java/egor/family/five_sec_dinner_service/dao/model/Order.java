package egor.family.five_sec_dinner_service.dao.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "order_date", nullable = false)
    private LocalDate date;

    @Column(name = "order_total_price")
    private long totalPrice;

    @ManyToMany(mappedBy = "orders")
    private List<Meal> meals;
}
