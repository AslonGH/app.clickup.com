package uz.pdp.springbootprojectprocesses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springbootprojectprocesses.entity.les10_1.Tag;

import java.util.UUID;

public interface TagRepository extends JpaRepository<Tag, UUID> {
}
