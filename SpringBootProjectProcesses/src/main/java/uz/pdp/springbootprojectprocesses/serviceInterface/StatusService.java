package uz.pdp.springbootprojectprocesses.serviceInterface;
import uz.pdp.springbootprojectprocesses.entity.Les9.User;
import uz.pdp.springbootprojectprocesses.payload.ApiResponse;
import uz.pdp.springbootprojectprocesses.payload.StatusDto;

import java.util.UUID;


public interface StatusService {

    ApiResponse addStatus(StatusDto statusDto);

    ApiResponse editStatus(StatusDto statusDto, UUID id);


}
