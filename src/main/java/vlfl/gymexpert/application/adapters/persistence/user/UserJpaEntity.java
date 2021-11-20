package vlfl.gymexpert.application.adapters.persistence.user;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
public class UserJpaEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private Date birthDate;

    @Column
    private Long moneyBalance;

    @Column
    private Long personalCardId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Long getMoneyBalance() {
        return moneyBalance;
    }

    public void setMoneyBalance(Long moneyBalance) {
        this.moneyBalance = moneyBalance;
    }

    public Long getPersonalCardId() {
        return personalCardId;
    }

    public void setPersonalCardId(Long personalCardId) {
        this.personalCardId = personalCardId;
    }
}
