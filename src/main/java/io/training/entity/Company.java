package io.training.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@Getter
@Setter
@ToString
public class Company {
  @Column(name = "COMPANY_NAME")
  private String companyName;
  @Column
  private String catchPhrase;
  @Column
  private String bs;


}
