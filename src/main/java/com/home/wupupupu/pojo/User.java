package com.home.wupupupu.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @NotNull
    private Integer id;
    @Pattern(regexp = "^\\S{5,20}$")
    @NotBlank
    private String username;
    @JsonIgnore
    @Pattern(regexp = "^\\S{5,32}$")
    private String password;
    @NotBlank
    private String nickname;
    @Email
    private String email;
    private String userPic;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
