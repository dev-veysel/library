package com.library.domain;

import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "_books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    @Setter(AccessLevel.NONE)
    private Integer id;

    @NotNull(message = "Please enter the isbn of the book")
    @Column(length = 40, nullable = false)
    private String isbn;

    @NotNull(message = "Please enter the title of the book")
    @Column(length = 40, nullable = false)
    private String title;

    @NotNull(message = "Please enter the author of the book")
    @Column(length = 40, nullable = false)
    private String author;

    @Column(length = 40, nullable = false)
    @NotNull(message = "Please enter the publisher of the book")
    private String publisher;

    @Column(length = 40, nullable = false)
    @NotNull(message = "Please enter the year of publication of the book")
    private String yearOfPublication;
}