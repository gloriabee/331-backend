package se331.lab.entity;

import java.util.List;

public class ParticipantOwnEventsDTO {
    Long id;
    String category;
    String title;
    String description;
    String location;
    String date;
    String time;
    Boolean petAllowed;
    List<Participant> participants;
}
