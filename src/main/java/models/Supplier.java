package models;

import Enums.SupplierStatus;
import javax.persistence.*;

@Entity
@Table(name = " supplier ")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "phone_number")
    private int phoneNumber;

    @Column(name = "status")
    private SupplierStatus status;
    @ManyToOne(cascade = CascadeType.ALL)
    private Order order;

    public Supplier() {
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

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public SupplierStatus getStatus() {
        return status;
    }

    public void setStatus(SupplierStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", status=" + status +
                '}';
    }
}
