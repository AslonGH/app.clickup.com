package uz.pdp.springbootprojectprocesses.serviceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import uz.pdp.springbootprojectprocesses.entity.les10_1.Task;
import uz.pdp.springbootprojectprocesses.entity.Les9.User;
import uz.pdp.springbootprojectprocesses.payload.ApiResponse;
import uz.pdp.springbootprojectprocesses.payload.TaskDto;
import uz.pdp.springbootprojectprocesses.repository.CategoryRepository;
import uz.pdp.springbootprojectprocesses.repository.PriorityRepository;
import uz.pdp.springbootprojectprocesses.repository.StatusRepository;
import uz.pdp.springbootprojectprocesses.repository.TaskRepository;
import uz.pdp.springbootprojectprocesses.serviceInterface.TaskService;

import java.text.*;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    StatusRepository statusRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    PriorityRepository priorityRepository;

    @Autowired
    TaskRepository taskRepository;


    @Override
    public ApiResponse addTask(TaskDto taskDto) {

      Task task=new Task();
    task.setName(taskDto.getName());
    task.setDescription(taskDto.getDescription());
    task.setStatus(statusRepository.findById(taskDto.getStatusID()).orElseThrow(() -> new ResourceNotFoundException("not found")));
    task.setCategory(categoryRepository.findById(taskDto.getCategoryID()).orElseThrow(() -> new ResourceNotFoundException("not found")));
    task.setParentTask(taskRepository.findById(taskDto.getParentTaskID()).orElseThrow(() -> new ResourceNotFoundException("not found")));
    task.setDueTimeHas(taskDto.getDueTimeHas());
    task.setStartTimeHas(taskDto.getStartTimeHas());
    task.setEstimateTime(taskDto.getEstimateTime());

        DateFormat dateFormat=new SimpleDateFormat("dd.MM.yyy hh:mm:ss");
        try {
            java.util.Date date  = dateFormat.parse(taskDto.getStartedDate());
            java.util.Date date1 = dateFormat.parse(taskDto.getDueDate());
            java.util.Date date2 = dateFormat.parse(taskDto.getActiveDate());
               java.sql.Date sqlDate  = new java.sql.Date(date.getTime());
               java.sql.Date sqlDate1 = new java.sql.Date(date1.getTime());
               java.sql.Date sqlDate2 = new java.sql.Date(date2.getTime());
            task.setStartedDate(sqlDate.toLocalDate());
            task.setDueDate(sqlDate1.toLocalDate());
            task.setActiveDate(sqlDate2.toLocalDate());
        } catch (Exception e) {
            return new ApiResponse("enter  date(dd.MM.yyyy)",false);
        }

        return new ApiResponse("saved",true);
    }


}
