package egor.family.five_sec_dinner_service.dao.model;

import egor.family.five_sec_dinner_service.dto.UserDTO;
import egor.family.five_sec_dinner_service.dto.creation.UserCreationDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id")
    private UUID id;

    @Column(name = "user_name", nullable = false)
    private String name;

    @Column(name = "user_role", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Role role;

    public User(String name, Role role) {
        this.name = name;
        this.role = role;
    }

    public static User fromCreationDTO(UserCreationDTO dto) {
        return new User(dto.name(), dto.role());
    }

    public UserDTO toDTO() {
        return new UserDTO(this.id, this.name, this.role);
    }
}
