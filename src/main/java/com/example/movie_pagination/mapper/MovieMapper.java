package com.example.movie_pagination.mapper;

import com.example.movie_pagination.dto.MovieRequestDTO;
import com.example.movie_pagination.dto.MovieResponseDTO;
import com.example.movie_pagination.entity.Movie;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    MovieResponseDTO toResponseDto(Movie movie);
    List<MovieResponseDTO> toResponseDtoList(List<Movie> movies);
}
