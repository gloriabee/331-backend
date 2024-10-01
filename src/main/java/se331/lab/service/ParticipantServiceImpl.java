package se331.lab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se331.lab.entity.Participant;
import se331.lab.repository.ParticipantRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParticipantServiceImpl implements ParticipantService{
    final ParticipantRepository participantRepository;

    @Override
    public List<Participant> getAllParticipants() {
        return participantRepository.findAll();
    }
}
