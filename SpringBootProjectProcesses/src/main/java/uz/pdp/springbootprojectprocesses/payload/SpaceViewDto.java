package uz.pdp.springbootprojectprocesses.payload;

import lombok.Data;
import java.util.UUID;

@Data
public class SpaceViewDto {

    private UUID spaceID;
    private UUID viewID;

}
