package lpnu.dto;

import lpnu.entity.Explanation;
import lpnu.entity.Word;

import java.util.Objects;

public class DictionaryBookDTO {
    private Long id;
    private Word word;
    private Explanation explanation;

    private DictionaryBookDTO(){

    }

    public DictionaryBookDTO(final Long id, final Word word, final Explanation explanation) {
        this.id = id;
        this.word = word;
        this.explanation = explanation;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Word getWord() {
        return word;
    }

    public void setWord(final Word word) {
        this.word = word;
    }

    public Explanation getExplanation() {
        return explanation;
    }

    public void setExplanation(final Explanation explanation) {
        this.explanation = explanation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DictionaryBookDTO that = (DictionaryBookDTO) o;
        return Objects.equals(word, that.word) && Objects.equals(explanation, that.explanation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word, explanation);
    }
}
