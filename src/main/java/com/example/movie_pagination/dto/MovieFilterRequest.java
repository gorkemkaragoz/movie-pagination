package com.example.movie_pagination.dto;

public record MovieFilterRequest(
        String search,
        String genre,
        Double minRating,
        Double maxRating,
        Integer minYear,
        Integer maxYear
) {}