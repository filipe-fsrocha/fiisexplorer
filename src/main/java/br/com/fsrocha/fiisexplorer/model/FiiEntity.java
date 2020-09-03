package br.com.fsrocha.fiisexplorer.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AccessLevel;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

/**
 * @author Filipe Rocha
 */
@Data
@Entity
@Table(name = "fii")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FiiEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    UUID id;

    @Column(name = "symbol")
    String symbol;

    @Column(name = "administrator")
    String administrator;

    @Column(name = "update_at")
    LocalDateTime updateAt;

    @OneToOne(mappedBy = "fii")
    @ToString.Exclude
    @JsonManagedReference
    FiiIndicatorsEntity indicators;

    @OneToOne(mappedBy = "fii")
    @ToString.Exclude
    @JsonManagedReference
    FiiBasicInformationEntity basicInformation;

    @OneToOne(mappedBy = "fii")
    @ToString.Exclude
    @JsonManagedReference
    FiiDividendsEntity dividends;

    @OneToMany(mappedBy = "fii")
    @ToString.Exclude
    @JsonManagedReference
    List<FiiAssetsEntity> assets = new ArrayList<>();

}
