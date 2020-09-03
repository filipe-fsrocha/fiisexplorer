package br.com.fsrocha.fiisexplorer.model.projection;

import java.time.LocalDateTime;

/**
 * @author Filipe Rocha
 */
public interface FiiProjection {

    String getSymbol();

    String getAdministrator();

    LocalDateTime getUpdateAt();

}
