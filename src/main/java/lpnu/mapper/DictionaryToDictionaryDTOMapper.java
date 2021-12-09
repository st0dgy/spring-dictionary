package lpnu.mapper;

import lpnu.dto.DictionaryDTO;
import lpnu.entity.Dictionary;
import org.springframework.stereotype.Component;

@Component
public class DictionaryToDictionaryDTOMapper {
    public Dictionary toEntity(final DictionaryDTO dictionaryDTO) {
        return new Dictionary(
                dictionaryDTO.getId(),
                dictionaryDTO.getWord(),
                dictionaryDTO.getExplanation());
    }

    public DictionaryDTO toDTO(final Dictionary word) {
        return new DictionaryDTO(
                word.getId(),
                word.getWord(),
                word.getExplanation());
    }
}
