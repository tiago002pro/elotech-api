package com.biblioteca.elotech_api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class BookDTO {
    private String id;
    private String title;
    private String author;
    private String isbn;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date publicationDate;
    private String category;
    private String imgLink;


    public BookDTO(Map<String, Object> stringObjectMap) {
        this.id = (String) stringObjectMap.get("id");

        Map<String, Object> volumeInfo = (Map<String, Object>) stringObjectMap.get("volumeInfo");

        if (Objects.nonNull(volumeInfo.get("title"))) {
            this.title = (String) volumeInfo.get("title");
        }

        if (Objects.nonNull(volumeInfo.get("authors"))) {
            List<String> authors = (List<String>) volumeInfo.get("authors");
            if (!authors.isEmpty()) {
                this.author = String.join(", ", authors);
            }
        }

        if (Objects.nonNull(volumeInfo.get("industryIdentifiers"))) {
            List<Map<String, String>> industryIdentifiers = (List<Map<String, String>>) volumeInfo.get("industryIdentifiers");
            List<String> isbnList = industryIdentifiers.stream().map(item->item.get("identifier").toString()).collect(Collectors.toList());
            if (!isbnList.isEmpty()) {
                this.isbn = String.join(", ", isbnList);
            }
        }

        if (Objects.nonNull(volumeInfo.get("publishedDate"))) {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

            try {
                String dateString = (String) volumeInfo.get("publishedDate");
                dateString = dateString.length() == 4 ? (dateString + "-01-01") : dateString;
                this.publicationDate = formato.parse(dateString);
            } catch (ParseException e) {
                System.out.println("Formato de data inválido: " + e.getMessage());
            }
        }

        if (Objects.nonNull(volumeInfo.get("categories"))) {
            List<String> authors = (List<String>) volumeInfo.get("categories");
            if (!authors.isEmpty()) {
                this.category = String.join(", ", authors);
            }
        }

        if (Objects.nonNull(volumeInfo.get("imageLinks"))) {
            Map<String, Object> images = (Map<String, Object>) volumeInfo.get("imageLinks");
            if (Objects.nonNull(images.get("smallThumbnail"))) {
                this.imgLink = (String) images.get("smallThumbnail");
            } else if (Objects.nonNull(images.get("thumbnail"))) {
                this.imgLink = (String) images.get("thumbnail");
            }
        }
    }
}
