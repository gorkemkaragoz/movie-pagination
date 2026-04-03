package com.example.movie_pagination.controller;

import com.example.movie_pagination.dto.MovieFilterRequest;
import com.example.movie_pagination.dto.MovieResponseDTO;
import com.example.movie_pagination.dto.PagedResponseDto;
import com.example.movie_pagination.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/movies")
@RestController
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    public ResponseEntity<PagedResponseDto<MovieResponseDTO>> findAllMovies(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortType,
            @RequestParam(defaultValue = "ASC") Sort.Direction direction) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortType));
        return ResponseEntity.ok(movieService.getAllMovies(pageable));
    }

    @GetMapping("/genre")
    public ResponseEntity<PagedResponseDto<MovieResponseDTO>> findAllGenreMovies(
            @RequestParam String genre,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortType,
            @RequestParam(defaultValue = "ASC") Sort.Direction direction) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortType));
        return ResponseEntity.ok(movieService.getByGenre(genre, pageable));
    }

    @GetMapping("/rating")
    public ResponseEntity<PagedResponseDto<MovieResponseDTO>> findByRatingGreaterThan(
            @RequestParam Double minRating,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortType,
            @RequestParam(defaultValue = "DESC") Sort.Direction direction) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortType));
        return ResponseEntity.ok(movieService.getByRatingGreaterThan(minRating, pageable));
    }

    @GetMapping("/filter")
    public ResponseEntity<PagedResponseDto<MovieResponseDTO>> filterMovies(
            MovieFilterRequest filterRequest,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortType,
            @RequestParam(defaultValue = "ASC") Sort.Direction direction) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortType));
        return ResponseEntity.ok(movieService.getByFilters(filterRequest, pageable));
    }
}