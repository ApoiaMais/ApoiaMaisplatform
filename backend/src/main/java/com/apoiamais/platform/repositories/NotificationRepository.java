package com.apoiamais.platform.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apoiamais.platform.entities.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long>{

    

}
