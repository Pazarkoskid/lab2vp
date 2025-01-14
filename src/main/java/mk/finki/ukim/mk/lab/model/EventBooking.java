package mk.finki.ukim.mk.lab.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class EventBooking {
    String eventName;
    String attendeeName;
    String attendeeAddress;
    long numberOfTickets;

    public EventBooking(String eventName, String attendeeName, String attendeeAddress, long numberOfTickets) {
        this.eventName = eventName;
        this.attendeeName = attendeeName;
        this.attendeeAddress = attendeeAddress;
        this.numberOfTickets = numberOfTickets;
    }
}
