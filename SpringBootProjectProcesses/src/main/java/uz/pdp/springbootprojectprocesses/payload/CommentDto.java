package uz.pdp.springbootprojectprocesses.payload;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.springbootprojectprocesses.entity.template.AbsUUIDEntity;

import javax.persistence.Entity;
import java.util.UUID;


@Data
public class CommentDto {

    private String  name;

    private UUID    taskId;

}
