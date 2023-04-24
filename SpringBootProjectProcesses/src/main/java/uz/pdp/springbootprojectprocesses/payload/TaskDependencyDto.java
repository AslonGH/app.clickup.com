package uz.pdp.springbootprojectprocesses.payload;
import lombok.Data;
import uz.pdp.springbootprojectprocesses.entity.enums.DependencyType;
import java.util.UUID;

@Data
public class TaskDependencyDto {

    private UUID taskID;

    private UUID  dependencyTaskID;

    private DependencyType dependencyType;

}
