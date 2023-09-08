package br.com.makersweb.reverse.consumer.domain;

/**
 * @author aaristides
 * @param <ID>
 */
public abstract class AggregateRoot<ID extends Identifier> extends Entity<ID> {

    protected AggregateRoot(final ID id) {
        super(id);
    }

}
