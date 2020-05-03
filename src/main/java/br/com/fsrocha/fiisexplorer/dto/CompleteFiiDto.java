package br.com.fsrocha.fiisexplorer.dto;

import java.util.List;
import java.util.Objects;

import br.com.fsrocha.fiisexplorer.model.FiiAssetsEntity;
import br.com.fsrocha.fiisexplorer.model.FiiBasicInformationEntity;
import br.com.fsrocha.fiisexplorer.model.FiiDividendsEntity;
import br.com.fsrocha.fiisexplorer.model.FiiIndicatorsEntity;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CompleteFiiDto {

    /**
     * Símbolo que identifica o FII (Fundo de Investimentos Imobiliários)
     */
    String symbol;

    /**
     * Administrador do fundo imobiliário
     */
    String administrator;

    /**
     * Indicadores do FII
     */
    FiiIndicatorsEntity indicators;

    /**
     * Informações básicas do FII
     */
    FiiBasicInformationEntity basicInformation;

    /**
     * Informations de dividendos do FII
     */
    FiiDividendsEntity dividends;

    /**
     * Ativos do FII
     */
    List<FiiAssetsEntity> assets;

    public CompleteFiiDto() {
    }

    public CompleteFiiDto(String symbol, String administrator, FiiIndicatorsEntity indicators, FiiBasicInformationEntity basicInformation, FiiDividendsEntity dividends, List<FiiAssetsEntity> assets) {
        this.symbol = symbol;
        this.administrator = administrator;
        this.indicators = indicators;
        this.basicInformation = basicInformation;
        this.dividends = dividends;
        this.assets = assets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompleteFiiDto that = (CompleteFiiDto) o;
        return Objects.equals(symbol, that.symbol) &&
                Objects.equals(administrator, that.administrator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol, administrator);
    }
}
