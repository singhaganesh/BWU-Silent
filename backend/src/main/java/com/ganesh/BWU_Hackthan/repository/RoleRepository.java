package com.ganesh.BWU_Hackthan.repository;

import com.ganesh.BWU_Hackthan.model.AppRole;
import com.ganesh.BWU_Hackthan.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {

    Optional<Role> findByRoleName(AppRole appRole);
}
