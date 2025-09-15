package com.example.GoCafe.repository;

import com.example.GoCafe.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    long countByRecipient_EmailAndReadIsFalse(String email);
    List<Notification> findTop20ByRecipient_EmailOrderByCreatedAtDesc(String email);
    List<Notification> findByRecipient_EmailAndReadIsFalseOrderByCreatedAtDesc(String email);
}
