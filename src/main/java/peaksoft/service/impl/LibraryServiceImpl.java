package peaksoft.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.dto.request.SaveLibraryRequest;
import peaksoft.dto.request.UpdateLibarayRequest;
import peaksoft.dto.respons.GetAllBookResponse;
import peaksoft.dto.respons.GetAllLibraryResponse;
import peaksoft.dto.respons.GetUpdateLibrary;
import peaksoft.dto.respons.SimpleResponse;
import peaksoft.entity.Book;
import peaksoft.entity.Library;
import peaksoft.repository.BookRepo;
import peaksoft.repository.LibraryRepo;
import peaksoft.service.LibraryService;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class LibraryServiceImpl implements LibraryService {

    private final LibraryRepo libraryRepo;
    private final BookRepo bookRepo;

    @Override
    public SimpleResponse saveLibrary(SaveLibraryRequest saveLibraryRequest) {

        List<Library> allLibrary = libraryRepo.getAllLibrary();
        for (Library library1 : allLibrary) {
            if (library1.getName().equals(saveLibraryRequest.getName())) {
                throw new RuntimeException( saveLibraryRequest.getName() + " name  okshosh eken  bashka name tanda !  ");
            }
        }
        Library library = new Library();
        library.setName(saveLibraryRequest.getName());
        library.setAddress(saveLibraryRequest.getAddress());
        libraryRepo.save(library);
        return SimpleResponse
                .builder()
                .status(HttpStatus.OK)
                .message("Library saved !")
                .build();
    }

    @Override
    public List<GetAllLibraryResponse> findAll() {
        List<Library> allLibrary = libraryRepo.getAllLibrary();

        return  allLibrary.stream().map(library ->
                 GetAllLibraryResponse
                         .builder()
                         .id(library.getId())
                         .name(library.getName())
                         .address(library.getAddress())
                         .getAllBook(getAllBookResponses(library.getId()))
                         .build()).collect(Collectors.toList());
    }

    private List<GetAllBookResponse> getAllBookResponses(Long libraryId) {
        for (Library library : libraryRepo.getAllLibrary()) {
            if (library.getId().equals(libraryId)) {
                for (Book book : library.getBook()) {
                    return Collections.singletonList(GetAllBookResponse
                            .builder()
                            .id(book.getId())
                            .bookName(book.getBookName())
                            .author(book.getAuthor())
                            .publicationYear(book.getPublicationYear())
                            .description(book.getDescription())
                            .price(book.getPrice())
                            .build());
                }
            }
        }
        return null;
    }



    @Override
    public SimpleResponse assignBookToLibrary(Long book, Long library) {
        Library library1 = libraryRepo.findById(library).orElseThrow(
                () -> new NullPointerException(String.format("Library with id %d not found", library)));
        Book book1 = bookRepo.findById(book).orElseThrow(
                () -> new NullPointerException(String.format("book with id %d not found", book)));

        book1.setLibrary(library1);
        library1.getBook().add(book1);
        bookRepo.save(book1);
        return SimpleResponse
                .builder()
                .status(HttpStatus.OK)
                .message("Successfully assigned book !")
                .build();
    }
    @Transactional
    @Override
    public GetUpdateLibrary updateLibrary(Long libraryId, UpdateLibarayRequest updateLibarayRequest) {
        Library library = libraryRepo.findById(libraryId).orElseThrow(
                () -> new NullPointerException(String.format("Library with id %d not found", libraryId)));

            library.setName(updateLibarayRequest.name());
            library.setAddress(updateLibarayRequest.address());

        return GetUpdateLibrary
                .builder()
                .status(HttpStatus.OK)
                .message("Successfully updated library !")
                .name(updateLibarayRequest.name())
                .address(updateLibarayRequest.address())
                .build();
    }
}
