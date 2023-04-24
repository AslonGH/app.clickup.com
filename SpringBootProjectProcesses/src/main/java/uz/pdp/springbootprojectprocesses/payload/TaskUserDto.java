package uz.pdp.springbootprojectprocesses.payload;

import lombok.Data;

import java.util.UUID;


@Data
public class TaskUserDto {

    private UUID taskID;

    private UUID userID;

}
