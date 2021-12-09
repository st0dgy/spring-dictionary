package lpnu.controller;

import lpnu.dto.DictionaryDTO;
import lpnu.service.DictionaryService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1")
@RestController
public class DictionaryController {
    private final DictionaryService dictionaryService;

    public DictionaryController(final DictionaryService dictionaryService) {
        this.dictionaryService = dictionaryService;
    }

    @GetMapping("/dictionaries")
    public ResponseEntity<List<DictionaryDTO>> getAllDictionaries() {
        return ResponseEntity.ok().body(dictionaryService.getAllDictionaries());
    }

    @GetMapping("/dictionaries/{id}")
    public ResponseEntity<DictionaryDTO> getDictionaryById(@PathVariable final Long id) {
        return ResponseEntity.ok().body(dictionaryService.getDictionaryById(id));
    }

    @PostMapping("/dictionaries")
    public ResponseEntity<DictionaryDTO> saveDictionary(@Validated @RequestBody final DictionaryDTO dictionaryDTO) {
        return ResponseEntity.ok().body(dictionaryService.saveDictionary(dictionaryDTO));
    }

    @PutMapping("/dictionaries")
    public ResponseEntity<DictionaryDTO> updateDictionary(@Validated @RequestBody final DictionaryDTO dictionaryDTO) {
        return ResponseEntity.ok().body(dictionaryService.updateDictionary(dictionaryDTO));
    }

    @DeleteMapping("/dictionaries/{id}")
    public ResponseEntity deleteDictionaryById(@PathVariable final Long id) {
        dictionaryService.deleteDictionaryById(id);
        return ResponseEntity.ok().build();
    }
}