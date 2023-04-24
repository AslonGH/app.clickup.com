package uz.pdp.springbootprojectprocesses.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.springbootprojectprocesses.entity.Les9.Project;
import uz.pdp.springbootprojectprocesses.entity.les10_1.Category;
import uz.pdp.springbootprojectprocesses.payload.CategoryDto;
import uz.pdp.springbootprojectprocesses.payload.Result;
import uz.pdp.springbootprojectprocesses.repository.CategoryRepository;
import uz.pdp.springbootprojectprocesses.repository.ProjectRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service    //  BU CLASS DB DAN MA#LUMOT/NI OLIB CONTROLLER CLASS GA YETKAZADI
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ProjectRepository projectRepository;



    // CREATE
    public Result addCategory(CategoryDto categoryDto) {

         Category category=new Category();
      if (categoryDto.getProjectId()!=null){
      Optional<Project> optionalProject = projectRepository.findById(categoryDto.getProjectId());
      if (!optionalProject.isPresent()) return new Result("Bunday ota Project  mavjud emas",false);
        category.setProject(optionalProject.get());
      }
        category.setName(categoryDto.getName());
        category.setArchived(categoryDto.isArchived());
        category.setAccessType(categoryDto.getAccessType());
        category.setColor(categoryDto.getColor());
        categoryRepository.save(category);
      return new Result("Muvaffaqiyatli saqlandi",true);
}

    public Result editCategoryById(CategoryDto categoryDto,UUID id) {

     Optional<Category> optionalCategory = categoryRepository.findById(id);
     if (!optionalCategory.isPresent()) return new Result("Bunday Category  mavjud emas",false);

           Category category=optionalCategory.get();

          if (categoryDto.getProjectId()!=null){
         Optional<Project> optionalProject = projectRepository.findById(categoryDto.getProjectId());
         if (!optionalProject.isPresent()) return new Result("Bunday ota Project  mavjud emas",false);
         category.setProject(optionalProject.get());
     }
        category.setName(categoryDto.getName());
        category.setArchived(categoryDto.isArchived());
        category.setAccessType(categoryDto.getAccessType());
        category.setColor(categoryDto.getColor());
        categoryRepository.save(category);
        return new Result("Muvaffaqiyatli özgartirildi",true);
    }

    // GET
    public List<Category> getCategory(){
        return categoryRepository.findAll();
    }

    // GET BY ID
    public Category getCategoryById(UUID id){
        Optional<Category> byId = categoryRepository.findById(id);
        return byId.orElseGet(Category::new);   // Bo'lsa o'shani aks holda bo'sh Object qaytaradi.
    }

    public Result deleteCategory(UUID id){
        try {
            categoryRepository.deleteById(id);
            return new Result("kategoriya öchirildi",true);
        }catch (Exception e){
            return new Result("Bunday ota kategoriya mavjud emas",false);
        }

    }

}
