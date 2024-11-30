package peaksoft.service;

import peaksoft.dto.request.SaveLibraryRequest;
import peaksoft.dto.request.UpdateLibarayRequest;
import peaksoft.dto.respons.GetAllLibraryResponse;
import peaksoft.dto.respons.GetUpdateLibrary;
import peaksoft.dto.respons.SimpleResponse;

import java.util.List;

public interface LibraryService {

    SimpleResponse saveLibrary(SaveLibraryRequest saveLibraryRequest);

    List<GetAllLibraryResponse> findAll();

    SimpleResponse assignBookToLibrary(Long book, Long library);

    GetUpdateLibrary updateLibrary(Long libraryId, UpdateLibarayRequest updateLibarayRequest);


    // findById

    // delete

    // update

    // sord asc and desk

    //
//    void findByLibraryName(String Library);



}
