package uz.pdp.springbootprojectprocesses.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springbootprojectprocesses.entity.les10_1.AttachmentContent;
import java.util.Optional;
import java.util.UUID;

public interface AttachmentContentRepository extends JpaRepository<AttachmentContent,Integer> {

    Optional<AttachmentContent> findByAttachmentId(UUID attachment_id);

}
