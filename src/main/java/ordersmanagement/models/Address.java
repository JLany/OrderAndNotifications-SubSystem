package ordersmanagement.models;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    private String city;
    private String district;
    private String street;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return  city + '-' +
                district + '-' +
                street + '.';
    }



}
