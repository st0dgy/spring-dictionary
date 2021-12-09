package lpnu.mapper;

import lpnu.dto.DictionaryBookDTO;
import lpnu.entity.DictionaryBook;
import org.springframework.stereotype.Component;

@Component
public class DictionaryBookToDictionaryBookDTOMapper {
    public DictionaryBook toEntity(final DictionaryBookDTO dictionaryDTO) {
        return new DictionaryBook(
                dictionaryDTO.getId(),
                dictionaryDTO.getWord(),
                dictionaryDTO.getExplanation());
    }

    public DictionaryBookDTO toDTO(final DictionaryBook dictionary) {
        return new DictionaryBookDTO(
                dictionary.getId(),
                dictionary.getWord(),
                dictionary.getExplanation());
    }
}
