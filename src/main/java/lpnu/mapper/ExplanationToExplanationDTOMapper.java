package lpnu.mapper;

import lpnu.dto.ExplanationDTO;
import lpnu.entity.Explanation;
import org.springframework.stereotype.Component;

@Component
public class ExplanationToExplanationDTOMapper {
    public Explanation toEntity(final ExplanationDTO explanationDTO) {
        return new Explanation(
                explanationDTO.getId(),
                explanationDTO.getExplanation(),
                explanationDTO.getExample(),
                explanationDTO.getOrigin());
    }

    public ExplanationDTO toDTO(final Explanation explanation) {
        return new ExplanationDTO(
                explanation.getId(),
                explanation.getExplanation(),
                explanation.getExample(),
                explanation.getOrigin());
    }
}
