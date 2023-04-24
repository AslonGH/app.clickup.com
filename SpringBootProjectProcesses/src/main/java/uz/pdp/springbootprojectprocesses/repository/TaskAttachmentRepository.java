package uz.pdp.springbootprojectprocesses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springbootprojectprocesses.entity.les10_1.TaskAttachment;

import java.util.UUID;

public interface TaskAttachmentRepository extends JpaRepository<TaskAttachment, UUID> {
}
