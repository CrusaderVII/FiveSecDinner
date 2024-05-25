package egor.family.five_sec_dinner_service.dto;

import egor.family.five_sec_dinner_service.dao.model.Role;

import java.util.UUID;

public record UserDTO(UUID id, String name, Role role) {
}
