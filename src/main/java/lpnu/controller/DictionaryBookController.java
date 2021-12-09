package lpnu.controller;

import lpnu.dto.DictionaryBookDTO;
import lpnu.service.DictionaryBookService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1")
@RestController
public class DictionaryBookController {
    private final DictionaryBookService dictionaryService;

    public DictionaryBookController(final DictionaryBookService dictionaryService) {
        this.dictionaryService = dictionaryService;
    }

    @GetMapping("/dictionary-books")
    public ResponseEntity<List<DictionaryBookDTO>> getAllDictionaryBooks() {
        return ResponseEntity.ok().body(dictionaryService.getAllDictionaryBooks());
    }

    @GetMapping("/dictionary-books/{id}")
    public ResponseEntity<DictionaryBookDTO> getDictionaryBookById(@PathVariable final Long id) {
        return ResponseEntity.ok().body(dictionaryService.getDictionaryBookById(id));
    }

    @PostMapping("/dictionary-books")
    public ResponseEntity<DictionaryBookDTO> saveDictionaryBook(@Validated @RequestBody final DictionaryBookDTO dictionaryBookDTO) {
        return ResponseEntity.ok().body(dictionaryService.saveDictionaryBook(dictionaryBookDTO));
    }

    @PutMapping("/dictionary-books")
    public ResponseEntity<DictionaryBookDTO> updateDictionaryBook(@Validated @RequestBody final DictionaryBookDTO dictionaryBookDTO) {
        return ResponseEntity.ok().body(dictionaryService.updateDictionaryBook(dictionaryBookDTO));
    }

    @DeleteMapping("/dictionary-books/{id}")
    public ResponseEntity deleteDictionaryBookById(@PathVariable final Long id) {
        dictionaryService.deleteDictionaryBookById(id);
        return ResponseEntity.ok().build();
    }
}