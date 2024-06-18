package app.project.content.role.domain.repository;

import app.project.content.role.domain.entity.Role;
import app.project.shared.enums.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
  Optional<Role> findByName(String name);
}
