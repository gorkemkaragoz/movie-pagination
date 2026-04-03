# 🎬 Movie Pagination API

A hands-on Spring Boot project built to learn and practice pagination with a real movie dataset.

## Tech Stack
- Java 21
- Spring Boot 3.x
- Spring Data JPA
- PostgreSQL
- MapStruct
- Lombok

## What I Learned
- `Pageable` and `PageRequest.of()` usage
- Returning paginated data with `Page<T>`
- Entity → DTO conversion with `page.map()`
- Custom response format with `PagedResponseDto`
- Dynamic sorting with `Sort` and `Sort.Direction`
- Dynamic filtering with JPQL (Filtered Pagination)
- Parameter Object Pattern (`MovieFilterRequest`)

## Endpoints
| Method | URL | Description |
|---|---|---|
| GET | /api/movies | Get all movies with pagination |
| GET | /api/movies/genre | Filter by genre |
| GET | /api/movies/rating | Filter by minimum rating |
| GET | /api/movies/filter | Filter with multiple parameters |
