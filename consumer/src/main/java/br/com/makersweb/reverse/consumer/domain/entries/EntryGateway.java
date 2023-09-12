package br.com.makersweb.reverse.consumer.domain.entries;

import java.util.List;

/**
 * @author aaristides
 */
public interface EntryGateway {

    Entry create(final Entry aEntry);

    List<Entry> findByIds(final List<String> ids);

}
