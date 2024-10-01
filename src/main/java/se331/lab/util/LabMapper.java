package se331.lab.util;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import se331.lab.entity.*;

import java.util.List;

@Mapper
public interface LabMapper {
    LabMapper INSTANCE= Mappers.getMapper(LabMapper.class);
    //Event mappings

    EventDTO getEventDto(Event event);
    List<EventDTO> getEventDto(List<Event> events);

    //Organizer mappings
    OrganizerDTO getOrganizerDTO(Organizer organizer);
    List<OrganizerDTO> getOrganizerDTO(List<Organizer> organizers);

    //Participant mappings
    ParticipantDTO getParticipantDTO(Participant participant);
    List<ParticipantDTO> getParticipantDTO(List<Participant> participants);

}
