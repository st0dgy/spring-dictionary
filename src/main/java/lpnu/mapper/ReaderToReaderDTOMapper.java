package lpnu.mapper;

import lpnu.dto.ExplanationDTO;
import lpnu.dto.ReaderDTO;
import lpnu.dto.WordDTO;
import lpnu.entity.Explanation;
import lpnu.entity.Reader;
import lpnu.entity.Word;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ReaderToReaderDTOMapper {
    public Reader toEntity(final ReaderDTO readerDTO) {
        return new Reader(
                readerDTO.getId(),
                readerDTO.getName(),
                readerDTO.getSurname(),
                readerDTO.getAge(),
                readerDTO.getDictionary());
    }

    public ReaderDTO toDTO(final Reader reader) {
        return new ReaderDTO(
                reader.getId(),
                reader.getName(),
                reader.getSurname(),
                reader.getAge(),
                reader.getDictionary());
    }
}
