package peaksoft.hibernatejpa.model.embeddedclasses;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

/**
 * @author Beksultan
 */
@Embeddable
@Getter @Setter
public class Address {

    private String city;

    private String street;

    private String number;

}
