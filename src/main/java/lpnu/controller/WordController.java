package lpnu.controller;

import lpnu.dto.WordDTO;
import lpnu.service.WordService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1")
@RestController
public class WordController {
    private final WordService wordService;

    public WordController(final WordService wordService) {
        this.wordService = wordService;
    }

    @GetMapping("/words")
    public ResponseEntity<List<WordDTO>> getAllWords() {
        return ResponseEntity.ok().body(wordService.getAllWords());
    }

    @GetMapping("/words/{id}")
    public ResponseEntity<WordDTO> getWordById(@PathVariable final Long id) {
        return ResponseEntity.ok().body(wordService.getWordById(id));
    }

    @PostMapping("/words")
    public ResponseEntity<WordDTO> saveWord(@Validated @RequestBody final WordDTO wordDTO) {
        return ResponseEntity.ok().body(wordService.saveWord(wordDTO));
    }

    @PutMapping("/words")
    public ResponseEntity<WordDTO> updateWord(@Validated @RequestBody final WordDTO wordDTO) {
        return ResponseEntity.ok().body(wordService.updateWord(wordDTO));
    }

    @DeleteMapping("/words/{id}")
    public ResponseEntity deleteWordById(@PathVariable final Long id) {
        wordService.deleteWordById(id);
        return ResponseEntity.ok().build();
    }
}
