package lpnu.mapper;

import lpnu.dto.WordDTO;
import lpnu.entity.Word;
import org.springframework.stereotype.Component;

@Component
public class WordToWordDTOMapper {
    public Word toEntity(final WordDTO wordDTO) {
        return new Word(
                wordDTO.getId(),
                wordDTO.getWord(),
                wordDTO.getPartOfSpeech());
    }

    public WordDTO toDTO(final Word word) {
        return new WordDTO(
                word.getId(),
                word.getWord(),
                word.getPartOfSpeech());
    }
}
