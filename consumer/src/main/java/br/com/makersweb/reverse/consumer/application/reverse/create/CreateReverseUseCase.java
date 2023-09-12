package br.com.makersweb.reverse.consumer.application.reverse.create;

import br.com.makersweb.reverse.consumer.application.UseCase;
import br.com.makersweb.reverse.consumer.domain.validation.handler.Notification;
import io.vavr.control.Either;

/**
 * @author aaristides
 */
public abstract class CreateReverseUseCase extends UseCase<CreateReverseCommand, Either<Notification, CreateReverseOutput>> {
}
