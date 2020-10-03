package javapoz24.team3.rental.application.config;

// This singleton stores our Rental Id
public class RentalId {
    private static volatile RentalId instance;

    private Long id;

    private RentalId() {    }

    public static RentalId getInstance() {
        if (instance == null) {
            synchronized (RentalId.class) {
                if (instance == null) {
                    instance = new RentalId();
                }
            }
        }
        return instance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

