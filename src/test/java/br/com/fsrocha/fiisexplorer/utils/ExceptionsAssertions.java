package br.com.fsrocha.fiisexplorer.utils;

import java.util.Objects;

import org.assertj.core.api.AbstractThrowableAssert;
import org.assertj.core.api.ThrowableAssert;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.springframework.http.HttpStatus;

import br.com.fsrocha.fiisexplorer.utils.exception.ServiceException;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ExceptionsAssertions {

    public ServiceException catchThrowableServiceException(ThrowingCallable shouldRaiseThrowable) {
        return ThrowableAssert.catchThrowableOfType(shouldRaiseThrowable, ServiceException.class);
    }

    public ServiceExceptionAssert assertThat(ServiceException actual) {
        return new ServiceExceptionAssert(actual);
    }

    public static class ServiceExceptionAssert extends AbstractThrowableAssert<ServiceExceptionAssert, ServiceException> {

        ServiceExceptionAssert(ServiceException actual) {
            super(actual, ServiceExceptionAssert.class);
        }

        public ServiceExceptionAssert hasCategory(HttpStatus category) {
            org.assertj.core.internal.Objects.instance().assertNotNull(info, actual);

            if (!Objects.equals(actual.getErrorCategory(), category)) {
                failWithMessage("Excepted category to be <%s>", category, actual.getErrorCategory());
            }
            return this;
        }
    }
}
