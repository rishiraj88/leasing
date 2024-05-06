package rrlane.leasing.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;
import rrlane.leasing.contract.dto.CustomerDTO;
import rrlane.leasing.contract.entity.LeasingContract;
import rrlane.leasing.util.Mapper;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customer")
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
public class Customer {
    @Id
    @Column(name = "id")
    @UuidGenerator
    private String customerId;
    @Column(name = "name")
    private String name; //prop: source of truth is here
    @Temporal(TemporalType.DATE)
    @Column(name = "bdate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private LocalDate birthDate; //prop: source of truth is here
    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    private Set<LeasingContract> leasingContracts = new HashSet<>(); // one-to-many

    @Override
    public String toString() {
        return "Customer{" + ", name='" + name + '\'' + ", birthDate='" + birthDate + '\'' + '}';
    }

    public CustomerDTO getDto() {
        return Mapper.entityToDto(this);
    }
}
