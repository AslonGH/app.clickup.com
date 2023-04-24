package uz.pdp.springbootprojectprocesses.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springbootprojectprocesses.entity.les10_2.CheckList_Item;
import java.util.UUID;
public interface CheckList_ItemRepository extends JpaRepository<CheckList_Item, UUID> {
}
