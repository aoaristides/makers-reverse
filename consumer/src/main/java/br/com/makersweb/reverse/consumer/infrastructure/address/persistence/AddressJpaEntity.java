package br.com.makersweb.reverse.consumer.infrastructure.address.persistence;

import br.com.makersweb.reverse.consumer.domain.address.AddressID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author aaristides
 */
@Entity(name = "Address")
@Table(name = "address")
public class AddressJpaEntity {

    @Id
    private String id;

    @Column(name = "street_name")
    private String streetName;

    @Column(name = "street_number")
    private String streetNumber;

    @Column(name = "city")
    private String city;

    @Column(name = "district")
    private String district;

    @Column(name = "complement")
    private String complement;

    @Column(name = "postal_code")
    private String postalCode;

    public AddressJpaEntity() {}

    private AddressJpaEntity(final AddressID aAddressId) {
        this.id = aAddressId.getValue();
    }

    public static AddressJpaEntity from(final AddressID aAddressId) {
        return new AddressJpaEntity(aAddressId);
    }

    public String getId() {
        return id;
    }

    public AddressJpaEntity setId(String id) {
        this.id = id;
        return this;
    }

    public String getStreetName() {
        return streetName;
    }

    public AddressJpaEntity setStreetName(String streetName) {
        this.streetName = streetName;
        return this;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public AddressJpaEntity setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
        return this;
    }

    public String getCity() {
        return city;
    }

    public AddressJpaEntity setCity(String city) {
        this.city = city;
        return this;
    }

    public String getDistrict() {
        return district;
    }

    public AddressJpaEntity setDistrict(String district) {
        this.district = district;
        return this;
    }

    public String getComplement() {
        return complement;
    }

    public AddressJpaEntity setComplement(String complement) {
        this.complement = complement;
        return this;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public AddressJpaEntity setPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }
}
