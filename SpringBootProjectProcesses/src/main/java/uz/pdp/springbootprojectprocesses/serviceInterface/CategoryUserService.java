package uz.pdp.springbootprojectprocesses.serviceInterface;
import uz.pdp.springbootprojectprocesses.payload.CategoryUserDto;
import uz.pdp.springbootprojectprocesses.payload.Result;
import java.util.UUID;

public interface CategoryUserService {

    Result addCategoryUser(CategoryUserDto categoryUserDto);

    Result editCategoryUserById(CategoryUserDto categoryUserDto, UUID id);

    Result deleteCategoryUser(UUID id);
}
