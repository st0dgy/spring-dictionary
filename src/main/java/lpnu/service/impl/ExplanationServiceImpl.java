package lpnu.service.impl;

import lpnu.dto.ExplanationDTO;
import lpnu.entity.Explanation;
import lpnu.entity.Word;
import lpnu.exception.ServiceException;
import lpnu.mapper.ExplanationToExplanationDTOMapper;
import lpnu.repository.ExplanationRepository;
import lpnu.service.ExplanationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExplanationServiceImpl implements ExplanationService {
    private final ExplanationToExplanationDTOMapper explanationMapper;
    private final ExplanationRepository explanationRepository;

    public ExplanationServiceImpl(final ExplanationToExplanationDTOMapper explanationMapper,
                                  final ExplanationRepository explanationRepository) {
        this.explanationMapper = explanationMapper;
        this.explanationRepository = explanationRepository;
    }

    @Override
    public List<ExplanationDTO> getAllExplanations() {
        return explanationRepository.getAllExplanations().stream()
                .map(explanationMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ExplanationDTO getExplanationById(final Long id) {
        return explanationMapper.toDTO(explanationRepository.getExplanationById(id));
    }

    @Override
    public void deleteExplanationById(final Long id) {
        explanationRepository.deleteExplanationById(id);
    }

    @Override
    public ExplanationDTO updateExplanation(final ExplanationDTO explanationDTO) {
        if (explanationDTO.getId() == null) {
            throw new ServiceException(400, "id is null");
        }

        final Explanation explanation = explanationMapper.toEntity(explanationDTO);
        return explanationMapper.toDTO(explanationRepository.updateExplanation(explanation));
    }

    @Override
    public ExplanationDTO saveExplanation(final ExplanationDTO explanationDTO) {
        if (explanationDTO.getId() != null) {
            throw new ServiceException(400, "id not null");
        }

        if (explanationRepository.getAllExplanations().stream().anyMatch(explanationMapper.toEntity(explanationDTO)::equals)) {
            throw new ServiceException(400, "explanation is already saved");
        }

        final Explanation explanation = explanationMapper.toEntity(explanationDTO);

        explanationRepository.saveExplanation(explanation);
        return explanationMapper.toDTO(explanation);
    }
}
