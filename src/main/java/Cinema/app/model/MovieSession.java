package Cinema.app.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "movie_session")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieSession {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "Asia/Baku")
    private Date startDate;


    @JoinColumn(name = "movie_id")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Movie movie;


    @JoinColumn(name = "saloon_id")
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Hall hall;

    @JsonIgnore
    @OneToMany(mappedBy = "movieSession", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Seat> seats;

    private Integer price;


}
