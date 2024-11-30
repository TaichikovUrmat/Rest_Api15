package peaksoft.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SaveLibraryRequest {

    private String name;
    private String address;
}
