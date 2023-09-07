package com.abdullah.educationapi.repository;

import java.util.Optional;

import com.abdullah.educationapi.entity.ERole;
import com.abdullah.educationapi.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
