package uz.pdp.springbootprojectprocesses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springbootprojectprocesses.entity.les10_2.CheckList;
import uz.pdp.springbootprojectprocesses.payload.CheckListDto;

import java.util.UUID;

public interface CheckListRepository extends JpaRepository<CheckList, UUID> {
}
