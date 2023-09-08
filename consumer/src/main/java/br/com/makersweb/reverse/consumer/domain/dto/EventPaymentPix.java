package br.com.makersweb.reverse.consumer.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author aaristides
 * @param pspReferenceId
 * @param referenceId
 * @param message
 */
public record EventPaymentPix(
        @JsonProperty("psp_reference_id") String pspReferenceId,
        @JsonProperty("reference_id") String referenceId,
        @JsonProperty("message") String message
) {
}
