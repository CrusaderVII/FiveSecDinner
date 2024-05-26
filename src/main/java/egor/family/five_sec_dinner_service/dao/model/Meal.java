package egor.family.five_sec_dinner_service.dao.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "meals")
@Data
@NoArgsConstructor
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "meal_name", nullable = false)
    private String name;

    @Column(name = "meal_description")
    private String description;

    @Column(name = "meal_rating")
    private int rating;

    @Column(name = "meal_price")
    private long price;

    @ManyToMany
    @JoinTable(
            name = "orders_and_meals",
            joinColumns = {@JoinColumn(name = "meal_id")},
            inverseJoinColumns = {@JoinColumn(name = "order_id")}
    )
    private List<Order> orders;
}
