package uz.pdp.springbootprojectprocesses.payload;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class CheckListDto  {    // CheckList Task ga tegishli , CheckListItem esa CheckList ga tegishli

    @NotNull
    private String name;

    private UUID taskID;

}

