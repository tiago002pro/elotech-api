package com.biblioteca.elotech_api.repository;

import com.biblioteca.elotech_api.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query(nativeQuery = true,
            value = " SELECT * FROM book b " +
                    " WHERE NOT exists ( " +
                    "   SELECT 1 FROM loan l WHERE l.book_id = b.id AND l.status = 'OPEN' " +
                    " )")
    List<Book> getAllBooksAvailable();

    @Query(nativeQuery = true,
            value = " SELECT count(*) > 0 FROM book b " +
                    " WHERE NOT exists ( " +
                    "   SELECT 1 FROM loan l WHERE l.book_id = b.id AND l.status = 'OPEN' " +
                    " )" +
                    "   AND b.id = :id ")
    Boolean checkIfTheBookIsAvailable(@Param("id") Long id);

    @Query(nativeQuery = true,
            value = " WITH categories AS ( " +
                    "    SELECT " +
                    "       b.id AS book_id, " +
                    "       b.category " +
                    "    FROM users u " +
                    "       INNER JOIN loan l ON l.user_id = u.id " +
                    "       INNER JOIN book b ON b.id = l.book_id " +
                    "    WHERE u.id = :userId " +
                    " )" +
                    " SELECT bb.* FROM book bb " +
                    "    LEFT JOIN categories c ON c.book_id = bb.id " +
                    " WHERE NOT exists (SELECT 1 FROM book bbb WHERE bbb.id = c.book_id) " +
                    "    AND bb.category IN ( " +
                    "                          SELECT bbb.category " +
                    "                          FROM book bbb " +
                    "                              INNER JOIN categories cc on cc.category = bbb.category " +
                    "                       )")
    List<Book> getRecommendationBooks(@Param("userId") Long userId);
}
