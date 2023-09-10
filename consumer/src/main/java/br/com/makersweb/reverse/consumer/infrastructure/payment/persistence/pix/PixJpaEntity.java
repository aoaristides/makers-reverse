package br.com.makersweb.reverse.consumer.infrastructure.payment.persistence.pix;

import br.com.makersweb.reverse.consumer.domain.payment.pix.PixID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author aaristides
 */
@Entity(name = "Pix")
@Table(name = "pix")
public class PixJpaEntity {

    @Id
    private String id;

    @Column(name = "psp_reference_id")
    private String pspReferenceId;

    @Column(name = "reference_id")
    private String referenceId;

    @Column(name = "message")
    private String message;

    public PixJpaEntity() {}

    private PixJpaEntity(final PixID aPixID) {
        this.id = aPixID.getValue();
    }

    public static PixJpaEntity from(final PixID aPixID) {
        return new PixJpaEntity(aPixID);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPspReferenceId() {
        return pspReferenceId;
    }

    public void setPspReferenceId(String pspReferenceId) {
        this.pspReferenceId = pspReferenceId;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
