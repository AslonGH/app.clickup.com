package uz.pdp.springbootprojectprocesses.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.springbootprojectprocesses.entity.template.AbsUUIDEntity;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class TaskDto {     // Task ni ham Task ham Subtask maqsadda foydalanamiz


    @NotNull
    private String  name;

    private String  description;

    private UUID    statusID;

    private UUID    categoryID;

    private UUID    priorityID;

    private UUID    parentTaskID;

    private String  startedDate;
    private String  dueDate;
    private String  activeDate;
    private Long    estimateTime;
    private Boolean dueTimeHas;
    private Boolean startTimeHas;

}
