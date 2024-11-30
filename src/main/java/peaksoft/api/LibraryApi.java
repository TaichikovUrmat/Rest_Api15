package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.request.SaveLibraryRequest;
import peaksoft.dto.request.UpdateLibarayRequest;
import peaksoft.dto.respons.GetAllLibraryResponse;
import peaksoft.dto.respons.GetUpdateLibrary;
import peaksoft.dto.respons.SimpleResponse;
import peaksoft.entity.Library;
import peaksoft.service.BookService;
import peaksoft.service.LibraryService;

import java.util.List;

@RestController
@RequestMapping("/library")
@RequiredArgsConstructor
public class LibraryApi {

    private final LibraryService libraryService;
    private final BookService bookService;


    @GetMapping("/getAll")
    public List<GetAllLibraryResponse> getAllGroups() {
        return libraryService.findAll();
    }

    @PostMapping("/save")
    public SimpleResponse save(@RequestBody SaveLibraryRequest saveLibraryRequest) {
        return libraryService.saveLibrary(saveLibraryRequest);
    }

    @PutMapping("/assign")
    public void assing(@RequestParam Long libraryId, @RequestParam Long bookId) {
         libraryService.assignBookToLibrary(bookId,libraryId);
    }

    @PutMapping("/update/{libraryId}")
    public GetUpdateLibrary updateLibrary(@PathVariable("libraryId") Long libraryId,
                                          @RequestBody UpdateLibarayRequest updateLibarayRequest){
        return libraryService.updateLibrary(libraryId,updateLibarayRequest);
    }





}
