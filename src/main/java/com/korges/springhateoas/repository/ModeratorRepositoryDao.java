package com.korges.springhateoas.repository;

import com.korges.springhateoas.pojo.Moderator;
import org.springframework.stereotype.Repository;

import javax.el.PropertyNotFoundException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;


@Repository
public class ModeratorRepositoryDao implements ModeratorRepository {

    private final Set<Moderator> FAKE_DATA = Set.of(
            new Moderator(1L, "Bolec", "Adam", "Kowalski", "adamk@adamk.com", LocalDate.of(1992, 3, 3)),
            new Moderator(2L, "Koles", "Adrian", "Kownacki", "adriank@gmail.com", LocalDate.of(1994, 10, 17)),
            new Moderator(3L, "Dolec", "Antek", "Koterski", "antekk@gmail.com", LocalDate.of(1991, 11, 21))
    );

    @Override
    public Set<Moderator> findAll() {
        return FAKE_DATA.stream()
                .map(this::deepCopy)
                .map(x -> (Moderator) x)
                .collect(Collectors.toSet());
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

    private Long findLastId() {
        return FAKE_DATA.stream()
                .map(Moderator::getId)
                .max(Long::compare)
                .map(x -> x++)
                .orElseGet(() -> 1L);
    }

    private Object deepCopy(Object object) {
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ObjectOutputStream outputStrm = new ObjectOutputStream(outputStream);
            outputStrm.writeObject(object);
            ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
            ObjectInputStream objInputStream = new ObjectInputStream(inputStream);
            return objInputStream.readObject();
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
