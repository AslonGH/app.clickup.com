package uz.pdp.springbootprojectprocesses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springbootprojectprocesses.entity.les10_1.Category;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
}
