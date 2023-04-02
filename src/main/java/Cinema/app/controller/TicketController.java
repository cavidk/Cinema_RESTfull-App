package Cinema.app.controller;

import Cinema.app.dto.ReserveTicketRequest;
import Cinema.app.dto.TicketDto;
import Cinema.app.service.TicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/ticket")
public class TicketController {

    private  final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping(path = "/rezerve-ticket")
    public ResponseEntity<TicketDto> rezerveTicket(@RequestBody ReserveTicketRequest reserveTicketRequest) {
        return ResponseEntity.ok(ticketService.rezerveTicket(reserveTicketRequest));
    }
}
