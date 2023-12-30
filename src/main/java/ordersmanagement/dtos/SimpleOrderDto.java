package ordersmanagement.dtos;

import ordersmanagement.models.Address;

import java.util.List;

public class SimpleOrderDto {
    private Long customerId;
    private List<OrderEntryDto> entries;
    private Address address;

    public SimpleOrderDto() {
    }

    public SimpleOrderDto(Long customerId, List<OrderEntryDto> entries, Address address) {
        this.customerId = customerId;
        this.entries = entries;
        this.address = address;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public List<OrderEntryDto> getEntries() {
        return entries;
    }

    public void setEntries(List<OrderEntryDto> entries) {
        this.entries = entries;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
