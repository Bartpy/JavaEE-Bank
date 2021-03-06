package pl.wipek.shared.domain.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author Krzysztof Adamczyk on 23.11.2017.
 */
@Entity
@Table(name = "DOMESTIC_BENEFICIARIES")
@XmlRootElement
public class DomesticBeneficiary implements Serializable {
    private String id;
    private String name;
    private String address;
    private String accountNumber;
    private DomesticTransfer domesticTransfer;

    public DomesticBeneficiary() {
    }

    @Id
    @Column(name = "ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "ADDRESS")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "ACCOUNT_NUMBER")
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @ManyToOne
    @JoinColumn(name = "DOMESTIC_TRANSFER_ID")
    @XmlTransient
    public DomesticTransfer getDomesticTransfer() {
        return domesticTransfer;
    }

    public void setDomesticTransfer(DomesticTransfer transfer) {
        this.domesticTransfer = transfer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DomesticBeneficiary that = (DomesticBeneficiary) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(address, that.address) &&
                Objects.equals(accountNumber, that.accountNumber);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, address, accountNumber);
    }

    @Override
    public String toString() {
        return "DomesticBeneficiary{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                '}';
    }
}