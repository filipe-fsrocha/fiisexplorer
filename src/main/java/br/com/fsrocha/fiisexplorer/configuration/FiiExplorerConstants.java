package br.com.fsrocha.fiisexplorer.configuration;

import lombok.experimental.UtilityClass;

@UtilityClass
public class FiiExplorerConstants {

    public final String REGISTER = "register";
    public final String CONFIRMATION_EMAIL = "confirmationEmail";
    public final String UPDATE_USER = "updateUser/{id}";
    public final String GET_USER = "getUser/{id}";
    public final String CHANGE_PASSWORD = "changePassword";
    public final String DELETE_ACCOUNT = "deleteAccount";

    public final String LIST_FIIS = "listFiis";
    public final String GET_COMPLETE_FII = "getCompleteFii/{symbol}";
}