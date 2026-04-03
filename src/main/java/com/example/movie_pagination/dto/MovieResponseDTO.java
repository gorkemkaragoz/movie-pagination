package com.example.movie_pagination.dto;

public record MovieResponseDTO(
        Long id,
        String title,
        String genre,
        String director,
        Integer year,
        Double rating
) {}
