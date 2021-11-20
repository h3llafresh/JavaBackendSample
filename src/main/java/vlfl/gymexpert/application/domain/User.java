package vlfl.gymexpert.application.domain;

import java.util.Date;

public class User {

    private final Long ID;
    private final String firstName;
    private final String lastName;
    private final String birthDate;
    private final Long moneyBalance;
    private final Long personalCardID;

    private User(
        Long ID,
        String firstName,
        String lastName,
        String birthDate,
        Long moneyBalance,
        Long privateCardID
    ) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.moneyBalance = moneyBalance;
        this.personalCardID = privateCardID;
    }

    public Long getID() {
        return ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public Long getMoneyBalance() {
        return moneyBalance;
    }

    public Long getPersonalCardID() {
        return personalCardID;
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public static class UserBuilder {
        Long ID;
        String firstName;
        String lastName;
        String birthDate;
        Long moneyBalance;
        Long personalCardID;

        UserBuilder() {

        }

        public UserBuilder id(Long ID) {
            this.ID = ID;
            return this;
        }

        public UserBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserBuilder birthDate(Date birthDate) {
            this.birthDate = birthDate.toString();
            return this;
        }

        public UserBuilder moneyBalance(Long moneyBalance) {
            this.moneyBalance = moneyBalance;
            return this;
        }

        public UserBuilder personalCardID(Long personalCardID) {
            this.personalCardID = personalCardID;
            return this;
        }

        public User build() {
            return new User(
                ID,
                firstName,
                lastName,
                birthDate,
                moneyBalance,
                personalCardID
            );
        }
    }
}
