package com.home.wupupupu.pojo;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.Default;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class Category {
  @NotNull(groups = update.class)
  private Integer id;
  @NotBlank(groups = {add.class,update.class})
  private String categoryName;
  @NotBlank(groups = {add.class,update.class})
  private String categoryAlias;
  private Integer createUser;
  @JsonFormat(pattern = "yyyy-MM-dd  HH:mm:ss")
  private LocalDateTime createTime;
  @JsonFormat(pattern = "yyyy-MM-dd  HH:mm:ss")
  private LocalDateTime updateTime;
  public interface add extends Default {}
  public interface update extends Default{}
}
