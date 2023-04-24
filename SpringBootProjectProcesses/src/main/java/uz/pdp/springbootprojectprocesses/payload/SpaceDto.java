package uz.pdp.springbootprojectprocesses.payload;
import lombok.Data;
import uz.pdp.springbootprojectprocesses.entity.template.AbsUUIDEntity;

import javax.validation.constraints.NotNull;
import java.util.UUID;


@Data
public class SpaceDto {              // DEPARTMENT YANI ISHXONADAGI BITTA BO'LIM


    @NotNull
    private String name;

    private String color;

    private Long workSpaceId;

    private String  initialLetter;

    private String accessType;

    private UUID iconId;

    private UUID avatarId;

    private UUID ownerId;

}
