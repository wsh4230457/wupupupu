package com.home.wupupupu.pojo;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class Category {
  private long id;
  private String categoryName;
  private String categoryAlias;
  private Integer createUser;
  private LocalDateTime createTime;
  private LocalDateTime updateTime;

}
