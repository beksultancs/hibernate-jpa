package peaksoft.hibernatejpa.model;

import javax.persistence.Embeddable;

/**
 * @author Beksultan
 */
@Embeddable
public class Address {

    private String city;

    private String street;

    private String number;

}
