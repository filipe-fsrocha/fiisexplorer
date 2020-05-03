package br.com.fsrocha.fiisexplorer.model;

import java.util.Objects;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Entity
@Table(name = "basic_information")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FiiBasicInformationEntity {

    @Id
    @JsonIgnore
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private UUID id;

    @OneToOne
    @JsonBackReference
    @JoinColumn(name = "fii_id", referencedColumnName = "id")
    FiiEntity fii;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "fund_construction_date")
    private String fundConstructionDate;

    @Column(name = "quota_issued")
    private String quotaIssued;

    @Column(name = "initial_equity")
    private String initialEquity;

    @Column(name = "initial_quota_value")
    private String initialQuotaValue;

    @Column(name = "type_management")
    private String typeManagement;

    @Column(name = "rate_performance")
    private String ratePerformance;

    @Column(name = "rate_management")
    private String rateManagement;

    @Column(name = "cnpj")
    private String cnpj;

    @Column(name = "public_something")
    private String publicSomething;

    @Column(name = "mandate")
    private String mandate;

    @Column(name = "followup")
    private String followUp;

    @Column(name = "duration")
    private String duration;

    @Column(name = "rate_administration")
    private String rateAdministration;

    @Column(name = "rate_of_management")
    private String rateOfManagement;

    @Column(name = "rate_consulting")
    private String rateConsulting;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FiiBasicInformationEntity that = (FiiBasicInformationEntity) o;
        return id.equals(that.id) &&
                companyName.equals(that.companyName) &&
                cnpj.equals(that.cnpj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, companyName, cnpj);
    }
}
