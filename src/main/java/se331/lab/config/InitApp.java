package se331.lab.config;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import se331.lab.entity.Event;
import se331.lab.entity.Organizer;
import se331.lab.entity.Participant;
import se331.lab.repository.EventRepository;
import se331.lab.repository.OrganizerRepository;
import se331.lab.repository.ParticipantRepository;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    final EventRepository eventRepository;
    final OrganizerRepository organizerRepository;
    final ParticipantRepository participantRepository;
    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        Organizer org1,org2,org3;
        org1=organizerRepository.save(Organizer.builder()
                .name("CAMT").build());
        org2=organizerRepository.save(Organizer.builder()
                .name("CMU").build());
        org3=organizerRepository.save(Organizer.builder()
                .name("Chiangmai").build());

        Event tempEvent;
        tempEvent=eventRepository.save(Event.builder()
                .category("Academic")
                .title("Midterm Exam")
                .description("A time for taking the exam")
                .location("CAMT Building")
                .date("3rd Sept")
                .time("3.00-4.00 pm.")
                .petAllowed(false)
                .build());
        tempEvent.setOrganizer(org1);
        org1.getOwnEvents().add(tempEvent);
        tempEvent=eventRepository.save(Event.builder()
                .category("Academic")
                .title("Commencement Day")
                .description("A time for celebration")
                .location("CMU Convention hall")
                .date("21th Jan")
                .time("8.00am-4.00pm.")
                .petAllowed(false)
                .build());
        tempEvent.setOrganizer(org2);
        org2.getOwnEvents().add(tempEvent);
        tempEvent=eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Loy Krathong")
                .description("A time for Krathong")
                .location("Ping River")
                .date("21th Nov")
                .time("8.00am-10.00pm.")
                .petAllowed(false)
                .build());
        tempEvent.setOrganizer(org3);
        org3.getOwnEvents().add(tempEvent);


        //create participants

        Participant p1=participantRepository.save(Participant.builder().name("Alice").build());
        Participant p2=participantRepository.save(Participant.builder().name("Gloria").build());
        Participant p3=participantRepository.save(Participant.builder().name("Rubi").build());
        Participant p4=participantRepository.save(Participant.builder().name("Ruth").build());
        Participant p5=participantRepository.save(Participant.builder().name("Emerald").build());

        tempEvent.setParticipants(Arrays.asList(p1,p2,p3));
        eventRepository.save(tempEvent);

    }

}
