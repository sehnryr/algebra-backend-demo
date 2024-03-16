package hr.algreba.pi.hardwareapp.dto;

import hr.algreba.pi.hardwareapp.domain.Hardware;

import java.math.BigDecimal;

public class HardwareDTO {
    private final String name;
    private final BigDecimal price;
    private final String code;
    private final Long id;

    public HardwareDTO(Hardware hardware) {
        this.name = hardware.getName();
        this.price = hardware.getPrice();
        this.code = hardware.getCode();
        this.id = hardware.getId();
    }

    public HardwareDTO(String code, Hardware hardware) {
        this.name = hardware.getName();
        this.price = hardware.getPrice();
        this.code = code;
        this.id = hardware.getId();
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getCode() {
        return code;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "HardwareDTO{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", code='" + code + '\'' +
                '}';
    }
}
