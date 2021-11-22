package vlfl.gymexpert.application.adapters.persistence.personalCard;

import vlfl.gymexpert.application.adapters.persistence.user.UserJpaEntity;

import javax.persistence.*;

@Entity
@Table(name = "personal_card")
public class PersonalCardJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column
    private String expirationDate;

    @Column
    private int attendancesNumber;

    @Column
    private int regularCustomerDiscount;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private UserJpaEntity user;

    public PersonalCardJpaEntity() {}

    public PersonalCardJpaEntity(String expirationDate, int attendancesNumber, int regularCustomerDiscount) {
        this.expirationDate = expirationDate;
        this.attendancesNumber = attendancesNumber;
        this.regularCustomerDiscount = regularCustomerDiscount;
    }

    public Long getId() {
        return id;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public int getAttendancesNumber() {
        return attendancesNumber;
    }

    public int getRegularCustomerDiscount() {
        return regularCustomerDiscount;
    }

    public UserJpaEntity getUser() {
        return user;
    }

    public void setUser(UserJpaEntity user) {
        this.user = user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setAttendancesNumber(int attendancesNumber) {
        this.attendancesNumber = attendancesNumber;
    }

    public void setRegularCustomerDiscount(int regularCustomerDiscount) {
        this.regularCustomerDiscount = regularCustomerDiscount;
    }
}
