package lpnu.repository;

import lpnu.entity.Explanation;
import lpnu.exception.ServiceException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ExplanationRepository {
    private final List<Explanation> explanations = new ArrayList<>();
    private long id = 1;

    public List<Explanation> getAllExplanations() {
        return new ArrayList<>(explanations);
    }

    public void deleteExplanationById(final Long id) {
        for (final Explanation explanation : explanations) {
            if (explanation.getId().equals(id)) {
                explanations.remove(explanation);
                break;
            }
        }
    }

    public Explanation updateExplanation(final Explanation explanation) {
        final Explanation savedExplanation = getExplanationById(explanation.getId());

        savedExplanation.setExplanation(explanation.getExplanation());
        savedExplanation.setExample(explanation.getExample());
        savedExplanation.setOrigin(explanation.getOrigin());

        return savedExplanation;
    }

    public void saveExplanation(final Explanation explanation) {
        explanation.setId(id);
        ++id;
        explanations.add(explanation);
    }

    public Explanation getExplanationById(final Long id) {
        return explanations.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "explanation with id " + id + " not found"));
    }
}
