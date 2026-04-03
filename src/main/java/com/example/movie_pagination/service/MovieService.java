package com.example.movie_pagination.service;

import com.example.movie_pagination.dto.MovieFilterRequest;
import com.example.movie_pagination.dto.MovieResponseDTO;
import com.example.movie_pagination.dto.PagedResponseDto;
import org.springframework.data.domain.Pageable;

public interface MovieService {

    PagedResponseDto<MovieResponseDTO> getAllMovies(Pageable pageable);

    PagedResponseDto<MovieResponseDTO> getByGenre(String genre, Pageable pageable);

    PagedResponseDto<MovieResponseDTO> getByRatingGreaterThan(Double minRating, Pageable pageable);

    PagedResponseDto<MovieResponseDTO> getByFilters(MovieFilterRequest filterRequest, Pageable pageable);
}