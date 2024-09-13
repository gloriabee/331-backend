package se331.lab.dao;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import se331.lab.entity.Organizer;

import java.util.ArrayList;
import java.util.List;


@Repository
@Profile("manual")
public class OrganizerDaoImpl implements OrganizerDao{
    List<Organizer> organizerList;

    @PostConstruct
    public void init() {
        organizerList = new ArrayList<>();
        organizerList.add(Organizer.builder()
                .id(100L)
                .orgName("Org 1")
                .address("Chiangmai")
                .build());

        organizerList.add(Organizer.builder()
                .id(101L)
                .orgName("Org 2")
                .address("Bangkok")
                .build());

        organizerList.add(Organizer.builder()
                .id(102L)
                .orgName("Org 3")
                .address("Phuket")
                .build());
    }

    @Override
    public Integer getOrganizerSize() {
        return organizerList.size();
    }

    @Override
    public List<Organizer> getOrganizers(Integer pageSize, Integer page) {
        pageSize=pageSize==null ? organizerList.size():pageSize;
        page=page==null?1:page;
        int firstIndex=(page -1)*pageSize;
        return organizerList.subList(firstIndex,firstIndex+pageSize);

    }

    @Override
    public Organizer getOrganizer(Long id) {
        return organizerList.stream().filter(organizer -> organizer.getId().equals(id)).findFirst().orElse(null);
    }
}
