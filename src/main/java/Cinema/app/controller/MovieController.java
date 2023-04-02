package Cinema.app.controller;

import Cinema.app.dto.CreateMovieRequest;
import Cinema.app.dto.MovieDto;
import Cinema.app.dto.UpdateMovieRequest;
import Cinema.app.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/movie")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public ResponseEntity<MovieDto> createMovie(@RequestBody CreateMovieRequest createMovieRequest){
        return ResponseEntity.ok(movieService.createMovie(createMovieRequest));
    }

    @GetMapping
    public ResponseEntity<List<MovieDto>> getAllMovies(){
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @GetMapping("/{movieId}")
    public ResponseEntity<MovieDto> getMovieById(@PathVariable String movieId){
        return ResponseEntity.ok(movieService.getMovieById(movieId));
    }

    @PutMapping("/{movieId}")
    public ResponseEntity<MovieDto> updateMovie(@PathVariable String movieId,
                                                @RequestBody UpdateMovieRequest updateMovieRequest){

        return ResponseEntity.ok(movieService.updateMovie(movieId, updateMovieRequest));
    }

    @DeleteMapping("/{movieId}")
    public ResponseEntity<Void> deleteMovie(@PathVariable String movieId){
        movieService.deleteMovie(movieId);
        return ResponseEntity.ok().build();
    }
}
