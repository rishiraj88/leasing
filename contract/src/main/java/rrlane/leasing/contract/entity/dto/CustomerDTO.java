package rrlane.leasing.contract.entity.dto;
public class CustomerDTO {
    private String name;
    private String birthDate;

    public String getName() {
        return name;
    }

    public void setFirstName(String name) {
        this.name = name;
    }



    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "Name='" + name + '\'' +
                ", birthDate='" + birthDate + '\'' +
                '}';
    }

    public CustomerDTO(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }
}
