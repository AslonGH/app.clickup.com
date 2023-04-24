package uz.pdp.springbootprojectprocesses.payload;
import lombok.Data;
import java.util.UUID;

@Data
public class TimeTrackedDto {

    private UUID taskID;

    private String startedAt;

    private String stoppedAt;

}
