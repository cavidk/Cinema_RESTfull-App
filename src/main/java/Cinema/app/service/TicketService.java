package Cinema.app.service;

import Cinema.app.dto.ReserveTicketRequest;
import Cinema.app.dto.TicketDto;
import Cinema.app.dto.converter.TicketDtoConverter;
import Cinema.app.exception.TickedReservedException;
import Cinema.app.model.*;
import Cinema.app.repository.TicketRepository;
import Cinema.app.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    private final MovieSessionService movieSessionService;
    private final UserRepository userRepository;
    private final TicketRepository ticketRepository;
    private final TicketDtoConverter converter;

    public TicketService(MovieSessionService movieSessionService, UserRepository userRepository, TicketRepository ticketRepository, TicketDtoConverter converter) {
        this.movieSessionService = movieSessionService;
        this.userRepository = userRepository;
        this.ticketRepository = ticketRepository;
        this.converter = converter;
    }

    public TicketDto rezerveTicket(ReserveTicketRequest rezerveTicketRequest){
        MovieSession movieSession = movieSessionService.findMovieSessionById(rezerveTicketRequest.getMovieSessionId());
        List<Seat> seatList = movieSession.getSeats();
        Seat seat = seatList.get(rezerveTicketRequest.getSeatNumber()-1);
        if(seat.getSeatStatus() == SeatStatus.AVAILABLE){
            seat.setSeatStatus(SeatStatus.REZERVED);
            seatList.set(rezerveTicketRequest.getSeatNumber()-1, seat);
            movieSession.setSeats(seatList);
            User user = userRepository.findById(rezerveTicketRequest.getUserId()).orElseThrow();
            Ticket ticket = new Ticket();
            ticket.setSeat(seat);
            ticket.setUser(user);
            ticket.setMovieSession(movieSession);

            return converter.convert(ticketRepository.save(ticket));
        }else{
            throw new TickedReservedException("Ticked Reserved!!");// düzenlenecek
        }

    }
}
