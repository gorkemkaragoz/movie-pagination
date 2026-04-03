package com.example.movie_pagination.repository;

import com.example.movie_pagination.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("SELECT m FROM Movie m WHERE m.genre = :genre")
    Page<Movie> findByGenre(@Param("genre") String genre, Pageable pageable);

    Page<Movie> findByRatingGreaterThan(Double minRating, Pageable pageable);

    @Query("SELECT m FROM Movie m WHERE " +
            "(:search IS NULL OR LOWER(m.title) LIKE LOWER(CONCAT('%', CAST(:search AS string), '%'))) AND " +
            "(:genre IS NULL OR m.genre = :genre) AND " +
            "(:minRating IS NULL OR m.rating >= :minRating) AND " +
            "(:maxRating IS NULL OR m.rating <= :maxRating) AND " +
            "(:minYear IS NULL OR m.year >= :minYear) AND " +
            "(:maxYear IS NULL OR m.year <= :maxYear)")
    Page<Movie> findByFilters(
            @Param("search") String search,
            @Param("genre") String genre,
            @Param("minRating") Double minRating,
            @Param("maxRating") Double maxRating,
            @Param("minYear") Integer minYear,
            @Param("maxYear") Integer maxYear,
            Pageable pageable);
}