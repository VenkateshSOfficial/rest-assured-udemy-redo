package api.automation.section_13_E2E_ecommerce;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateOrderResponsePojo {
    private List<String> orders;
    private List<String> productOrderId;
    private String message;
}
