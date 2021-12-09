package lpnu.dto;

import lpnu.entity.Dictionary;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Objects;

public class ReaderDTO {
    private Long id;

    @Pattern(regexp="([A-Z][a-z]+[\\s-]?)*[A-Z][a-z]+", message="Invalid user name")
    private String name;

    @Pattern(regexp="([A-Z][a-z]+[\\s-]?)*[A-Z][a-z]+", message="Invalid user surname")
    private String surname;

    @NotNull
    @Min(6)
    @Max(100)
    private Integer age;

    private Dictionary dictionary;

    public ReaderDTO(){

    }

    public ReaderDTO(final Long id, final String name, final String surname, final Integer age, final Dictionary dictionary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.dictionary = dictionary;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(final String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(final Integer age) {
        this.age = age;
    }

    public Dictionary getDictionary() {
        return dictionary;
    }

    public void setDictionary(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReaderDTO readerDTO = (ReaderDTO) o;
        return Objects.equals(name, readerDTO.name) && Objects.equals(surname, readerDTO.surname) && Objects.equals(age, readerDTO.age) && Objects.equals(dictionary, readerDTO.dictionary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, dictionary);
    }
}
