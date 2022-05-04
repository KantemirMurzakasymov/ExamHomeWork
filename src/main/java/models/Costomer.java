package models;

import javax.persistence.*;

@Entity
@Table(name = " costomer ")
public class Costomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "phone_number")
    private long phoneNumber;

    @OneToOne(mappedBy = "Adress")
    private Adress adress;
    @ManyToOne(cascade = CascadeType.ALL)
    private Order order;

    public Costomer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Costomer{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
