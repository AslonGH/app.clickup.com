package uz.pdp.springbootprojectprocesses.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import uz.pdp.springbootprojectprocesses.entity.Les9.User;
import uz.pdp.springbootprojectprocesses.entity.les10_2.TaskHistory;
import uz.pdp.springbootprojectprocesses.entity.les10_2.TimeTracked;
import uz.pdp.springbootprojectprocesses.payload.ApiResponse;
import uz.pdp.springbootprojectprocesses.payload.TimeTrackedDto;
import uz.pdp.springbootprojectprocesses.repository.TaskRepository;
import uz.pdp.springbootprojectprocesses.repository.TimeTrackedRepository;
import uz.pdp.springbootprojectprocesses.serviceInterface.TimeTrackedService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class TimeTrackedServiceImpl implements TimeTrackedService {

    @Autowired
    TimeTrackedRepository timeTrackedRepository;
    @Autowired
    TaskRepository taskRepository;


    @Override
    public ApiResponse getTimeTracked() {

        List<TimeTracked> all = timeTrackedRepository.findAll();
        return new ApiResponse("list",true, Collections.singletonList(all));
    }

    @Override
    public ApiResponse addTimeTracked(TimeTrackedDto dto, User user) {

         TimeTracked timeTracked=new TimeTracked();
        timeTracked.setTask(taskRepository.findById(dto.getTaskID()).orElseThrow(() -> new ResourceNotFoundException("not found")));

        DateFormat dateFormat=new SimpleDateFormat("dd.MM.yyy hh:mm:ss");
        try {
            Date date  = dateFormat.parse(dto.getStartedAt());
            Date date1  = dateFormat.parse(dto.getStoppedAt());

            java.sql.Timestamp timestamp  = new java.sql.Timestamp(date.getTime());
            java.sql.Timestamp timestamp1  = new java.sql.Timestamp(date1.getTime());

            timeTracked.setStartedAt(timestamp);
            timeTracked.setStoppedAt(timestamp1);
        } catch (Exception e) {
            return new ApiResponse("enter  date(dd.MM.yyyy)",false);
        }
        timeTrackedRepository.save(timeTracked);
        return new ApiResponse("saved",true);
    }

    @Override
    public ApiResponse editTimeTracked(TimeTrackedDto dto, UUID id, User user) {

          TimeTracked timeTracked = timeTrackedRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("not found"));
        timeTracked.setTask(taskRepository.findById(dto.getTaskID()).orElseThrow(() -> new ResourceNotFoundException("not found")));

        DateFormat dateFormat=new SimpleDateFormat("dd.MM.yyy hh:mm:ss");
        try {
            Date date  = dateFormat.parse(dto.getStartedAt());
            Date date1  = dateFormat.parse(dto.getStoppedAt());

            java.sql.Timestamp timestamp  = new java.sql.Timestamp(date.getTime());
            java.sql.Timestamp timestamp1  = new java.sql.Timestamp(date1.getTime());

            timeTracked.setStartedAt(timestamp);
            timeTracked.setStoppedAt(timestamp1);
        } catch (Exception e) {
            return new ApiResponse("enter  date(dd.MM.yyyy)",false);
        }
        timeTrackedRepository.save(timeTracked);
        return new ApiResponse("saved",true);
    }

    @Override
    public ApiResponse deleteTimeTracked(UUID id) {
        try {
            timeTrackedRepository.deleteById(id);
            return new ApiResponse("deleted",true);
        }catch (Exception e){
            return new ApiResponse("not deleted",false);
        }
    }


}
