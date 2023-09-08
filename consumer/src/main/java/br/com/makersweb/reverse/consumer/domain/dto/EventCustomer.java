package br.com.makersweb.reverse.consumer.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

/**
 * @author aaristides
 * @param name
 * @param document
 * @param phone
 * @param mail
 * @param birthday
 */
public record EventCustomer(
        @JsonProperty("name") String name,
        @JsonProperty("document") String document,
        @JsonProperty("phone") String phone,
        @JsonProperty("mail") String mail,
        @JsonProperty("birthday") LocalDate birthday
) {
}
