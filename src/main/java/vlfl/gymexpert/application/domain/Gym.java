package vlfl.gymexpert.application.domain;

public class Gym {
    private final Long ID;
    private final String address;
    private final String phoneNumber;
    private final String workingHours;

    private Gym(
        Long ID,
        String address,
        String phoneNumber,
        String workingHours
    ) {
        this.ID = ID;
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

    public static GymBuilder builder() {
        return new GymBuilder();
    }

    public static class GymBuilder {
        private Long ID;
        private String address;
        private String phoneNumber;
        private String workingHours;

        GymBuilder() {}

        public GymBuilder id(Long ID) {
            this.ID = ID;
            return this;
        }

        public GymBuilder address(String address) {
            this.address = address;
            return this;
        }

        public GymBuilder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public GymBuilder workingHours(String workingHours) {
            this.workingHours = workingHours;
            return this;
        }

        public Gym build() {
            return new Gym(
                ID,
                address,
                phoneNumber,
                workingHours
            );
        }
    }
}
