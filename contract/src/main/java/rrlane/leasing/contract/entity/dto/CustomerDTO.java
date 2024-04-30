package rrlane.leasing.contract.entity.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
@RequiredArgsConstructor
@Data
public class CustomerDTO {
    private String name;
    private LocalDateTime birthDate;

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "Name='" + name + '\'' +
                ", birthDate='" + birthDate + '\'' +
                '}';
    }


}
