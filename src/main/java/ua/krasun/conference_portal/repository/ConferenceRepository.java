package ua.krasun.conference_portal.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
            "   count(cr), " +
            "   sum(case when cr = :user then 1 else 0 end) > 0" +
            ") " +
            "from Conference c left join c.registrations cr " +
            "group by c")
    Page<ConferenceDto> findAll(@Param("user") User user, Pageable pageable);

    @Query("select new ua.krasun.conference_portal.entity.dto.ConferenceDto(" +
            "   c, " +
            "   count(cr), " +
            "   sum(case when cr = :user then 1 else 0 end) > 0" +
            ") " +
            "from Conference c left join c.registrations cr " +
            "where c.author = :author " +
            "group by c")
    List<ConferenceDto> findByUser(@Param("author") User author, @Param("user") User user);


}
