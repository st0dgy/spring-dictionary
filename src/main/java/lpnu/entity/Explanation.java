package lpnu.entity;

import javax.validation.constraints.NotBlank;
import java.util.Objects;

public class Explanation {
    private Long id;

    @NotBlank
    private String explanation;

    @NotBlank
    private String example;

    @NotBlank
    private String origin;

    public Explanation(){

    }

    public Explanation(final Long id, final String explanation, final String example, final String origin) {
        this.id = id;
        this.explanation = explanation;
        this.example = example;
        this.origin = origin;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(final String explanation) {
        this.explanation = explanation;
    }

    public String getExample() {
        return example;
    }

    public void setExample(final String example) {
        this.example = example;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Explanation that = (Explanation) o;
        return Objects.equals(explanation, that.explanation) && Objects.equals(example, that.example) && Objects.equals(origin, that.origin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(explanation, example, origin);
    }
}
