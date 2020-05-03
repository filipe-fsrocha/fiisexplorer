package br.com.fsrocha.fiisexplorer.model.projection;

import java.time.LocalDateTime;

public interface FiiProjection {

    String getSymbol();

    String getAdministrator();

    LocalDateTime getUpdateAt();

}
