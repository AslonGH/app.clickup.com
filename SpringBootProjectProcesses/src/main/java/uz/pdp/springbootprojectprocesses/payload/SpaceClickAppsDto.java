package uz.pdp.springbootprojectprocesses.payload;
import lombok.Data;
import java.util.UUID;


@Data
public class SpaceClickAppsDto {    //Space va ClicksApps ni birlashgan joyi

    private UUID spaceID;

    private UUID clickAppsID;   // yani name desa boladi

}
