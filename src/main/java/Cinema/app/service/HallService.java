package Cinema.app.service;


import Cinema.app.dto.CreateHallRequest;
import Cinema.app.dto.HallDto;
import Cinema.app.dto.UpdateHallRequest;
import Cinema.app.dto.converter.HallDtoConverter;
import Cinema.app.exception.HallNotFoundException;
import Cinema.app.model.Hall;
import Cinema.app.repository.HallRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HallService {

    private final HallRepository hallRepository;
    private final HallDtoConverter converter;

    public HallDto createHall (CreateHallRequest createSaloonRequest){
        Hall hall = new Hall();
        hall.setName(createSaloonRequest.getName());
        hall.setTotalSeat(createSaloonRequest.getTotalSeat());

        return converter.convert(hallRepository.save(hall));
    }

    public List<HallDto> getAllHall() {
        return hallRepository.findAll()
                .stream()
                .map(converter :: convert)
                .collect(Collectors.toList());
    }


    public HallDto getHallById(String saloonId) {
        return converter.convert(findHallById(saloonId));
    }

    protected Hall findHallById(String id) {
        return hallRepository.findById(id)
                .orElseThrow(
                        () -> new HallNotFoundException("Saloon could not find by id: " + id));

    }
    public HallDto updateHall(String hallId, UpdateHallRequest updateHallRequest) {
        Hall hall = findHallById(hallId);


        hall.setName(updateHallRequest.getName());
        hall.setTotalSeat(updateHallRequest.getTotalSeat());

        return converter.convert(hallRepository.save(hall));
    }

    public void deleteHall(String hallId) {
        findHallById(hallId);
        hallRepository.deleteById(hallId);
    }
}
