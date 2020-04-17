package com.korges.springhateoas.repository;

import com.korges.springhateoas.entity.Moderator;
import org.springframework.stereotype.Repository;

import javax.el.PropertyNotFoundException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;


@Repository
public class ModeratorRepositoryDao implements ModeratorRepository {

    private final Set<Moderator> FAKE_DATA = new LinkedHashSet<>(Arrays.asList(
            new Moderator(1L, "Bolec", "Adam", "Kowalski", "adamk@adamk.com", LocalDate.of(1992, 3, 3)),
            new Moderator(2L, "Koles", "Adrian", "Kownacki", "adriank@gmail.com", LocalDate.of(1994, 10, 17)),
            new Moderator(3L, "Dolec", "Antek", "Koterski", "antekk@gmail.com", LocalDate.of(1991, 11, 21))
    ));

    @Override
    public Set<Moderator> findAll() {
        return FAKE_DATA;
    }

    @Override
    public Moderator findById(Long id) {
        return FAKE_DATA.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElseThrow(PropertyNotFoundException::new);
    }

    @Override
    public Moderator save(Moderator moderator) {
        moderator.setId(findLastId());
        FAKE_DATA.add(moderator);

        return moderator;
    }

    @Override
    public void deleteById(long id) {
        FAKE_DATA.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .map(FAKE_DATA::remove)
                .orElseThrow(PropertyNotFoundException::new);
    }

    private Long findLastId() {
        return FAKE_DATA.stream()
                .map(Moderator::getId)
                .max(Long::compare)
                .map(x -> x++)
                .orElseGet(() -> 1L);
    }
}
