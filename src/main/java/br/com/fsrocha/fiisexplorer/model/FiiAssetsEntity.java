package br.com.fsrocha.fiisexplorer.model;

import java.util.Objects;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * @author Filipe Rocha
 */
@Data
@Entity
@Table(name = "assets_fiis")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FiiAssetsEntity {

    @Id
    @JsonIgnore
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    UUID id;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "fii_id", referencedColumnName = "id")
    FiiEntity fii;

    @Column(name = "name")
    String name;

    @Column(name = "address")
    String address;

    @Column(name = "neighborhood")
    String neighborhood;

    @Column(name = "city")
    String city;

    @Column(name = "gross_leasable_area")
    String grossLeasableArea;

}
