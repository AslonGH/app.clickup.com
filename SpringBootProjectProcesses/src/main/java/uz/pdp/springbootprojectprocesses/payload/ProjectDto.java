package uz.pdp.springbootprojectprocesses.payload;
import lombok.Data;
import uz.pdp.springbootprojectprocesses.entity.template.AbsUUIDEntity;

import javax.validation.constraints.NotNull;
import java.util.UUID;


@Data
public class ProjectDto {   // Space ichidagi  Project (Loyiha), Project ichida Category boladi

    @NotNull
    private  String   name;

    private  UUID     spaceId;

    private  String   accessType;

    private  boolean  archived;

    private  String   color;
}
