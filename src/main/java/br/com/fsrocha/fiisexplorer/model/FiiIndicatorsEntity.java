package br.com.fsrocha.fiisexplorer.model;

import java.math.BigInteger;
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
@Table(name = "indicators")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FiiIndicatorsEntity {

    @Id
    @JsonIgnore
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    UUID id;

    @OneToOne
    @JsonBackReference
    @JoinColumn(name = "fii_id", referencedColumnName = "id")
    FiiEntity fii;

    @Column(name = "daily_liquidity")
    BigInteger dailyLiquidity;

    @Column(name = "last_yield")
    Double lastYield;

    @Column(name = "dividend_yield")
    Double dividendsYield;

    @Column(name = "net_worth")
    String netWorth;

    @Column(name = "equity_value")
    Double equityValue;

    @Column(name = "profitability_month")
    Double profitabilityMonth;

    @Column(name = "pvp")
    Double pvp;

    @Column(name = "price")
    Double price;

    @Column(name = "percentage")
    Double percentage;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FiiIndicatorsEntity that = (FiiIndicatorsEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(pvp, that.pvp) &&
                Objects.equals(price, that.price) &&
                Objects.equals(percentage, that.percentage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pvp, price, percentage);
    }
}
