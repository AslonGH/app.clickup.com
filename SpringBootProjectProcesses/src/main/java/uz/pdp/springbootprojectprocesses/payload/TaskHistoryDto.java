package uz.pdp.springbootprojectprocesses.payload;
import lombok.Data;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class TaskHistoryDto {

    private UUID taskID;
    private String changeFieldName;
    private Boolean before;
    private Boolean after;
    private String date;
}
