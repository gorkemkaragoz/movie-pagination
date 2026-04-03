package com.example.movie_pagination.dto;

import jakarta.validation.constraints.*;

public record MovieRequestDTO(

        @NotBlank(message = "Title cannot be blank")
        String title,

        @NotBlank(message = "Genre cannot be blank")
        String genre,

        @NotBlank(message = "Director cannot be blank")
        String director,

        @NotNull(message = "Year cannot be null")
        @Min(value = 1888, message = "Year must be after 1888")
        @Max(value = 2100, message = "Year must be before 2100")
        Integer year,

        @NotNull(message = "Rating cannot be null")
        @DecimalMin(value = "0.0", message = "Rating must be at least 0.0")
        @DecimalMax(value = "10.0", message = "Rating must be at most 10.0")
        Double rating
) {}