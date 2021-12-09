package lpnu.service;

import lpnu.dto.ExplanationDTO;

import java.util.List;

public interface ExplanationService {
    ExplanationDTO saveExplanation(final ExplanationDTO explanationDTO);
    List<ExplanationDTO> getAllExplanations();
    ExplanationDTO getExplanationById(final Long id);
    ExplanationDTO updateExplanation(final ExplanationDTO explanationDTO);
    void deleteExplanationById(final Long id);
}
