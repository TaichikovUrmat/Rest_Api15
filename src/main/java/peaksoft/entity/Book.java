package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Long id;
    String bookName;
    String author;
    LocalDate publicationYear;      /// Год издания
    String description;             ///  Описание:
    int price;

    @ManyToOne(cascade = CascadeType.ALL)
     Library library;


}
