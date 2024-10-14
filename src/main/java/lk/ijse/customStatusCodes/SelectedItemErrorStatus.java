package lk.ijse.customStatusCodes;


import lk.ijse.dto.ItemStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SelectedItemErrorStatus implements ItemStatus {
    private int statusCode;
    private String statusMessage;
}
