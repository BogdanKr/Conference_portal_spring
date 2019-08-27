package ua.krasun.conference_portal.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Presentation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String theme;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "conference_id")
    private Conference conference;

    public Presentation(String theme, User author, Conference conference) {
        this.theme = theme;
        this.author = author;
        this.conference = conference;
    }
}
