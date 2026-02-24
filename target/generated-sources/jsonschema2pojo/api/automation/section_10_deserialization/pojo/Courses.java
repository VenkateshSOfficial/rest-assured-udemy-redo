
package api.automation.section_10_deserialization.pojo;

import java.util.LinkedHashMap;
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
    "instructor",
    "url",
    "services",
    "expertise",
    "courses",
    "linkedIn"
})
@Generated("jsonschema2pojo")
public class Courses {

    @JsonProperty("instructor")
    private String instructor;
    @JsonProperty("url")
    private String url;
    @JsonProperty("services")
    private String services;
    @JsonProperty("expertise")
    private String expertise;
    @JsonProperty("courses")
    private Courses__1 courses;
    @JsonProperty("linkedIn")
    private String linkedIn;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("instructor")
    public String getInstructor() {
        return instructor;
    }

    @JsonProperty("instructor")
    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("services")
    public String getServices() {
        return services;
    }

    @JsonProperty("services")
    public void setServices(String services) {
        this.services = services;
    }

    @JsonProperty("expertise")
    public String getExpertise() {
        return expertise;
    }

    @JsonProperty("expertise")
    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    @JsonProperty("courses")
    public Courses__1 getCourses() {
        return courses;
    }

    @JsonProperty("courses")
    public void setCourses(Courses__1 courses) {
        this.courses = courses;
    }

    @JsonProperty("linkedIn")
    public String getLinkedIn() {
        return linkedIn;
    }

    @JsonProperty("linkedIn")
    public void setLinkedIn(String linkedIn) {
        this.linkedIn = linkedIn;
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
        sb.append(Courses.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("instructor");
        sb.append('=');
        sb.append(((this.instructor == null)?"<null>":this.instructor));
        sb.append(',');
        sb.append("url");
        sb.append('=');
        sb.append(((this.url == null)?"<null>":this.url));
        sb.append(',');
        sb.append("services");
        sb.append('=');
        sb.append(((this.services == null)?"<null>":this.services));
        sb.append(',');
        sb.append("expertise");
        sb.append('=');
        sb.append(((this.expertise == null)?"<null>":this.expertise));
        sb.append(',');
        sb.append("courses");
        sb.append('=');
        sb.append(((this.courses == null)?"<null>":this.courses));
        sb.append(',');
        sb.append("linkedIn");
        sb.append('=');
        sb.append(((this.linkedIn == null)?"<null>":this.linkedIn));
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
        result = ((result* 31)+((this.courses == null)? 0 :this.courses.hashCode()));
        result = ((result* 31)+((this.instructor == null)? 0 :this.instructor.hashCode()));
        result = ((result* 31)+((this.services == null)? 0 :this.services.hashCode()));
        result = ((result* 31)+((this.linkedIn == null)? 0 :this.linkedIn.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.expertise == null)? 0 :this.expertise.hashCode()));
        result = ((result* 31)+((this.url == null)? 0 :this.url.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Courses) == false) {
            return false;
        }
        Courses rhs = ((Courses) other);
        return ((((((((this.courses == rhs.courses)||((this.courses!= null)&&this.courses.equals(rhs.courses)))&&((this.instructor == rhs.instructor)||((this.instructor!= null)&&this.instructor.equals(rhs.instructor))))&&((this.services == rhs.services)||((this.services!= null)&&this.services.equals(rhs.services))))&&((this.linkedIn == rhs.linkedIn)||((this.linkedIn!= null)&&this.linkedIn.equals(rhs.linkedIn))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.expertise == rhs.expertise)||((this.expertise!= null)&&this.expertise.equals(rhs.expertise))))&&((this.url == rhs.url)||((this.url!= null)&&this.url.equals(rhs.url))));
    }

}
