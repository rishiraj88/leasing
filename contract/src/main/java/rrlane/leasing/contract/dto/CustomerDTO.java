package rrlane.leasing.contract.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@RequiredArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class CustomerDTO {
    private String name;
    private LocalDate birthDate;

    @Override
    public String toString() {
        return "CustomerDTO{" + "Name='" + name + '\'' + ", birthDate='" + birthDate + '\'' + '}';
    }
}
