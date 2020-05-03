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
@Table(name = "dividends")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FiiDividendsEntity {

    @Id
    @JsonIgnore
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    UUID id;

    @OneToOne
    @JsonBackReference
    @JoinColumn(name = "fii_id", referencedColumnName = "id")
    FiiEntity fii;

    @Column(name = "earnings")
    String earnings;

    @Column(name = "last_month")
    String lastMonth;

    @Column(name = "three_months")
    String threeMonths;

    @Column(name = "six_months")
    String sixMonths;

    @Column(name = "twelve_months")
    String twelveMonths;

    @Column(name = "since_ipo")
    String sinceIpo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FiiDividendsEntity that = (FiiDividendsEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(earnings, that.earnings) &&
                Objects.equals(lastMonth, that.lastMonth) &&
                Objects.equals(sinceIpo, that.sinceIpo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, earnings, lastMonth, sinceIpo);
    }
}
