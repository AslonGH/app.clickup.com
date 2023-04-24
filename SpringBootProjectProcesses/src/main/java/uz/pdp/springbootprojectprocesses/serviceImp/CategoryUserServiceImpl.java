package uz.pdp.springbootprojectprocesses.serviceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import uz.pdp.springbootprojectprocesses.entity.les10_1.Category;
import uz.pdp.springbootprojectprocesses.entity.les10_1.CategoryUser;
import uz.pdp.springbootprojectprocesses.entity.les10_1.Icon;
import uz.pdp.springbootprojectprocesses.payload.ApiResponse;
import uz.pdp.springbootprojectprocesses.payload.CategoryUserDto;
import uz.pdp.springbootprojectprocesses.payload.Result;
import uz.pdp.springbootprojectprocesses.repository.CategoryRepository;
import uz.pdp.springbootprojectprocesses.repository.CategoryUserRepository;
import uz.pdp.springbootprojectprocesses.repository.UserRepository;
import uz.pdp.springbootprojectprocesses.serviceInterface.CategoryUserService;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryUserServiceImpl implements CategoryUserService {

    @Autowired
    CategoryUserRepository categoryUserRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    UserRepository userRepository;


    @Override
    public Result addCategoryUser(CategoryUserDto categoryUserDto) {
         CategoryUser categoryUser = new CategoryUser();
        categoryUser.setName(categoryUserDto.getName());
        categoryUser.setCategory(categoryRepository.findById(categoryUserDto.getCategoryID()).orElseThrow(() -> new ResourceNotFoundException("not found")));
        categoryUser.setUser(userRepository.findById(categoryUserDto.getUserID()).orElseThrow(() -> new ResourceNotFoundException("not found")));
        categoryUser.setTaskPermission(categoryUserDto.getTaskPermission());
        categoryUserRepository.save(categoryUser);
        return new Result("saved",true);
    }

    @Override
    public Result editCategoryUserById(CategoryUserDto categoryUserDto, UUID id) {

         CategoryUser categoryUser = categoryUserRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("not found"));
        categoryUser.setName(categoryUserDto.getName());
        categoryUser.setCategory(categoryRepository.findById(categoryUserDto.getCategoryID()).orElseThrow(() -> new ResourceNotFoundException("not found")));
        categoryUser.setUser(userRepository.findById(categoryUserDto.getUserID()).orElseThrow(() -> new ResourceNotFoundException("not found")));
        categoryUser.setTaskPermission(categoryUserDto.getTaskPermission());
        categoryUserRepository.save(categoryUser);
        return new Result("edited",true);
    }

    @Override
    public Result deleteCategoryUser(UUID id) {
        try {
            categoryUserRepository.deleteById(id);
            return new Result("deleted",true);
        }catch (Exception e){
            return new Result("not deleted",false);
        }
    }

}
