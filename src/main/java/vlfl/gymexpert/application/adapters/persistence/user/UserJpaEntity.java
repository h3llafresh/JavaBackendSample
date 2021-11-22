package vlfl.gymexpert.application.adapters.persistence.user;

import vlfl.gymexpert.application.adapters.persistence.personalCard.PersonalCardJpaEntity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "user")
public class UserJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private Date birthDate;

    @Column
    private Long moneyBalance;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private PersonalCardJpaEntity personalCard;

    public UserJpaEntity() {
    }

    public UserJpaEntity(
        String firstName,
        String lastName,
        String birthDate,
        Long moneyBalance,
        PersonalCardJpaEntity personalCard
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = Date.valueOf(birthDate);
        this.moneyBalance = moneyBalance;
        this.personalCard = personalCard;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Long getMoneyBalance() {
        return moneyBalance;
    }

    public PersonalCardJpaEntity getPersonalCard() {
        return personalCard;
    }
}
