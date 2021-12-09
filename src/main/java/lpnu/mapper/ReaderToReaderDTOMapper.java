package lpnu.mapper;

import lpnu.dto.ReaderDTO;
import lpnu.entity.Reader;
import org.springframework.stereotype.Component;

@Component
public class ReaderToReaderDTOMapper {
    public Reader toEntity(final ReaderDTO readerDTO) {
        return new Reader(
                filmDTO.getId(),
                filmDTO.getDuration(),
                filmDTO.getName(),
                filmDTO.getMinAge(),
                filmDTO.getTechnology());
    }

    public ReaderDTO toDTO(final Reader reader) {
        return new ReaderDTO(
                reader.getId(),
                reader.getName(),
                reader.getSurname(),
                reader.getAge()
                reader.getDictionary());
    }
}
