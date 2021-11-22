package vlfl.gymexpert.application.domain;

public class PersonalCard {
    Long ID;
    String expirationDate;
    int attendancesNumber;
    int regularCustomerDiscount;

    private PersonalCard(
        Long ID,
        String expirationDate,
        int attendancesNumber,
        int regularCustomerDiscount
    ) {
        this.ID = ID;
        this.expirationDate = expirationDate;
        this.attendancesNumber = attendancesNumber;
        this.regularCustomerDiscount = regularCustomerDiscount;
    }

    public Long getID() {
        return ID;
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

    public static PersonalCardBuilder builder() {
        return new PersonalCardBuilder();
    }

    public static class PersonalCardBuilder {
        Long ID;
        String expirationDate;
        int attendancesNumber;
        int regularCustomerDiscount;

        PersonalCardBuilder() {}

        public PersonalCardBuilder id(Long ID) {
            this.ID = ID;
            return this;
        }

        public PersonalCardBuilder expirationDate(String expirationDate) {
            this.expirationDate = expirationDate;
            return this;
        }

        public PersonalCardBuilder attendancesNumber(int attendancesNumber) {
            this.attendancesNumber = attendancesNumber;
            return this;
        }

        public PersonalCardBuilder regularCustomerDiscount(int regularCustomerDiscount) {
            this.regularCustomerDiscount = regularCustomerDiscount;
            return this;
        }

        public PersonalCard build() {
            return new PersonalCard(
                this.ID,
                this.expirationDate,
                this.attendancesNumber,
                this.regularCustomerDiscount
            );
        }
    }
}
