package Cinema.app.service;

import Cinema.app.dto.CreateMovieSessionRequest;
import Cinema.app.dto.MovieSessionDto;
import Cinema.app.dto.converter.MovieSessionDtoConverter;
import Cinema.app.exception.MovieSessionNotFoundException;
import Cinema.app.model.*;
import Cinema.app.repository.MovieSessionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class MovieSessionService {
        private final MovieSessionRepository movieSessionRepository;
        private final MovieSessionDtoConverter converter;
        private final MovieService movieService;
        private final HallService hallService;

        public MovieSessionService(MovieSessionRepository movieSessionRepository, MovieSessionDtoConverter converter, MovieService movieService, HallService hallService) {
            this.movieSessionRepository = movieSessionRepository;
            this.converter = converter;
            this.movieService = movieService;
            this.hallService = hallService;
        }

        public MovieSessionDto createMovieSession(CreateMovieSessionRequest createMovieSessionRequest) {
            Movie movie = movieService.findMovieById(createMovieSessionRequest.getMovieId());
            Hall hall = hallService.findHallById
                    (createMovieSessionRequest.getSaloonId());

            MovieSession movieSession = new MovieSession();
            movieSession.setStartDate(createMovieSessionRequest.getStartDate());
            movieSession.setMovie(movie);
            movieSession.setHall(hall);
            List<Seat> seats = new ArrayList<>();
            for (int i = 0; i < hall.getTotalSeat(); i++) {
                Seat seat = new Seat();
                seat.setMovieSession(movieSession);
                seat.setNumber(i + 1);
                seat.setSeatStatus(SeatStatus.AVAILABLE);

                seats.add(seat);
            }
            movieSession.setSeats(seats);
            movieSession.setPrice(createMovieSessionRequest.getPrice());

            return converter.convert(movieSessionRepository.save(movieSession));
        }

        public List<MovieSessionDto> getAllMovieSessions() {
            return movieSessionRepository.findAll()
                    .stream()
                    .map(converter::convert)
                    .collect(Collectors.toList());
        }

        public MovieSessionDto getMovieSessionById(String movieSessionId) {
            return converter.convert(findMovieSessionById(movieSessionId));
        }

        public MovieSession findMovieSessionById(String id) {
            return movieSessionRepository.findById(id)
                    .orElseThrow(
                            () -> new MovieSessionNotFoundException("Movie Session could not find by id: " + id));
        }

        public void deleteMovieSession(String movieSessionId) {
            findMovieSessionById(movieSessionId);
            movieSessionRepository.deleteById(movieSessionId);
        }
    }

