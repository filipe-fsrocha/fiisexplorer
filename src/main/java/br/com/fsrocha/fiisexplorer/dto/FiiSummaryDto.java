package br.com.fsrocha.fiisexplorer.dto;

import java.time.LocalDateTime;
import java.util.Objects;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * Informações resumidas dos FII's (Fundos de Ivestimentos Imobiliários)
 *
 * @author Filipe Rocha
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FiiSummaryDto {

    /**
     * Símbolo de identificação do FII na bolsa de negociação
     */
    String symbol;

    /**
     * Administradora responsável pelo FII
     */
    String administrator;

    /**
     * Ultima sincronização com o website www.fundsexplorer.com.br
     */
    LocalDateTime updateAt;

    public FiiSummaryDto() {
    }

    public FiiSummaryDto(String symbol, String administrator, LocalDateTime updateAt) {
        this.symbol = symbol;
        this.administrator = administrator;
        this.updateAt = updateAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FiiSummaryDto that = (FiiSummaryDto) o;
        return Objects.equals(symbol, that.symbol) &&
                Objects.equals(updateAt, that.updateAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol, updateAt);
    }
}
