package rrlane.leasing.contract.dto;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
@RequiredArgsConstructor
@Data @Builder
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
