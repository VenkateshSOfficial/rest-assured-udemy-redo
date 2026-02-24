
package api.automation.section_10_deserialization.pojo;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "webAutomation",
    "api",
    "mobile"
})
@Generated("jsonschema2pojo")
public class Courses__1 {

    @JsonProperty("webAutomation")
    private List<WebAutomation> webAutomation = new ArrayList<WebAutomation>();
    @JsonProperty("api")
    private List<Apus> api = new ArrayList<Apus>();
    @JsonProperty("mobile")
    private List<Mobile> mobile = new ArrayList<Mobile>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("webAutomation")
    public List<WebAutomation> getWebAutomation() {
        return webAutomation;
    }

    @JsonProperty("webAutomation")
    public void setWebAutomation(List<WebAutomation> webAutomation) {
        this.webAutomation = webAutomation;
    }

    @JsonProperty("api")
    public List<Apus> getApi() {
        return api;
    }

    @JsonProperty("api")
    public void setApi(List<Apus> api) {
        this.api = api;
    }

    @JsonProperty("mobile")
    public List<Mobile> getMobile() {
        return mobile;
    }

    @JsonProperty("mobile")
    public void setMobile(List<Mobile> mobile) {
        this.mobile = mobile;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Courses__1 .class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("webAutomation");
        sb.append('=');
        sb.append(((this.webAutomation == null)?"<null>":this.webAutomation));
        sb.append(',');
        sb.append("api");
        sb.append('=');
        sb.append(((this.api == null)?"<null>":this.api));
        sb.append(',');
        sb.append("mobile");
        sb.append('=');
        sb.append(((this.mobile == null)?"<null>":this.mobile));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.mobile == null)? 0 :this.mobile.hashCode()));
        result = ((result* 31)+((this.webAutomation == null)? 0 :this.webAutomation.hashCode()));
        result = ((result* 31)+((this.api == null)? 0 :this.api.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Courses__1) == false) {
            return false;
        }
        Courses__1 rhs = ((Courses__1) other);
        return (((((this.mobile == rhs.mobile)||((this.mobile!= null)&&this.mobile.equals(rhs.mobile)))&&((this.webAutomation == rhs.webAutomation)||((this.webAutomation!= null)&&this.webAutomation.equals(rhs.webAutomation))))&&((this.api == rhs.api)||((this.api!= null)&&this.api.equals(rhs.api))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
