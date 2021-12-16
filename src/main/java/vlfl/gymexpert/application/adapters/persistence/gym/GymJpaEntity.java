package vlfl.gymexpert.application.adapters.persistence.gym;

import javax.persistence.*;

@Entity
@Table(name = "gym")
public class GymJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long ID;

    @Column
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "working_hours")
    private String workingHours;

    public GymJpaEntity() {}

    public GymJpaEntity(
        String address,
        String phoneNumber,
        String workingHours
    ) {
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.workingHours = workingHours;
    }

    public Long getID() {
        return ID;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getWorkingHours() {
        return workingHours;
    }

}
