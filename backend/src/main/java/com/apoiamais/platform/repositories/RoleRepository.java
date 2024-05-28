package com.apoiamais.platform.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apoiamais.platform.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
