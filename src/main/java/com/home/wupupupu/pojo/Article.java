package com.home.wupupupu.pojo;

import lombok.Data;

@Data
public class Article {
  private long id;
  private String title;
  private String content;
  private String coverImg;
  private String state;
  private Integer categoryBelongs;
  private Integer createUser;
  private java.sql.Timestamp createTime;
  private java.sql.Timestamp updateTime;
}
