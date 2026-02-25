package api.automation.section_10_deserialization;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties
public class Courses {
    private List<WebAutomation> webAutomation;
    private List<Api> api;
    private List<Mobile> mobile;
}
