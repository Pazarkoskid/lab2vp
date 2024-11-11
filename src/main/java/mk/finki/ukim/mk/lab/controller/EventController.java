package  mk.finki.ukim.mk.lab.controller;

import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.Location;
import mk.finki.ukim.mk.lab.service.EventService;
import mk.finki.ukim.mk.lab.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/events")
public class EventController {
    private final EventService eventService;
    private final LocationService locationService;

    @Autowired
    public EventController(EventService eventService, LocationService locationService) {
        this.eventService = eventService;
        this.locationService = locationService;
    }

    // Прикажување на страницата со сите настани
    @GetMapping
    public String getEventsPage(@RequestParam(required = false) String error, Model model) {
        List<Event> events = eventService.listAll(); // Извлечи ги сите настани
        model.addAttribute("events", events); // Додај ги настаните во моделот
        model.addAttribute("error", error); // Ако има грешка, додај ја грешката во моделот
        return "listEvents"; // Врати го погледот за листа на настани (listEvents.html)
    }

    // Додавање на нов настан
    @PostMapping("/add")
    public String saveEvent(@RequestParam String name,
                            @RequestParam String description,
                            @RequestParam double popularityScore,
                            @RequestParam Location locationId) {
        // Спаси нов настан со зададени податоци
        eventService.save(name, description, popularityScore,locationId);
        return "redirect:/events"; // Редиректирај кон листата на настани по успешно додавање
    }

    // Прикажување на форма за уредување на настан
    @GetMapping("/edit/{eventId}")
    public String editEvent(@PathVariable Long eventId, Model model) {
        Event event = eventService.findById(eventId); // Извлечи го настанот по ID
        model.addAttribute("event", event); // Додај го настанот во моделот
        model.addAttribute("locations", locationService.findAll()); // Додај ги сите локации во моделот
        return "editEvent"; // Врати го погледот за уредување (editEvent.html)
    }

    // Ажурирање на постоечки настан
    @PostMapping("/edit/{eventId}")
    public String updateEvent(@PathVariable Long eventId,
                              @RequestParam String name,
                              @RequestParam String description,
                              @RequestParam double popularityScore,
                              @RequestParam Location locationId) {
        eventService.update(eventId, name, description, popularityScore, locationId); // Ажурирај го настанот
        return "redirect:/events"; // Редиректирај кон листата на настани по успешно ажурирање
    }

    // Бришење на настан
    @GetMapping("/delete/{eventId}")
    public String deleteEvent(@PathVariable Long eventId) {
        eventService.delete(eventId); // Избриши го настанот
        return "redirect:/events"; // Редиректирај кон листата на настани по успешно бришење
    }
    @GetMapping("/edit-form/{id}")
    public String getEditEventForm(@PathVariable Long id, Model model) {
        // Пробај да го најдеш настанот по ID
        Event event = eventService.findById(id);

        // Ако настанот не постои, редиректирај на страницата со настани и прикажи грешка
        if (event == null) {
            model.addAttribute("error", "Event not found");
            return "redirect:/events"; // Редиректирај кон листата на настани
        }

        // Додај го настанот и локациите во моделот за да ги прикажеш во формата
        model.addAttribute("event", event);
        model.addAttribute("locations", locationService.findAll());
        return "add-event"; // Врати ја страната за додавање/уредување на настан
    }
    @GetMapping("/add-form")
    public String getAddEventPage(Model model) {
        model.addAttribute("event", new Event()); // Иницијализирај нов празен настан
        model.addAttribute("locations", locationService.findAll()); // Додај ги сите локации
        return "add-event"; // Врати ја страната за додавање нов настан
    }
}