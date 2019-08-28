package ua.krasun.conference_portal.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ua.krasun.conference_portal.entity.Conference;
import ua.krasun.conference_portal.entity.User;
import ua.krasun.conference_portal.entity.dto.ConferenceDto;

import java.util.List;

public interface ConferenceRepository extends CrudRepository<Conference, Long> {

    @Query("select new ua.krasun.conference_portal.entity.dto.ConferenceDto(" +
            "   c, " +
            "   count(cl), " +
            "   sum(case when cl = :user then 1 else 0 end) > 0" +
            ") " +
            "from Conference c left join c.registrations cl " +
            "group by c")
    List<ConferenceDto> findAll(@Param("user") User user);

    @Query("select new ua.krasun.conference_portal.entity.dto.ConferenceDto(" +
            "   c, " +
            "   count(cl), " +
            "   sum(case when cl = :user then 1 else 0 end) > 0" +
            ") " +
            "from Conference c left join c.registrations cl " +
            "where c.author = :author " +
            "group by c")
    List<ConferenceDto> findByUser(@Param("author") User author, @Param("user") User user);

}
