package allane.leasing.contract.entity;

import allane.leasing.contract.entity.dto.CustomerDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customer")
@NoArgsConstructor
public class Customer {
    @Id
    @Column(name = "customer_id")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String customerId;
    @Column(name = "fname")
    private String firstName;
    @Column(name = "lname")
    private String lastName;
    @Temporal(TemporalType.DATE)
    @Column(name = "bdate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private Date birthDate;

    @OneToMany(mappedBy = "customer"
    )
@JsonIgnore
    private Set<LeasingContract> leasingContracts = new HashSet<>();

    public String getId() {
        return customerId;
    }

    public void setId(String id) {
        this.customerId = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getName() {
        return firstName + " " + lastName;
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

    public Set<LeasingContract> getLeasingContracts() {
        return leasingContracts;
    }

    public void setLeasingContracts(Set<LeasingContract> leasingContracts) {
        this.leasingContracts = leasingContracts;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                '}';
    }

    public CustomerDTO getDto() {
        return new CustomerDTO(this.firstName,this.lastName,birthDate.toString());
    }
}
