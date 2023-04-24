package uz.pdp.springbootprojectprocesses.serviceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import uz.pdp.springbootprojectprocesses.entity.Les9.User;
import uz.pdp.springbootprojectprocesses.entity.les10_2.TaskDependency;
import uz.pdp.springbootprojectprocesses.entity.les10_2.TaskHistory;
import uz.pdp.springbootprojectprocesses.payload.ApiResponse;
import uz.pdp.springbootprojectprocesses.payload.TaskHistoryDto;
import uz.pdp.springbootprojectprocesses.repository.TaskDependencyRepository;
import uz.pdp.springbootprojectprocesses.repository.TaskHistoryRepository;
import uz.pdp.springbootprojectprocesses.repository.TaskRepository;
import uz.pdp.springbootprojectprocesses.serviceInterface.TaskHistoryService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.UUID;

@Service
public class TaskHistoryServiceImpl implements TaskHistoryService {

    @Autowired
    TaskHistoryRepository taskHistoryRepository;
    @Autowired
    TaskRepository taskRepository;


    @Override
    public ApiResponse addTaskHistory(TaskHistoryDto taskHistoryDto) {

         TaskHistory taskHistory=new TaskHistory();
        taskHistory.setTask(taskRepository.findById(taskHistoryDto.getTaskID()).orElseThrow(() -> new ResourceNotFoundException("not found")));
        taskHistory.setAfter(taskHistory.getAfter());
        taskHistory.setBefore(taskHistory.getBefore());

        DateFormat dateFormat=new SimpleDateFormat("dd.MM.yyy hh:mm:ss");
        try {
            java.util.Date date  = dateFormat.parse(taskHistoryDto.getDate());

            java.sql.Date sqlDate  = new java.sql.Date(date.getTime());
            taskHistory.setDate(sqlDate.toLocalDate());
        } catch (Exception e) {
            return new ApiResponse("enter  date(dd.MM.yyyy)",false);
        }

        taskHistory.setChangeFieldName(taskHistoryDto.getChangeFieldName());
        taskHistoryRepository.save(taskHistory);
        return new ApiResponse("saved",true);
    }

    @Override
    public ApiResponse editTaskHistory(TaskHistoryDto taskHistoryDto, UUID uuid) {
          TaskHistory taskHistory = taskHistoryRepository.findById(uuid).orElseThrow(() -> new ResourceNotFoundException("not found"));
        taskHistory.setTask(taskRepository.findById(taskHistoryDto.getTaskID()).orElseThrow(() -> new ResourceNotFoundException("not found")));
        taskHistory.setAfter(taskHistory.getAfter());
        taskHistory.setBefore(taskHistory.getBefore());

        DateFormat dateFormat=new SimpleDateFormat("dd.MM.yyy hh:mm:ss");
        try {
            java.util.Date date  = dateFormat.parse(taskHistoryDto.getDate());

            java.sql.Date sqlDate  = new java.sql.Date(date.getTime());
            taskHistory.setDate(sqlDate.toLocalDate());
        }
        catch (Exception e) {
            return new ApiResponse("enter  date(dd.MM.yyyy)",false);
        }

        taskHistory.setChangeFieldName(taskHistoryDto.getChangeFieldName());
        taskHistoryRepository.save(taskHistory);
        return new ApiResponse("saved",true);
    }

    @Override
    public ApiResponse deleteTaskHistory(UUID id) {
        try {
            taskHistoryRepository.deleteById(id);
            return new ApiResponse("deleted",true);
        }catch (Exception e){
            return new ApiResponse("not deleted",false);
        }
    }
}
