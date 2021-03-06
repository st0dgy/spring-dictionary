package lpnu.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Objects;

public class Reader {
    private Long id;

    @Pattern(regexp="([A-Z][a-z]+[\\s-]?)*[A-Z][a-z]+", message="Invalid user name")
    private String name;

    @Pattern(regexp="([A-Z][a-z]+[\\s-]?)*[A-Z][a-z]+", message="Invalid user surname")
    private String surname;

    @NotNull
    @Min(6)
    @Max(100)
    private Integer age;

    private DictionaryBook dictionaryBook;

    public Reader(){

    }

    public Reader(final Long id, final String name, final String surname, final Integer age, final DictionaryBook dictionaryBook) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.dictionaryBook = dictionaryBook;
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

    public DictionaryBook getDictionaryBook() {
        return dictionaryBook;
    }

    public void setDictionaryBook(final DictionaryBook dictionaryBook) {
        this.dictionaryBook = dictionaryBook;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reader reader = (Reader) o;
        return Objects.equals(name, reader.name) && Objects.equals(surname, reader.surname) && Objects.equals(age, reader.age) && Objects.equals(dictionaryBook, reader.dictionaryBook);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, dictionaryBook);
    }
}
