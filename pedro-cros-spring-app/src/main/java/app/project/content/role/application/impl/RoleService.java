package app.project.content.role.application.impl;

import app.project.content.role.domain.entity.Role;
import app.project.content.role.domain.repository.RoleRepository;
import app.project.shared.enums.ERole;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public Optional<Role> findRoleByERole(ERole eRole) {
        return roleRepository.findByName(eRole);
    }

    public Optional<Role> findRoleByName(String roleName) {
        return roleRepository.findByName(roleName);
    }
}
