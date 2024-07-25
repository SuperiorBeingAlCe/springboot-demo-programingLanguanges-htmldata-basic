package jpa.technologies.Business.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@NonNull
public class UpdateTechnologyRequest {
    private int request_id;
    private String name;
    private int language_id;
}
