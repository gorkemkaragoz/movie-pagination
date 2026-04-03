package com.example.movie_pagination.service.serviceImpl;

import com.example.movie_pagination.dto.MovieFilterRequest;
import com.example.movie_pagination.dto.MovieResponseDTO;
import com.example.movie_pagination.dto.PagedResponseDto;
import com.example.movie_pagination.entity.Movie;
import com.example.movie_pagination.mapper.MovieMapper;
import com.example.movie_pagination.repository.MovieRepository;
import com.example.movie_pagination.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;


    @Override
    public PagedResponseDto<MovieResponseDTO> getAllMovies(Pageable pageable) {
        Page<Movie> moviePage = movieRepository.findAll(pageable);
        Page<MovieResponseDTO> dtoPage = moviePage.map(movie -> movieMapper.toResponseDto(movie));
        return PagedResponseDto.from(dtoPage);
    }

    @Override
    public PagedResponseDto<MovieResponseDTO> getByGenre(String genre, Pageable pageable) {
        Page<Movie> moviePage = movieRepository.findByGenre(genre, pageable);
        Page<MovieResponseDTO>  dtoPage = moviePage.map(movie -> movieMapper.toResponseDto(movie));
        return PagedResponseDto.from(dtoPage);
    }

    @Override
    public PagedResponseDto<MovieResponseDTO> getByRatingGreaterThan(Double minRating, Pageable pageable) {
        Page<Movie> moviePage = movieRepository.findByRatingGreaterThan(minRating, pageable);
        Page<MovieResponseDTO> dtoPage = moviePage.map(movie -> movieMapper.toResponseDto(movie));
        return PagedResponseDto.from(dtoPage);
    }

    @Override
    public PagedResponseDto<MovieResponseDTO> getByFilters(MovieFilterRequest filterRequest, Pageable pageable) {
        Page<Movie> moviePage = movieRepository.findByFilters(
                filterRequest.search(),
                filterRequest.genre(),
                filterRequest.minRating(),
                filterRequest.maxRating(),
                filterRequest.minYear(),
                filterRequest.maxYear(),
                pageable
        );
        Page<MovieResponseDTO> dtoPage = moviePage.map(movie -> movieMapper.toResponseDto(movie));
        return PagedResponseDto.from(dtoPage);
    }
}