package se331.lab.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import se331.lab.entity.Organizer;
import se331.lab.repository.OrganizerRepository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Profile("db")

public class OrganizerDaoDbImpl implements OrganizerDao {
    final OrganizerRepository organizerRepository;
    @Override
    public Integer getOrganizerSize() {
        return Math.toIntExact(organizerRepository.count());
    }

    @Override
    public List<Organizer> getOrganizers(Integer pageSize, Integer page) {
        List<Organizer> organizers = organizerRepository.findAll();
        pageSize= pageSize == null?organizers.size():pageSize;
        page= page == null?1:page;
        int firstIndex= (page-1)*pageSize;
        List<Organizer> output=organizers.subList(firstIndex,firstIndex+pageSize);
        return output;
    }

    @Override
    public Organizer getOrganizer(Long id) {
        return organizerRepository.findById(id).orElse(null);
    }
}
