package uz.pdp.springbootprojectprocesses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springbootprojectprocesses.entity.les10_1.Comment;

import java.util.UUID;

public interface CommentRepository extends JpaRepository<Comment, UUID> {
}
