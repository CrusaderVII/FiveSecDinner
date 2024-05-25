package egor.family.five_sec_dinner_service.dto.creation;

import egor.family.five_sec_dinner_service.dao.model.Role;

public record UserCreationDTO(String name, Role role) {
}
