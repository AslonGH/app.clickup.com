package uz.pdp.springbootprojectprocesses.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {

   private String message;

   private boolean success;

   private List<Object> list;

   public ApiResponse(List<Object> list) {
      this.list = list;
   }

   public ApiResponse(String message, boolean success) {
      this.message = message;
      this.success = success;
   }
}
