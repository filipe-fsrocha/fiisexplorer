package br.com.fsrocha.fiisexplorer.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.fsrocha.fiisexplorer.model.FiiEntity;
import br.com.fsrocha.fiisexplorer.model.projection.FiiProjection;

@Repository
public interface FiiRepository extends JpaRepository<FiiEntity, UUID> {

    @Query("select f from FiiEntity f")
    Page<FiiProjection> listAllFiis(Pageable pageable);

    @Query("select f from FiiEntity f where lower(f.symbol) like :symbol")
    Page<FiiProjection> listFiis(@Param("symbol") String symbol, Pageable pageable);

    @EntityGraph(attributePaths = {"indicators", "basicInformation", "dividends", "assets"})
    @Query("select f from FiiEntity f where lower(f.symbol) = :symbol")
    Optional<FiiEntity> findCompleteFii(@Param("symbol") String symbol);

}
