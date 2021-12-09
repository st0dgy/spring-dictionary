package lpnu.repository;

import lpnu.entity.Reader;
import lpnu.exception.ServiceException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ReaderRepository {
    private final List<Reader> readers = new ArrayList<>();
    private long id = 1;

    public List<Reader> getAllReaders() {
        return new ArrayList<>(readers);
    }

    public void deleteReaderById(final Long id) {
        for (final Reader reader : readers) {
            if (reader.getId().equals(id)) {
                readers.remove(reader);
                break;
            }
        }
    }

    public Reader updateReader(final Reader reader) {
        final Reader savedReader = getReaderById(reader.getId());

        savedReader.setName(reader.getName());
        savedReader.setSurname(reader.getSurname());
        savedReader.setAge(reader.getAge());
        savedReader.setDictionary(reader.getDictionary());

        return savedReader;
    }

    public void saveReader(final Reader reader) {
        reader.setId(id);
        ++id;
        readers.add(reader);
    }

    public Reader getReaderById(final Long id) {
        return readers.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "reader with id " + id + " not found"));
    }
}
