package com.library.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookDTO {

    private Integer id;

    private String isbn;

    private String title;

    private String author;

    private String publisher;

    private String yearOfPublication;
}