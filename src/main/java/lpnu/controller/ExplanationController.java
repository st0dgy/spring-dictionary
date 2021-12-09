package lpnu.controller;

import lpnu.dto.ExplanationDTO;
import lpnu.service.ExplanationService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1")
@RestController
public class ExplanationController {
    private final ExplanationService explanationService;

    public ExplanationController(final ExplanationService explanationService) {
        this.explanationService = explanationService;
    }

    @GetMapping("/explanations")
    public ResponseEntity<List<ExplanationDTO>> getAllExplanations() {
        return ResponseEntity.ok().body(explanationService.getAllExplanations());
    }

    @GetMapping("/explanations/{id}")
    public ResponseEntity<ExplanationDTO> getExplanationById(@PathVariable final Long id) {
        return ResponseEntity.ok().body(explanationService.getExplanationById(id));
    }

    @PostMapping("/explanations")
    public ResponseEntity<ExplanationDTO> saveExplanation(@Validated @RequestBody final ExplanationDTO explanationDTO) {
        return ResponseEntity.ok().body(explanationService.saveExplanation(explanationDTO));
    }

    @PutMapping("/explanations")
    public ResponseEntity<ExplanationDTO> updateExplanation(@Validated @RequestBody final ExplanationDTO explanationDTO) {
        return ResponseEntity.ok().body(explanationService.updateExplanation(explanationDTO));
    }

    @DeleteMapping("/explanations/{id}")
    public ResponseEntity deleteExplanationById(@PathVariable final Long id) {
        explanationService.deleteExplanationById(id);
        return ResponseEntity.ok().build();
    }
}
