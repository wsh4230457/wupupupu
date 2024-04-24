package com.home.wupupupu.pojo;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.groups.Default;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

@Data
public class Article {
  @NotNull(groups = update.class)
  private long id;
  @Pattern(regexp = "^\\S{1,10}$")
  @NotBlank(groups = add.class)
  private String title;
  private String content;
  @URL
  private String coverImg;

  private String state;
  @NotNull
  private Integer categoryBelongs;
  private Integer createUser;
  private java.sql.Timestamp createTime;
  private java.sql.Timestamp updateTime;
  public interface add extends Default {}
  public interface update extends Default{}
}
